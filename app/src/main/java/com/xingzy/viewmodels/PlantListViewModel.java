package com.xingzy.viewmodels;

import com.xingzy.data.Plant;
import com.xingzy.data.PlantRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author roy.xing
 * @date 2018/12/6
 */
public class PlantListViewModel extends ViewModel {

    private static final int NO_GROW_ZONE = -1;
    private MutableLiveData<Integer> growZoneNumber;
    private MediatorLiveData<List<Plant>> plantList;

    public PlantListViewModel(PlantRepository plantRepository) {
        growZoneNumber = new MutableLiveData<>();
        plantList = new MediatorLiveData<>();
        growZoneNumber.setValue(NO_GROW_ZONE);

        LiveData<List<Plant>> livePlantList = Transformations.switchMap(growZoneNumber, it -> {
            if (it == NO_GROW_ZONE) {
                return plantRepository.getPlants();
            } else {
                return plantRepository.getPlantsWithGrowZoneNumber(it);
            }
        });
        plantList.addSource(livePlantList, plantList::setValue);
    }

    public LiveData<List<Plant>> plantList() {
        return plantList;
    }

    public void setGrowZoneNumber(int number) {
        growZoneNumber.setValue(number);
    }

    public void clearGrowZoneNumber() {
        growZoneNumber.setValue(NO_GROW_ZONE);
    }

    public boolean isFiltered() {
        return NO_GROW_ZONE != growZoneNumber.getValue();
    }
}
