package com.zipcodewilmington;

import org.junit.Before;
import org.junit.Test;

import java.util.function.BinaryOperator;

import static org.junit.Assert.*;

public class DashaMapOneTest
{
    DashaMapOne test;

    @Before
    public void setup()
    {
        test = new DashaMapOne();
    }

    @Test
    public void addTest()
    {
        Integer expected = 1409;

        test.set("apple", expected);
        Integer actual = test.get("apple");

        assertEquals(expected, actual);
    }

    @Test
    public void getFail()
    {
        Integer expected = null;

        test.set("bagel", 59);
        Integer actual = test.get("apple");

        assertEquals(expected, actual);
    }

    @Test
    public void addThree()
    {
        Integer expected = 20;
        Long expectedSize = 5l;
        String testKey = "artichoke";
        test.set(testKey, 20);
        test.set("apple", 30);
        test.set("avacado", 10);
        test.set("bacon", 100);
        test.set("banana", 200);
        Integer actual = test.get(testKey);
        Long actualSize = test.size();

        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void emptyTestOne()
    {
        assertTrue(test.isEmpty());
    }

    @Test
    public void emptyTestTwo()
    {
        test.set("cookie", 111);
        assertFalse(test.isEmpty());
    }

    @Test
    public void bucketSizeTest()
    {
        Integer expected = 0;
        Integer actual = test.bucketSize("pineapple");

        assertEquals(expected, actual);
    }

    @Test
    public void deleteFromEmpty()
    {
        Boolean expected = false;

        Boolean actual = test.delete("grape");

        assertEquals(expected, actual);
    }

    @Test
    public void deleteKey()
    {
        Integer expected = null;
        String value = "rutabega";

        test.set(value, 564);
        test.set("raddish", 44_112);
        test.set("rabbit", -1_553_664);
        test.set("pear", 0);
        test.set("flounder", 4_553);
        test.delete(value);
        Integer actual = test.get(value);

        assertEquals(expected, actual);
    }

    @Test
    public void bucketTests()
    {
        Long expectedSize = 7L;
        Integer expectedBucketSize = 3;

        test.set("antipasta", 20);
        test.set("apple", 30);
        test.set("avacado", 10);
        test.set("bacon", 100);
        test.set("banana", 200);
        test.set("falafel", 346);
        test.set("potato", 65);

        Integer actualBucketSize = test.bucketSize("antipasta");
        Long actualSize = test.size();

        assertEquals(expectedBucketSize, actualBucketSize);
        assertEquals(expectedSize, actualSize);
    }
}