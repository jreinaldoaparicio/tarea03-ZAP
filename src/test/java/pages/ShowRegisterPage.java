package pages;

import control.Button;
import control.CheckBox;
import control.TextBox;
import org.openqa.selenium.By;

public class ShowRegisterPage {
    public TextBox emailTextBox= new TextBox(By.id("email"),"[email] textbox on Register Page");
    public Button one_submitButton= new Button(By.id("step_one_submit"), "[register_one_step] button on Show Register Page");
    public TextBox fullNameTextBox= new TextBox(By.id("full_name"),"[fullname] textbox Register Page");
    public TextBox passwordTextBox= new TextBox(By.id("pwd"),"[password] textbox textbox Register Page");
    public Button two_submitButton= new Button(By.id("step_two_submit"), "[register] button on Register Page");
    public Button goButton= new Button(By.xpath("/html/body/div[2]/div[1]/button"), "[go] button on Register Page");
    public Button createButton= new Button(By.xpath("/html/body/div[2]/div[2]/button"), "[createTodoist] button on Register Page");
    public Button openButton= new Button(By.xpath("/html/body/div[2]/div[3]/a"), "[openTodoist] button on Register Page");

    public ShowRegisterPage(){}
}
