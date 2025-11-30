package co.edu.udea.certificacion.couriersync.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginInterface extends PageObject {

    public static final Target USERNAME_TEXT_BOX = Target.the("Username text box")
            .locatedBy("//*[@id=\"email\"]");

    public static final Target PASSWORD_TEXT_BOX = Target.the("Password text box")
            .locatedBy("//*[@id=\"password\"]");

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("//*[@id=\"main-content\"]/div/div/div[2]/form/button ");

    public static final Target USERNAME_VALUE = Target.the("Logged username label")
            .locatedBy("//div[@class='header_label']//div[text()='Swag Labs']");


    public static final Target EMPTY_PASSWORD_MESSAGE = Target.the("Empty password error message")
            .locatedBy("//*[@id='main-content']/div/div/div[2]/form/div[2]/p");

    public static final Target EMPTY_EMAIL_MESSAGE = Target.the("Empty email error message")
            .locatedBy("//*[@id='email-error']");

    public static final Target PAGE_TITLE = Target.the("Page title")
            .locatedBy("//*[@id=\"main-content\"]/div/div/div[1]/div[1]/div[2]/h1");

    public static final Target GO_TO_LOGIN_BUTTON = Target.the("Go to login button")
            .locatedBy("//*[@id=\"main-content\"]/div/div/div[2]/div/a[1]");


}
