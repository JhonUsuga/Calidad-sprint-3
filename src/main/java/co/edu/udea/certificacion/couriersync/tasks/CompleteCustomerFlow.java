package co.edu.udea.certificacion.couriersync.tasks;

import co.edu.udea.certificacion.couriersync.interactions.CustomerOrdersFlowInteraction;
import co.edu.udea.certificacion.couriersync.interactions.CustomerProfileFlowInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CompleteCustomerFlow implements Task {

    private final String comentario;

    public CompleteCustomerFlow(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 1. Flujo de pedidos: ver detalles y dejar comentario
        actor.attemptsTo(
                CustomerOrdersFlowInteraction.leaveReview(comentario)
        );

        // 2. Flujo en Perfil: ingresar y comprobar que carga (flecha)
        actor.attemptsTo(
                CustomerProfileFlowInteraction.viewProfileAndLogout()
        );
    }

    // Factory por defecto
    public static CompleteCustomerFlow e2eDefault() {
        return Tasks.instrumented(CompleteCustomerFlow.class, "muy interesante");
    }
}