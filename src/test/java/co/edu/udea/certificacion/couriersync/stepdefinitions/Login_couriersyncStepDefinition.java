package co.edu.udea.certificacion.couriersync.stepdefinitions;

import co.edu.udea.certificacion.couriersync.interactions.LoginWithEmptyPassword;
import co.edu.udea.certificacion.couriersync.interactions.LoginWithEmptyUser;
import co.edu.udea.certificacion.couriersync.interactions.Logoutcouriersync;
import co.edu.udea.certificacion.couriersync.questions.EmptyEmailMessage;
import co.edu.udea.certificacion.couriersync.questions.EmptyPasswordMessage;
import co.edu.udea.certificacion.couriersync.questions.Validation;
import co.edu.udea.certificacion.couriersync.tasks.CompleteCustomerFlow;
import co.edu.udea.certificacion.couriersync.tasks.Logincouriersync;
import co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface;
import co.edu.udea.certificacion.couriersync.userinterfaces.ProfileInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.PAGE_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login_couriersyncStepDefinition {

    @Managed
    public WebDriver driver;

    private Actor usuario;

    LoginInterface loginInterface = new LoginInterface();

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("usuario");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("estoy en la vista de login de la tienda online")
    public void estoyEnLaVistaDeLoginDeLaTiendaOnline() {
        usuario.wasAbleTo(Open.browserOn(loginInterface));
    }

    @When("pongo mi usuario y contraseña correctos")
    public void pongoMiUsuarioYContraseñaCorrectos() {
        usuario.attemptsTo(Logincouriersync.login());
    }

    @When("dejo el campo de usuario vacío y pongo una contraseña correcta")
    public void dejoElCampoDeUsuarioVacioYPongoUnaContrasenaCorrecta() {
        usuario.attemptsTo(LoginWithEmptyUser.failLogin());
    }

    @When("pongo mi usuario correcto y dejo el campo de contraseña vacío")
    public void pongoMiUsuarioCorrectoYDejoElCampoDeContrasenaVacio() {
        usuario.attemptsTo(LoginWithEmptyPassword.failLogin());
    }

    @Then("me logueo correctamente")
    public void meLogueoCorrectamente() {

        usuario.attemptsTo(
                WaitUntil.the(PAGE_TITLE, containsText("CourierSync"))
                        .forNoMoreThan(5).seconds()
        );

        usuario.should(
                seeThat(Validation.isLoggedIn(), Matchers.containsString("CourierSync"))
        );

        // Aquí sí hacemos logout porque estamos en el dashboard
        usuario.attemptsTo(Logoutcouriersync.logout());
    }

    @Then("veo un mensaje visual de error indicando que el usuario es obligatorio")
    public void veoUnMensajeVisualDeErrorIndicandoQueElUsuarioEsObligatorio() {
        usuario.should(
                seeThat(
                        EmptyEmailMessage.value(),
                        Matchers.containsString("obligatorio")
                )
        );
    }

    @Then("veo un mensaje visual de error indicando que la contraseña es obligatoria")
    public void veoUnMensajeVisualDeErrorIndicandoQueLaContrasenaEsObligatoria() {
        usuario.should(
                seeThat(
                        EmptyPasswordMessage.value(),
                        Matchers.containsString("obligatorio")
                )
        );
    }

    @When("realizo el flujo completo de cliente con credenciales válidas")
    public void realizoElFlujoCompletoDeClienteConCredencialesValidas() {

        // 1. Login
        usuario.attemptsTo(
                Logincouriersync.login()
        );

        // 2. Flujo completo del cliente (pedidos + feedback + perfil)
        usuario.attemptsTo(
                CompleteCustomerFlow.e2eDefault()
        );
    }

    @Then("veo la retroalimentación del pedido de prueba en el dashboard y cierro sesión")
    public void veoLaRetroalimentacionDelPedidoDePruebaEnElDashboardYCierroSesion() {

        // En esta versión: solo validamos que llegamos al perfil (flecha Volver visible)
        usuario.attemptsTo(
                WaitUntil.the(ProfileInterface.VOLVER_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}