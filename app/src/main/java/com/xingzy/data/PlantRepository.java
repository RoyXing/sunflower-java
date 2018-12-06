package com.xingzy.data;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class PlantRepository {

    private PlantDao plantDao;

    private static PlantRepository repository;

    private PlantRepository(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    public synchronized static PlantRepository getInstance(PlantDao plantDao) {
        if (repository == null) {
            repository = new PlantRepository(plantDao);
        }
        return repository;
    }

    public LiveData<List<Plant>> getPlants() {
        return plantDao.getPlants();
    }

    public LiveData<Plant> getPlant(String plantId) {
        return plantDao.getPlant(plantId);
    }

    public LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber) {
        return plantDao.getPlantsWithGrowZoneNumber(growZoneNumber);
    }
}
