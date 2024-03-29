package com.cloud.xue.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcess {
    public static void main(String[] args) {
        String fileName = "/Users/xuexiao/wxdb.txt";

        readFileByLines(fileName);
    }

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                if(tempString.contains("\"")){
                    //tempString = tempString.substring(tempString.indexOf("（") +1, tempString.indexOf("）"));
                    tempString = tempString.toUpperCase().replace("\"", "").replace("\"", "");
                }
                System.out.println(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
