package com.zipcodewilmington;

public class DashaMapOne extends DashaMap
{
    public DashaMapOne()
    {
        super();
    }

    protected Integer hashFunction(String input)
    {
        if (input.length() > 0)
        {
            input = input.toLowerCase();
            return input.charAt(0) - 97;
        }
        return null;
    }
}