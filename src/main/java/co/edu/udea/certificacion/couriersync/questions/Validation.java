package co.edu.udea.certificacion.couriersync.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.couriersync.userinterfaces.LoginInterface.PAGE_TITLE;

public class Validation implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(PAGE_TITLE).getText();
    }

    public static Validation isLoggedIn() {
        return new Validation();
    }
}
