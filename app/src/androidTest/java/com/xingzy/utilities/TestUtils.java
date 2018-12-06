package com.xingzy.utilities;

import com.xingzy.data.Plant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class TestUtils {

    public static List<Plant> testPlants() {
        List<Plant> list = new ArrayList<>();
        list.add(new Plant("1", "Apple", "A red fruit", 1));
        list.add(new Plant("2", "Pair", "A red fruit", 1));
        list.add(new Plant("3", "Orange", "A red fruit", 2));
        list.add(new Plant("4", "Strawberry", "A red fruit", 2));
        return list;
    }

    public static List<Plant> plants = testPlants();
    public static Plant testPlant = plants.get(0);

}
