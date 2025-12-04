package co.edu.udea.certificacion.couriersync.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.EMPTY_PASSWORD_MESSAGE;

public class EmptyPasswordMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(EMPTY_PASSWORD_MESSAGE).answeredBy(actor);
    }

    public static EmptyPasswordMessage value() {
        return new EmptyPasswordMessage();
    }
}