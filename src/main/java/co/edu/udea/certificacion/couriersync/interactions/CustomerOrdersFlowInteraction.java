package co.edu.udea.certificacion.couriersync.interactions;

import co.edu.udea.certificacion.couriersync.userinterfaces.DashboardInterface;
import co.edu.udea.certificacion.couriersync.userinterfaces.OrdersInterface;
import co.edu.udea.certificacion.couriersync.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CustomerOrdersFlowInteraction implements Interaction {

    private final String comentario;

    public CustomerOrdersFlowInteraction(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 1. Ir desde el dashboard a la vista de pedidos
        actor.attemptsTo(Click.on(DashboardInterface.VER_PEDIDOS_BUTTON));
        WaitTime.putWaitTimeOf(800);

        // Esperar a que el título "Pedidos"
        actor.attemptsTo(
                WaitUntil.the(OrdersInterface.PEDIDOS_TITLE, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        // 2. Ver detalles del pedido en curso
        actor.attemptsTo(
                WaitUntil.the(OrdersInterface.BTN_VER_DETALLES_PIZZA, isVisible())
                        .forNoMoreThan(10).seconds(),
                Scroll.to(OrdersInterface.BTN_VER_DETALLES_PIZZA),
                Click.on(OrdersInterface.BTN_VER_DETALLES_PIZZA)
        );
        WaitTime.putWaitTimeOf(800);

        // 3. Cerrar detalles
        actor.attemptsTo(
                WaitUntil.the(OrdersInterface.BTN_CERRAR_MODAL_DETALLES, isVisible())
                        .forNoMoreThan(10).seconds(),
                Scroll.to(OrdersInterface.BTN_CERRAR_MODAL_DETALLES),
                Click.on(OrdersInterface.BTN_CERRAR_MODAL_DETALLES)
        );
        WaitTime.putWaitTimeOf(800);

        // 4. Dejar reseña
        actor.attemptsTo(
                WaitUntil.the(OrdersInterface.BTN_RATING_4_COMBO, isVisible())
                        .forNoMoreThan(10).seconds(),
                Scroll.to(OrdersInterface.BTN_RATING_4_COMBO),
                Click.on(OrdersInterface.BTN_RATING_4_COMBO)
        );
        WaitTime.putWaitTimeOf(400);

        actor.attemptsTo(
                Enter.theValue(comentario)
                        .into(OrdersInterface.TXT_COMENTARIO_ENCUESTA)
        );
        WaitTime.putWaitTimeOf(400);

        actor.attemptsTo(
                Click.on(OrdersInterface.BTN_ENVIAR_ENCUESTA)
        );
        WaitTime.putWaitTimeOf(800);
    }

    public static CustomerOrdersFlowInteraction leaveReview(String comentario) {
        return Tasks.instrumented(CustomerOrdersFlowInteraction.class, comentario);
    }
}