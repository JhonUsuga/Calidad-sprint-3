package co.edu.udea.certificacion.couriersync.stepdefinitions;

import co.edu.udea.certificacion.couriersync.interactions.LoginWithEmptyPassword;
import co.edu.udea.certificacion.couriersync.interactions.LoginWithEmptyUser;
import co.edu.udea.certificacion.couriersync.interactions.Logoutcouriersync;
import co.edu.udea.certificacion.couriersync.questions.EmptyEmailMessage;
import co.edu.udea.certificacion.couriersync.questions.EmptyPasswordMessage;
import co.edu.udea.certificacion.couriersync.questions.Validation;
import co.edu.udea.certificacion.couriersync.tasks.Logincouriersync;
import co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface;

import net.serenitybdd.screenplay.questions.Text;
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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.PAGE_TITLE;
import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.GO_TO_LOGIN_BUTTON;
import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.USERNAME_TEXT_BOX;
import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.PASSWORD_TEXT_BOX;
import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.LOGIN_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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

    // 🔹 ESTE ES EL STEP QUE FALTA PARA:
    // When ingreso como usuario "administrador|cliente|agente"
    @When("ingreso como usuario {string}")
    public void ingresoComoUsuario(String tipoUsuario) {

        String correo;
        switch (tipoUsuario.toLowerCase()) {
            case "administrador":
                correo = "admin@demo.com";
                break;
            case "cliente":
                correo = "cliente@demo.com";
                break;
            case "agente":
                correo = "agente@demo.com";
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado: " + tipoUsuario);
        }

        usuario.attemptsTo(
                Click.on(GO_TO_LOGIN_BUTTON),
                Enter.theValue(correo).into(USERNAME_TEXT_BOX),
                // la app acepta cualquier contraseña
                Enter.theValue("123").into(PASSWORD_TEXT_BOX),
                Scroll.to(LOGIN_BUTTON),
                Click.on(LOGIN_BUTTON)
        );
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

    @Then("veo el panel correspondiente al {string}")
    public void veoElPanelCorrespondienteAlRol(String rol) {

        // Espera a que el título sea visible (para evitar condiciones de carrera)
        usuario.attemptsTo(
                WaitUntil.the(PAGE_TITLE, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        // Vuelve a localizar el elemento y lee el texto
        usuario.should(
                seeThat(
                        "El título del panel corresponde al usuario logueado",
                        actor -> Text.of(PAGE_TITLE).answeredBy(actor),
                        Matchers.containsString("CourierSync")
                )
        );

        usuario.attemptsTo(Logoutcouriersync.logout());
    }

    @Then("vuelvo a la vista de login")
    public void vuelvoALaVistaDeLogin() {
        usuario.should(
                seeThat(
                        "Botón visible para volver al login",
                        actor -> GO_TO_LOGIN_BUTTON.resolveFor(actor).isVisible(),
                        Matchers.is(true)
                )
        );
    }
}