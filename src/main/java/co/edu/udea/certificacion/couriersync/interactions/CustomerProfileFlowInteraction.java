package co.edu.udea.certificacion.couriersync.interactions;

import co.edu.udea.certificacion.couriersync.userinterfaces.DashboardInterface;
import co.edu.udea.certificacion.couriersync.userinterfaces.ProfileInterface;
import co.edu.udea.certificacion.couriersync.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CustomerProfileFlowInteraction implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 1. Desde el dashboard ir a la opción "Perfil"
        actor.attemptsTo(
                WaitUntil.the(DashboardInterface.VER_PERFIL_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Scroll.to(DashboardInterface.VER_PERFIL_BUTTON),
                Click.on(DashboardInterface.VER_PERFIL_BUTTON)
        );

        // Esperar para que cargue la vista de perfil
        WaitTime.putWaitTimeOf(800);

        // 2. Validar que aparece la flecha "< Volver"
        actor.attemptsTo(
                WaitUntil.the(ProfileInterface.VOLVER_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    public static CustomerProfileFlowInteraction viewProfileAndLogout() {
        return Tasks.instrumented(CustomerProfileFlowInteraction.class);
    }
}