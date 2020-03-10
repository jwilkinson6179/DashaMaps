package com.zipcodewilmington;

public class Node
{
    private String key;
    private Integer value;
    private Node next;

    public Node()
    {
        this(null, null, null);
    }

    public Node(String key, Integer value, Node next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public String getKey()
    {
        return key;
    }

    public Integer getValue()
    {
        return value;
    }

    public Node next()
    {
        if(hasNext())
        {
            return next;
        }
        else
        {
            return null;
        }
    }

    public void linkNext(Node addedNode)
    {
        next = addedNode;
    }

    public Boolean hasNext()
    {
        return (next != null);
    }
}