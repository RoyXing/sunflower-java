package com.xingzy.viewmodels;

import com.xingzy.data.GardenPlanting;
import com.xingzy.data.GardenPlantingRepository;
import com.xingzy.data.Plant;
import com.xingzy.data.PlantAndGardenPlantings;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class GardenPlantingListViewModel extends ViewModel {

    private GardenPlantingRepository repository;

    public GardenPlantingListViewModel(GardenPlantingRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<GardenPlanting>> gardenPlantings() {
        return repository.getGardenPlantings();
    }

    public LiveData<List<PlantAndGardenPlantings>> plantAndGardenPlantings() {
        return Transformations.map(repository.getPlantAndGardenPlantings(), gardenPlantings -> {
            List<PlantAndGardenPlantings> plantings = new ArrayList<>();
            for (PlantAndGardenPlantings planting : gardenPlantings) {
                if (planting.getGardenPlantings() != null && planting.getGardenPlantings().size() > 0) {
                    plantings.add(planting);
                }
            }
            return plantings;
        });
    }

}
