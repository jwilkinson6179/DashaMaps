package com.zipcodewilmington;

abstract public class DashaMap implements HashMapX
{

    private Node[] hashArray = new Node[26];
    private Long size;

    public DashaMap()
    {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for (Integer i = 0; i < alphabet.length; i++)
        {
            hashArray[i] = new Node(alphabet[i], null, null);
        }

        size = 0L;
    }

    abstract Integer hashFunction(String input);

    @Override
    public void set(String key, Integer value)
    {
        Integer keyHash = hashFunction(key);
        Node newVal = new Node(key, value, null);
        appendTo(hashArray[keyHash], newVal);
    }

    public void appendTo(Node hash, Node newVal)
    {
        while(hash.hasNext())
        {
            hash = hash.next();
        }

        hash.linkNext(newVal);
        size++;
    }

    @Override
    public Boolean delete(String key)
    {
        Integer keyHash = hashFunction(key);

        Node currentNode = hashArray[keyHash];
        Node nextNode = currentNode.next();

        while(nextNode != null)
        {
            if(nextNode.getKey().equalsIgnoreCase(key))
            {
                currentNode.linkNext(nextNode.next());
            }
            currentNode = nextNode;
            nextNode = nextNode.next();

            return true;
        }

        return false;
    }

    @Override
    public Integer get(String key)
    {
        Integer keyHash = hashFunction(key);

        Node searchedNode = findIn(keyHash, key);
        if(searchedNode != null)
        {
            return searchedNode.getValue();
        }
        else
        {
            return null;
        }
    }

    public Node findIn(Integer keyHash, String keyWord)
    {
        Node currentNode = hashArray[keyHash];

        while(currentNode != null)
        {
            if(currentNode.getKey().equals(keyWord))
            {
                return currentNode;
            }
            currentNode = currentNode.next();
        }
        return null;
    }

    @Override
    public Boolean isEmpty()
    {
        return (size.equals(0L));
    }

    @Override
    public Long size()
    {
        return size;
    }

    @Override
    public Integer bucketSize(String key)
    {
        Integer hashKey = hashFunction(key);

        Integer bucketCount = 0;

        Node currentNode = hashArray[hashKey].next();
        while(currentNode != null)
        {
            bucketCount++;
            currentNode = currentNode.next();
        }

        return bucketCount;
    }
}
