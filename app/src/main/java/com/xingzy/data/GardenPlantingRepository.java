package com.xingzy.data;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class GardenPlantingRepository {

    private GardenPlantingDao gardenPlantingDao;

    private GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }

    public void createGardenPlanting(String plantId) {
        new Thread(() -> gardenPlantingDao.insertGardenPlanting(new GardenPlanting(plantId))).start();
    }

    public void removeGardenPlanting(GardenPlanting gardenPlanting) {
        new Thread(() -> gardenPlantingDao.deleteGardenPlanting(gardenPlanting)).start();
    }

    public LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId) {
        return gardenPlantingDao.getGardenPlantingForPlant(plantId);
    }

    /**
     * @return 取出所种的所有东西
     */
    public LiveData<List<GardenPlanting>> getGardenPlantings() {
        return gardenPlantingDao.getGardenPlantings();
    }


    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return gardenPlantingDao.getPlantAndGardenPlantings();
    }

    private static GardenPlantingRepository repository;

    public synchronized static GardenPlantingRepository getInstance(GardenPlantingDao gardenPlantingDao) {
        if (repository == null) {
            repository = new GardenPlantingRepository(gardenPlantingDao);
        }
        return repository;
    }
}
