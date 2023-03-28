import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
    ChromeDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeEach() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Index");

    }
    public void search(){
        By SearchBox=By.cssSelector("#Search_Data");
        WebElement search= driver.findElement(SearchBox);
        search.click();
        search.sendKeys("Rabia");
        By FindBtn=By.cssSelector("input[type='submit']");
        WebElement find= driver.findElement(FindBtn);
        find.click();
    }

    @Test
    public void Task2() throws InterruptedException {
        this.search();
        By FirstName=By.xpath("//table//tr[2]//td[1]");
        WebElement FName= driver.findElement(FirstName);
        Assert.assertTrue(FName.isDisplayed());

        By LastName=By.xpath("//table//tr[2]//td[2]");
        WebElement LName= driver.findElement(LastName);
        Assert.assertTrue(LName.isDisplayed());

        By Editbtn=By.xpath("//button[@style='background-color:blueviolet']");
        WebElement edit= driver.findElement(Editbtn);
        edit.click();

        By LastNameUpdate=By.cssSelector("#LastName");
        WebElement LNameUpdate= driver.findElement(LastNameUpdate);
        LNameUpdate.click();
        LNameUpdate.clear();
        LNameUpdate.sendKeys("Ahm3d");

        By saveBtn=By.xpath("//input[@type='submit']");
        WebElement save= driver.findElement(saveBtn);
        save.click();

        this.search();
        By detailBtn=By.xpath("//button[@style='background-color:forestgreen']");
        WebElement detail= driver.findElement(detailBtn);
        detail.click();

        By backBtn=By.xpath("//div[@class='container body-content']//a[2]");
        WebElement back= driver.findElement(backBtn);
        back.click();

        this.search();
        By deleteBtn=By.xpath("//button[@style='background-color:red']");
        WebElement delete= driver.findElement(deleteBtn);
        delete.click();

        By deleteBtn2=By.cssSelector("input[type='submit']");
        WebElement delete2= driver.findElement(deleteBtn2);
        delete2.click();
    }
    @AfterClass
    public void postCondition() {
      driver.quit();
    }
}