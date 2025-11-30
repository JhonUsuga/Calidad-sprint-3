package co.edu.udea.certificacion.couriersync.stepdefinitions;

import co.edu.udea.certificacion.couriersync.interactions.LoginWithEmptyPassword;
import co.edu.udea.certificacion.couriersync.interactions.LoginWithEmptyUser;
import co.edu.udea.certificacion.couriersync.interactions.Logoutcouriersync;
import co.edu.udea.certificacion.couriersync.questions.EmptyEmailMessage;
import co.edu.udea.certificacion.couriersync.questions.EmptyPasswordMessage;
import co.edu.udea.certificacion.couriersync.questions.Validation;
import co.edu.udea.certificacion.couriersync.tasks.Logincouriersync;
import co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

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

import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.PAGE_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class Login_couriersyncStepDefinition {

    @Managed
    public WebDriver driver;

    private Actor usuario;

    LoginInterface loginInterface = new LoginInterface();

    @Before
    public void config(){
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
}
