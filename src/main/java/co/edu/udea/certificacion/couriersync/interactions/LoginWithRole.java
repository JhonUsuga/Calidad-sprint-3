package co.edu.udea.certificacion.couriersync.interactions;

import co.edu.udea.certificacion.couriersync.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.*;

public class LoginWithRole implements Interaction {

    private final String role;

    public LoginWithRole(String role) {
        this.role = role;
    }

    public static LoginWithRole as(String role) {
        return Tasks.instrumented(LoginWithRole.class, role);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 1. Determinar el correo según el rol
        String email;
        switch (role.toLowerCase()) {
            case "administrador":
                email = "admin@demo.com";
                break;
            case "cliente":
                email = "cliente@demo.com";
                break;
            case "agente":
                email = "agente@demo.com";
                break;
            default:
                throw new IllegalArgumentException("Rol no soportado: " + role);
        }

        // 2. Navegar al formulario de login
        actor.attemptsTo(Click.on(GO_TO_LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);

        // 3. Escribir usuario y una contraseña (cualquiera funciona en esta app)
        actor.attemptsTo(
                Click.on(USERNAME_TEXT_BOX),
                Enter.theValue(email).into(USERNAME_TEXT_BOX)
        );
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(
                Click.on(PASSWORD_TEXT_BOX),
                Enter.theValue("123").into(PASSWORD_TEXT_BOX)   // contraseña dummy
        );
        WaitTime.putWaitTimeOf(800);

        // 4. Hacer clic en el botón de login
        actor.attemptsTo(Scroll.to(LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Click.on(LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);
    }
}

