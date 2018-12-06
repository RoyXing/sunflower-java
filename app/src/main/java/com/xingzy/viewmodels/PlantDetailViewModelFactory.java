package com.xingzy.viewmodels;

import com.xingzy.data.GardenPlantingRepository;
import com.xingzy.data.PlantRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author roy.xing
 * @date 2018/12/6
 */
public class PlantDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GardenPlantingRepository gardenPlantingRepository;
    private PlantRepository plantRepository;
    private String plantId;

    public PlantDetailViewModelFactory(GardenPlantingRepository gardenPlantingRepository, PlantRepository plantRepository, String plantId) {
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantRepository = plantRepository;
        this.plantId = plantId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantDetailViewModel(gardenPlantingRepository, plantRepository, plantId);
    }
}
