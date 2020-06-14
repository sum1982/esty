/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;

import com.itexps.etsy1.FileUtil;
import com.itexps.etsy1.LoginVO;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author User
 */
public class EtsyTest {

    private WebDriver driver;
    private String baseUrl;
private static LoginVO login = null;

    public EtsyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        login = FileUtil.getLoginData();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
       
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEtsy() throws Exception {
        driver.get("https://www.etsy.com/");

        driver.findElement(By.xpath("//header[@id='gnav-header-inner']/div[4]/nav/ul/li/button")).click();
        driver.findElement(By.id("join_neu_email_field")).click();
        driver.findElement(By.id("join_neu_email_field")).clear();
        driver.findElement(By.id("join_neu_email_field")).sendKeys(login.getEmail());
        driver.findElement(By.id("join_neu_password_field")).click();
        driver.findElement(By.id("join_neu_password_field")).clear();
        driver.findElement(By.id("join_neu_password_field")).sendKeys(login.getPassword());
        driver.findElement(By.name("submit_attempt")).click();
         String title = driver.getTitle();
         assertEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", title);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
