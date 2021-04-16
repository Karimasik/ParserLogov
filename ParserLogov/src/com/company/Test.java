package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        LogParser lp = new LogParser(Paths.get("/home/karych/Downloads/log.log"));
        try {
            lp.readAndWrite();
        } catch (IOException e) {
            System.out.println("Возникла ошибка при чтении/записи файла");
        } catch (ParseException e) {
            System.out.println("Ошибка преобразования");
        }
    }
}


