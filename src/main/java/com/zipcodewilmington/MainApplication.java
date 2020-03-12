package com.zipcodewilmington;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.zipcodewilmington.FileIO.HOME;
import java.util.logging.Logger;


public class MainApplication
{
    public static void main(String[] args) throws IOException
    {
        DashaMapOne mapOne = new DashaMapOne();
        DashaMapTwo mapTwo = new DashaMapTwo();
        DashaMapThree mapThree = new DashaMapThree();

        ArrayList<String> wordList = FileIO.readFromFile(HOME + "/dev/DashaMaps/word-list.txt");

        for(String element : wordList)
        {
            String[] entry = element.split(" ");
            mapOne.set(entry[0], Integer.valueOf(entry[1]));
            mapTwo.set(entry[0], Integer.valueOf(entry[1]));
            mapThree.set(entry[0], Integer.valueOf(entry[1]));
        }
    }
}