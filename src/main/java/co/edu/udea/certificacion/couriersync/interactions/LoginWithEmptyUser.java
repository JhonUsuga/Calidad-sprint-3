package co.edu.udea.certificacion.couriersync.interactions;

import co.edu.udea.certificacion.couriersync.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.*;

public class LoginWithEmptyUser implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(GO_TO_LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);
        actor.attemptsTo(Clear.field(USERNAME_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);
        actor.attemptsTo(Click.on(PASSWORD_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);
        actor.attemptsTo(Enter.theValue("Ab3@xyZ!").into(PASSWORD_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);
        actor.attemptsTo(Scroll.to(LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);
        actor.attemptsTo(Click.on(LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);

    }
    public static LoginWithEmptyUser failLogin() {
        return Tasks.instrumented(LoginWithEmptyUser.class);
    }
}