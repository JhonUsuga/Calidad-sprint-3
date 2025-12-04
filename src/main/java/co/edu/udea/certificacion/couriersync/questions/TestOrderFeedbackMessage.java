package co.edu.udea.certificacion.couriersync.questions;

import co.edu.udea.certificacion.couriersync.userinterfaces.ProfileInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TestOrderFeedbackMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {


        WaitUntil.the(ProfileInterface.FEEDBACK_TITLE, isVisible())
                .forNoMoreThan(10).seconds()
                .performAs(actor);


        return Text.of(ProfileInterface.FEEDBACK_TITLE)
                .answeredBy(actor)
                .trim();
    }

    public static TestOrderFeedbackMessage value() {
        return new TestOrderFeedbackMessage();
    }
}