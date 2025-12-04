package co.edu.udea.certificacion.couriersync.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardInterface extends PageObject {

    // Botón "Ver pedidos" en el dashboard
    public static final Target VER_PEDIDOS_BUTTON = Target.the("Ver pedidos button")
            .locatedBy("//button[normalize-space()='Ver pedidos']");

    // Opción "Perfil" en la barra superior
    public static final Target VER_PERFIL_BUTTON = Target.the("Ver perfil button")
            .locatedBy("//a[normalize-space()='Perfil']");

    // Botón "Ir al inicio"
    public static final Target IR_AL_INICIO_BUTTON = Target.the("Ir al inicio button")
            .locatedBy("//button[normalize-space()='Ir al inicio']");

    // Título "CourierSync" en el header superior
    public static final Target HEADER_TITLE = Target.the("Dashboard header title")
            .locatedBy("//header//h1[contains(text(),'CourierSync')]");

    // Tarjeta "Pedido de prueba"
    public static final Target PEDIDO_DE_PRUEBA_CARD = Target.the("Pedido de prueba card")
            .locatedBy("//h2[normalize-space()='Pedido de prueba']" +
                    "/ancestor::div[contains(@class,'Card')]");

    // Texto "Combo demo domicilio" en la tarjeta del pedido
    public static final Target PEDIDO_COMBO_TITULO = Target.the("Combo demo domicilio title")
            .locatedBy("//p[normalize-space()='Combo demo domicilio']");

    // Botón "Cerrar sesión" (ajusta el texto si en tu app cambia)
    public static final Target CERRAR_SESION_BUTTON = Target.the("Botón Cerrar sesión")
            .locatedBy("//*[self::button or self::a][normalize-space()='Cerrar sesión']");
}