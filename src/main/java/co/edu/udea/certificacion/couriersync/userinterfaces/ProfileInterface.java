package co.edu.udea.certificacion.couriersync.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProfileInterface extends PageObject {

    // Botón "< Volver"
    public static final Target VOLVER_BUTTON = Target.the("Botón Volver en perfil")
            .locatedBy("//button[contains(@class,'courier-back-link')]");

    // Cualquier elemento que contenga el texto "Gracias por tu retroalimentación"
    public static final Target FEEDBACK_TITLE = Target.the("Título de la tarjeta de retroalimentación")
            .locatedBy("//*[contains(normalize-space(),'Gracias por tu retroalimentación')]");
}