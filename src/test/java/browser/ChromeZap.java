package browser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChromeZap implements IBrowser{
    @Override
    public WebDriver create() {
        String driverPath="D:\\Unidad E - ArchivosP\\Reinaldo\\DIPLOMADO-CATOLICA 2020\\CAPITULO IV - AUTOMATIZACION II MOBILE-REST-API-VULNERABILITY\\PRACTICAS\\tarea03-ZAP\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);

        // informacion para que levante apuntando a un puerto (PROXY)

        // 1 Preferencias
        Map<String,Object> prefs = new HashMap<String,Object>();
        prefs.put("credential_enable_service",false);

        // 2 Proxy --- PORT ---> mismo del OWASP ZAP
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:8888");
        proxy.setSslProxy("127.0.0.1:8888");

        // 3 Capabilities

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("proxy",proxy);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.setExperimentalOption("prefs",prefs);

        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        ChromeDriver driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
