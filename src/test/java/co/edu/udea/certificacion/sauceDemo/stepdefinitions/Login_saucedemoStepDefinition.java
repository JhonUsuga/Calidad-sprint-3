package co.edu.udea.certificacion.sauceDemo.stepdefinitions;

import co.edu.udea.certificacion.sauceDemo.interactions.LoginWithEmptyPassword;
import co.edu.udea.certificacion.sauceDemo.interactions.LoginWithEmptyUser;
import co.edu.udea.certificacion.sauceDemo.interactions.LoginWithInvalidPassword;
import co.edu.udea.certificacion.sauceDemo.interactions.Logoutsaucedemo;
import co.edu.udea.certificacion.sauceDemo.questions.EmptyFields;
import co.edu.udea.certificacion.sauceDemo.questions.InvalidLoginMessage;
import co.edu.udea.certificacion.sauceDemo.questions.Validation;
import co.edu.udea.certificacion.sauceDemo.tasks.Loginsaucedemo;
import co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface;

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

import static co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface.PAGE_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface.USERNAME_VALUE;

import static org.hamcrest.Matchers.equalTo;

public class Login_saucedemoStepDefinition {

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
        usuario.attemptsTo(Loginsaucedemo.login());
    }
    @When("pongo un usuario o una contraseña invalida")
    public void pongoUnUsuarioOUnaContrasenaInvalida() {
        usuario.attemptsTo(LoginWithInvalidPassword.tryLogin());
    }
    @When("dejo el campo de usuario vacío y pongo una contraseña correcta")
    public void dejoElCampoDeUsuarioVacioYPongoUnaContrasenaCorrecta() {
        usuario.attemptsTo(LoginWithEmptyUser.tryLogin());
    }
    @When("pongo mi usuario correcto y dejo el campo de contraseña vacío")
    public void pongoMiUsuarioCorrectoYDejoElCampoDeContrasenaVacio() {
        usuario.attemptsTo(LoginWithEmptyPassword.tryLogin());
    }

    @Then("me logueo correctamente")
    public void meLogueoCorrectamente() {

        usuario.attemptsTo(
                WaitUntil.the(PAGE_TITLE, containsText("Products"))
                        .forNoMoreThan(5).seconds()
        );

        usuario.should(
                seeThat(Validation.isLoggedIn(), Matchers.containsString("Products"))
        );

        usuario.attemptsTo(Logoutsaucedemo.logout());
    }
    @Then("veo un mensaje de error indicando usuario o contraseña inválidos")
    public void veoMensajeDeCredencialesInvalidas() {

        usuario.should(
                seeThat(
                        InvalidLoginMessage.value(),
                        Matchers.containsString("Username and password do not match any user in this service")
                )
        );
    }
    @Then("veo un mensaje visual de error indicando que el usuario es obligatorio")
    public void veoUnMensajeVisualDeErrorIndicandoQueElUsuarioEsObligatorio() {
        usuario.should(
                seeThat(
                        EmptyFields.value(),
                        Matchers.containsString("Username is required")
                )
        );
    }
    @Then("veo un mensaje visual de error indicando que la contraseña es obligatoria")
    public void veoUnMensajeVisualDeErrorIndicandoQueLaContrasenaEsObligatoria() {
        usuario.should(
                seeThat(
                        EmptyFields.value(),
                        Matchers.containsString("Password is required")
                )
        );
    }



}
