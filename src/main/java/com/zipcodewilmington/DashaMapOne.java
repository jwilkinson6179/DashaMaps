package com.zipcodewilmington;

import java.util.function.Function;

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
//            input = input.toLowerCase();
//            return input.charAt(0) - 97;
            Function<String, Integer> hash = keyWord -> input.charAt(0) - 97;
            return hash.apply(input);
        }
        return null;
    }
}