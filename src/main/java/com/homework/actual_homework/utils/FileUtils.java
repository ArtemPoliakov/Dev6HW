package com.homework.actual_homework.utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;

public class FileUtils {
    @SneakyThrows
    public static String readWholeFile(String path){
        String response = "";
        try(FileInputStream fis = new FileInputStream(path)){
            byte[] bytes = fis.readAllBytes();
            response = new String(bytes);
        }catch(IOException e){
            e.printStackTrace();
        }
        return response;
    }
}
