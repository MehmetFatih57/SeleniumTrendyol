package TrendyolProje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_Trendyol {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Trendyol sayfasina git
        driver.get("https://www.trendyol.com/");
        Thread.sleep(1000);

        //Cikan reklamda cinsiyet secimi yap
        WebElement buton = driver.findElement(By.xpath("//img[@src='https://cdn.dsmcdn.com/web/production/new-gender-popup-male.png']"));
        buton.click();
        Thread.sleep(2000);

        //Ana sayfadan bir kategori sec
        WebElement anneCocuk = driver.findElement(By.xpath("//a[@href='/butik/liste/3/anne--cocuk']"));
        anneCocuk.click();
        Thread.sleep(2000);

        //Secilen kategorinin icinde bir kategori basligi sec ve secilen kategoriden bir urun isaretle
        WebElement ayakkabi = driver.findElement(By.xpath("(//img[@loading='lazy'])[7]"));
        ayakkabi.click();
        Thread.sleep(2000);

        //Secilen urunu sepete ekle
        WebElement urun = driver.findElement(By.xpath("(//span[@class='prdct-desc-cntnr-name hasRatings'])[2]"));
        urun.click();
        Thread.sleep(2000);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        WebElement sepeteEkle = driver.findElement(By.xpath("//*[.='Sepete Ekle']"));
        sepeteEkle.click();
        Thread.sleep(3000);

        //Sepete git
        WebElement sepet = driver.findElement(By.xpath("//div[@class='account-nav-item basket-preview']"));
        sepet.click();
        Thread.sleep(2000);

        //Sepeti onayla
        WebElement sepetiOnayla = driver.findElement(By.xpath("//a[@class='ty-link-btn-primary']"));
        sepetiOnayla.click();
        Thread.sleep(2000);

        //Bir mail adresi giriniz
        WebElement email = driver.findElement(By.xpath("(//input[@class='q-input'])[1]"));
        email.sendKeys("mehmet.fatihh57@gmail.com");
        Thread.sleep(2000);

        //Bir password giriniz
        WebElement password = driver.findElement(By.xpath("(//input[@class='q-input'])[2]"));
        password.sendKeys("MFY5757.");
        Thread.sleep(2000);

        //Giris Yap butonuna tiklayiniz
        WebElement girisYap = driver.findElement(By.xpath("//button[@class='q-primary q-fluid q-button-medium q-button submit']"));
        girisYap.click();
        Thread.sleep(2000);

        //"E-posta adresiniz ve/veya şifreniz hatalı" texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
       WebElement sonuc = driver.findElement(By.xpath("//span[@class='message']"));
       System.out.println(sonuc.getText());
       if(sonuc.isDisplayed()){
           System.out.println("Kayit Yapilamadi");
       }else{
           System.out.println("Kayit Yapildi");
       }
        Thread.sleep(2000);

       /*
                IF-ELSE 2.YOL
       String actualText = driver.getPageSource();
       String expectedText = "E-posta adresiniz ve/veya şifreniz hatalı";
       if (actualText.contains(expectedText)){
           System.out.println("Kayıt yapılamadı");
       }else {
           System.out.println("Kayıt yapıldı");
       }
       Thread.sleep(3000);
       */

        //Tekrar sepete don
        driver.navigate().back();
        Thread.sleep(2000);

        //Sepete ekledigin urunu sil
        WebElement sil = driver.findElement(By.xpath("//i[@class='i-trash']"));
        sil.click();
        Thread.sleep(2000);

        //Tekrar sectigin urune git
        driver.navigate().back();
        Thread.sleep(2000);

        //Sayfayi kapat
        driver.close();

        Thread.sleep(3000);

        //Bir onceki kategoriye don
        List<String> windows1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(0));
        Thread.sleep(2000);

        //Ilk sectigin kategoriye don
        driver.navigate().back();

        //Ana sayfaya don
        driver.navigate().back();

        //Sepete git
        WebElement sepet2 = driver.findElement(By.xpath("(//p[@class='link-text'])[3]"));
        sepet2.click();

        //Geri don
        driver.navigate().back();
        Thread.sleep(2000);

        //Tekrar anne/cocuk kategorisine tikla
        WebElement anneCocuk2 = driver.findElement(By.xpath("//a[@href='/butik/liste/3/anne--cocuk']"));
        anneCocuk2.click();
        Thread.sleep(2000);

        //Ayakkabi bolumunun yanindaki Oto koltugu bolumune tikla
        WebElement ayakkabi2 = driver.findElement(By.xpath("(//img[@loading='lazy'])[7]"));
        Thread.sleep(2000);
        WebElement otoKoltugu = driver.findElement(with(By.tagName("a")).toRightOf(ayakkabi2));
        Thread.sleep(2000);
        otoKoltugu.click();
        Thread.sleep(3000);

        //Sayfayi kapat
        driver.close();
    }
}
