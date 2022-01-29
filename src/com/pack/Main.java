package com.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;


public class Main {

    public static WebDriver driver;

    public static void main(String[] args) throws IOException {
        String path = new File("").getAbsolutePath();

        System.setProperty("webdriver.gecko.driver", path + "/geckodriver-v0.30.0-win64/geckodriver.exe");
        driver = new FirefoxDriver();

        String[] info = new BufferedReader(new FileReader(path + "/src/info.txt")).readLine().split(" ");
        login(info[0], info[1]);
        openDiary();
    }

    private static void login(String login, String password){
        driver.get("https://edu.tatar.ru/logon");
        driver.findElement(By.cssSelector("input.login-form__input:nth-child(1)")).sendKeys(login);
        driver.findElement(By.cssSelector("input.login-form__input:nth-child(2)")).sendKeys(password);
        driver.findElement(By.cssSelector("button.button:nth-child(1)")).click();
    }

    private static void openDiary(){
        long days = LocalDate.now().plusDays(1).getDayOfWeek() == DayOfWeek.SUNDAY ?
                LocalDate.now().plusDays(2).getLong(ChronoField.EPOCH_DAY) :
                LocalDate.now().plusDays(1).getLong(ChronoField.EPOCH_DAY);
        driver.get("https://edu.tatar.ru/user/diary/day?for="+days*24*60*60);
    }
}
