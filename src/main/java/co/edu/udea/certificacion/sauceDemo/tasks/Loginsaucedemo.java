package co.edu.udea.certificacion.sauceDemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import co.edu.udea.certificacion.sauceDemo.interactions.LoginsaucedemoInteraction;

public class Loginsaucedemo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                LoginsaucedemoInteraction.userAndPassword()
        );
    }

    public static Loginsaucedemo login() {
        return Tasks.instrumented(Loginsaucedemo.class);
    }
}
