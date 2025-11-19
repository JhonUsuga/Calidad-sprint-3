package co.edu.udea.certificacion.sauceDemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface.INVALID_LOGIN_MESSAGE;

public class EmptyFields implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(INVALID_LOGIN_MESSAGE).answeredBy(actor);
    }

    public static EmptyFields value() {
        return new EmptyFields();
    }
}
