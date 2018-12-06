package com.xingzy.data;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class PlantAndGardenPlantings {

    @Embedded
    private Plant plant;

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    private List<GardenPlanting> gardenPlantings;

    public PlantAndGardenPlantings(Plant plant, List<GardenPlanting> gardenPlantings) {
        this.plant = plant;
        this.gardenPlantings = gardenPlantings;
    }

    public Plant getPlant() {
        return plant;
    }

    public List<GardenPlanting> getGardenPlantings() {
        return gardenPlantings;
    }
}
