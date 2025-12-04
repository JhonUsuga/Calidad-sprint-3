package co.edu.udea.certificacion.couriersync.tasks;

import co.edu.udea.certificacion.couriersync.interactions.LogincouriersyncInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Logincouriersync implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                LogincouriersyncInteraction.userAndPassword()
        );
    }

    public static Logincouriersync login() {
        return Tasks.instrumented(Logincouriersync.class);
    }
}