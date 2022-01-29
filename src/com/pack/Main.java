package com.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException {
        String path = new File("").getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", path + "/geckodriver-v0.30.0-win64/geckodriver.exe");

        Diary diary = new Diary(new FirefoxDriver());
        diary.enter(Files.readAllLines(Path.of(path + "/src/info.txt")).get(0));
        diary.openDiary(LocalDate.now());
    }




}
