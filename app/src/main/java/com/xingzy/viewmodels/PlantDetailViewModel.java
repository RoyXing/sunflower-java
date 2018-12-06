package com.xingzy.viewmodels;

import com.xingzy.data.GardenPlantingRepository;
import com.xingzy.data.Plant;
import com.xingzy.data.PlantRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author roy.xing
 * @date 2018/12/6
 */
public class PlantDetailViewModel extends ViewModel {

    private GardenPlantingRepository plantingRepository;
    private String plantId;
    private LiveData<Plant> plant;
    public LiveData<Boolean> isPlanted;

    public PlantDetailViewModel(GardenPlantingRepository plantingRepository, PlantRepository plantRepository, String plantId) {
        this.plantingRepository = plantingRepository;
        this.plantId = plantId;
        plant = plantRepository.getPlant(plantId);

        isPlanted = Transformations.map(plantingRepository.getGardenPlantingForPlant(plantId), input -> input != null);
    }

    public LiveData<Plant> plant() {
        return plant;
    }

    public void addPlantToGarden() {
        plantingRepository.createGardenPlanting(plantId);
    }
}
