package co.edu.udea.certificacion.couriersync.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrdersInterface {

    public static final Target PEDIDOS_TITLE = Target.the("Título Pedidos")
            .located(By.xpath("//h1[normalize-space()='Pedidos']"));

    // Puedes dejar este locator o eliminarlo, pero ya NO lo usaremos en la interacción
    public static final Target CARD_PIZZA_MARGARITA = Target.the("Card Pizza margarita")
            .located(By.xpath("(.//*[self::h1 or self::h2 or self::h3 or self::h4 or self::p or self::span]" +
                    "[contains(normalize-space(),'Pizza margarita')])[1]"));

    // Botón Ver detalles (es único en la página)
    public static final Target BTN_VER_DETALLES_PIZZA = Target.the("Botón Ver detalles de pedido en curso")
            .located(By.xpath("//button[normalize-space()='Ver detalles']"));

    // Botón Cerrar SOLO dentro del modal
    public static final Target BTN_CERRAR_MODAL_DETALLES = Target.the("Botón cerrar modal de detalles")
            .located(By.xpath("//div[@role='dialog']//button[normalize-space()='Cerrar']"));

    // --- Locators para Combo demo domicilio ---

    public static final Target CARD_COMBO_DEMO = Target.the("Card Combo demo domicilio")
            .located(By.xpath("(.//*[self::h1 or self::h2 or self::h3 or self::h4 or self::p or self::span]" +
                    "[contains(normalize-space(),'Combo demo domicilio')])[1]"));

    public static final Target BTN_RATING_4_COMBO = Target.the("Botón rating 4 Combo demo domicilio")
            .located(By.xpath("//button[normalize-space()='4']"));

    public static final Target TXT_COMENTARIO_ENCUESTA = Target.the("Texto comentario encuesta Combo demo domicilio")
            .located(By.xpath("//textarea"));

    public static final Target BTN_ENVIAR_ENCUESTA = Target.the("Botón enviar encuesta")
            .located(By.xpath("//button[normalize-space()='Enviar encuesta']"));
}
