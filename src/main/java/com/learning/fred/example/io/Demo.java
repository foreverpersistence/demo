package com.learning.fred.example.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author fred
 * @date 2020/12/22 09:18
 * @description todo
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/fred-zhang/Documents/my-project/mock-demo/src/main/resources/application.properties");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int length = 0;
        while ((length = bufferedInputStream.read()) != 0) {

            System.out.println(length);
        }

        char[] chars = new char[1024];
        int index=0;

        FileReader fr = new FileReader("/Users/fred-zhang/Documents/my-project/mock-demo/src/main/resources/application.properties");


        while ((index=fr.read(chars)) != 0) {
            System.out.println(new String(chars));
        }


    }
}
