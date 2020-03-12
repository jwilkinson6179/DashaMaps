package com.zipcodewilmington;

public class DashaMapThree extends DashaMap
{
    public DashaMapThree()
    {
        super();
    }

    protected Integer hashFunction(String input)
    {
        if (input.length() > 1)
        {
            input = input.toLowerCase();
            return (input.charAt(0) + input.charAt(1) - 97) % 26;
        }
        else
        {
            input = input.toLowerCase();
            return (input.charAt(0) - 97) % 26;

        }
    }
}