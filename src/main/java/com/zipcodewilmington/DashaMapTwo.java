package com.zipcodewilmington;

public class DashaMapTwo extends DashaMap
{
    public DashaMapTwo()
    {
        super();
    }

    protected Integer hashFunction(String input)
    {
        if (input.length() > 1)
        {
            input = input.toLowerCase();
            return input.charAt(1) - 97;
        }
        else
        {
            input = input.toLowerCase();
            return input.charAt(0) - 97;
        }
    }
}