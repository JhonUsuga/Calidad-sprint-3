package co.edu.udea.certificacion.couriersync.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.EMPTY_EMAIL_MESSAGE;

public class EmptyEmailMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(EMPTY_EMAIL_MESSAGE).answeredBy(actor);
    }

    public static EmptyEmailMessage value() {
        return new EmptyEmailMessage();
    }
}
