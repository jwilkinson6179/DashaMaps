package com.zipcodewilmington;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO
{
    public static final String HOME = System.getProperty("user.home");

    public static ArrayList<String> readFromFile(String fileName) throws IOException
    {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> readContent = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            readContent.add(line);
        }
        br.close();

        return readContent;
    }
}