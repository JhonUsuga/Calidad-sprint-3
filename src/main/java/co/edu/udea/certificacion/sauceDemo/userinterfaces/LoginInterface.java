package co.edu.udea.certificacion.sauceDemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginInterface extends PageObject {

    public static final Target USERNAME_TEXT_BOX = Target.the("Username text box")
            .locatedBy("//*[@id='user-name']");

    public static final Target PASSWORD_TEXT_BOX = Target.the("Password text box")
            .locatedBy("//*[@id='password']");

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("//*[@id='login-button']");

    public static final Target USERNAME_VALUE = Target.the("Logged username label")
            .locatedBy("//div[@class='header_label']//div[text()='Swag Labs']");

    public static final Target INVALID_LOGIN_MESSAGE = Target.the("Invalid login error message")
            .locatedBy("//h3[@data-test='error']");

    public static final Target PAGE_TITLE = Target.the("Page title")
            .locatedBy("//span[@data-test='title']");

}
