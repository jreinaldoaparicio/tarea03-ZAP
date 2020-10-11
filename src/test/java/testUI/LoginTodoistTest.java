package testUI;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.ShowRegisterPage;
import session.Session;

public class LoginTodoistTest {

    MainPage mainPage = new MainPage();
    ShowRegisterPage showRegisterPage = new ShowRegisterPage();

    @Before
    public void before(){
        Session.getInstance().getDriver().get("https://todoist.com/");
    }

    @DisplayName("verify The Login Using User And Password")
    @Description("This test case is to verify The Login Using User And Password")
    @Owner("Reinaldo")
    @Test
    public void verifyTheLoginUsingUserAndPassword() throws InterruptedException {
        //Set next number_test variable before run the test
        int numberTest=6;

        mainPage.registerButton.click();
        showRegisterPage.emailTextBox.type("mail@mail00"+numberTest+".com");
        showRegisterPage.one_submitButton.click();
        showRegisterPage.fullNameTextBox.type("test00"+numberTest);
        showRegisterPage.passwordTextBox.type("testing00"+numberTest);
        showRegisterPage.two_submitButton.click();
        showRegisterPage.goButton.click();
        showRegisterPage.createButton.click();
        showRegisterPage.openButton.click();

        // Verification
        Thread.sleep(2000);
        Assert.assertFalse("ERROR , no se pudo realizar el login!", showRegisterPage.openButton.isDisplayedOnPage());
    }

    @After
    public void after(){
        Session.getInstance().closeBrowser();
    }


}
