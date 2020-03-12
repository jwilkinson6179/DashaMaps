package com.zipcodewilmington;

public interface HashMapX
{
    public void set(String key, Integer value);
    public Boolean delete(String key);
    public Integer get(String key);
    public Boolean isEmpty();
    public Long size();

    public Integer bucketSize(String key);
}