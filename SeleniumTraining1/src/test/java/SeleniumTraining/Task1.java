package SeleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task1 {
    ChromeDriver driver;
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void beforeEach(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.get("http://uitestpractice.com/Students/Widgets");

    }
    @Test
    public  void FirstTest() throws InterruptedException {
        By searchElementByName= By.xpath("//input[@name='image_file']");
        WebElement chooseFile= driver.findElement(searchElementByName);
        chooseFile.sendKeys("C:\\Users\\rabia.ahmed\\OneDrive - 10Pearls\\Pictures\\Picture1.jpg");//upload image
        By searchImage = By.xpath("//img[@id='preview']");
        WebElement image= driver.findElement(searchImage);
        Assert.assertTrue(image.isDisplayed()); //assertion to check image is uploaded
    }
    @Test
    public void FormFill() throws InterruptedException{
        By textForm =By.xpath("//*[contains(@href,'Form')]");
        WebElement form= driver.findElement(textForm);
        form.click();
        // Filling Form by using CSS selectors.
        By firstName=By.cssSelector(".col-sm-10> #firstname");
        WebElement FirstNameField= driver.findElement(firstName);
        FirstNameField.click();
        FirstNameField.sendKeys("Rabia");
        By lastName=By.cssSelector(".col-sm-10> #lastname");
        WebElement lastNameField= driver.findElement(lastName);
        lastNameField.click();
        lastNameField.sendKeys("Ahmed");
        //As there is no locator for the status option ,so I am using list of status
        List<WebElement> MaritalStatusList=driver.findElements(By.cssSelector("input[type='radio']"));
        for(int i=0;i<MaritalStatusList.size();i++){
            WebElement MaritalStatus= MaritalStatusList.get(i);
            String value=MaritalStatus.getAttribute("value");
            if(value.equalsIgnoreCase("Single ")){
                MaritalStatus.click();
            }
        }
        //Hobby radio button
        By HobbyList=By.cssSelector("input[value='read']");
        WebElement Hobby= driver.findElement(HobbyList);
        Hobby.click();

        By countryName=By.cssSelector("#sel1");
        WebElement country= driver.findElement(countryName);
        Select CountryName=new Select(country);
        CountryName.selectByVisibleText("Canada");

        By datePicker=By.cssSelector("#datepicker");
        WebElement dateOfBirth= driver.findElement(datePicker);
        dateOfBirth.click();
        By monthName=By.cssSelector(".ui-datepicker-month");
        WebElement month= driver.findElement(monthName);
        Select MonthName=new Select(month);
        MonthName.selectByVisibleText("May");
        By yearList=By.cssSelector(".ui-datepicker-year");
        WebElement year= driver.findElement(yearList);
        Select yearLists=new Select(year);
        yearLists.selectByVisibleText("1998");
        By date=By.xpath("//table[@class='ui-datepicker-calendar']//tr[3]//td[4]");
        WebElement day= driver.findElement(date);
        day.click();
        By number=By.cssSelector("#phonenumber");
        WebElement phoneNumber= driver.findElement(number);
        phoneNumber.sendKeys("1234565677");
        By name=By.cssSelector("#username");
        WebElement username= driver.findElement(name);
        username.sendKeys("Rabia");
        By email=By.cssSelector("#email");
        WebElement userEmail= driver.findElement(email);
        userEmail.sendKeys("Rabia@gmail.com");
        By comment=By.cssSelector("#comment");
        WebElement commentBox= driver.findElement(comment);
        commentBox.sendKeys("Hello");
        By pass=By.cssSelector("#pwd");
        WebElement password= driver.findElement(pass);
        password.sendKeys("12222");
        By button=By.cssSelector(".btn-default ");
        WebElement submit= driver.findElement(button);
        submit.click();
    }
    @AfterClass
    public void postCondition(){
       driver.quit();
    }
}
