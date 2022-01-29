package com.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Diary {
    private final WebDriver driver;

    public Diary(WebDriver driver) {
        this.driver = driver;
    }

    public void enter(String login) {
        String[] tokens = login.split(" ", 2);
        driver.get("https://edu.tatar.ru/logon");
        driver.findElement(By.cssSelector("input.login-form__input:nth-child(1)")).sendKeys(tokens[0]);
        driver.findElement(By.cssSelector("input.login-form__input:nth-child(2)")).sendKeys(tokens[1]);
        driver.findElement(By.cssSelector("button.button:nth-child(1)")).click();
    }

    public void openDiary(LocalDate date){
        long days = date.getDayOfWeek() == DayOfWeek.SUNDAY ?
                date.plusDays(1).getLong(ChronoField.EPOCH_DAY) :
                date.getLong(ChronoField.EPOCH_DAY);
        driver.get("https://edu.tatar.ru/user/diary/day?for="+days*24*60*60);
    }
}
