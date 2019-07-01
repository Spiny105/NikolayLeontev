package hw4;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected String userName;
    protected String password;
    protected String login;

    @BeforeMethod
    public void setUp() {
        readUserFromFile(".\\src\\test\\resources\\properties\\user.properties");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }

    public void readUserFromFile(String filePath) {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userName = prop.getProperty("user.user.name");
        login = prop.getProperty("user.name");
        password = prop.getProperty("user.password");
    }
}
