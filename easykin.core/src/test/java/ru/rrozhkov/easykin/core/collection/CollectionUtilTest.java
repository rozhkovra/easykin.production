package ru.rrozhkov.easykin.core.collection;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by rrozhkov on 05.07.2018.
 */
public class CollectionUtilTest {

    @Test
    public void testIsNullOrEmpty() {
        boolean flag = CollectionUtil.isNullOrEmpty(null);
        Assert.assertTrue(flag);
        flag = CollectionUtil.isNullOrEmpty(new ArrayList());
        Assert.assertTrue(flag);
    }

    @Test
    public void testCopy() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<Integer> copy = (List)CollectionUtil.copy(list);
        Assert.assertTrue(list.size() == copy.size());
        Assert.assertTrue(list.get(0).equals(copy.get(0)));
        Assert.assertTrue(list.get(1).equals(copy.get(1)));
    }

    @Test
    public void testCreate() throws Exception {
        Collection collection = CollectionUtil.create();
        Assert.assertTrue(collection!=null);
        Assert.assertTrue(collection.isEmpty());
        Assert.assertTrue(collection instanceof LinkedList);

        collection = CollectionUtil.create(1,2,3);
        Assert.assertTrue(collection!=null);
        Assert.assertTrue(collection.size()==3);
    }

    @Test
    public void testMap() throws Exception {
        Map map = CollectionUtil.map();
        Assert.assertTrue(map!=null);
        Assert.assertTrue(map.isEmpty());
        Assert.assertTrue(map instanceof HashMap);
    }

    @Test
    public void testGet() throws Exception {
        Collection collection = CollectionUtil.create(1,2,3);
        Integer value = (Integer)CollectionUtil.get(collection, 1);
        Assert.assertTrue(value!=null);
        Assert.assertTrue(value.equals(2));
    }
}
