package com.xingzy.viewmodels;

import com.xingzy.data.PlantRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author roy.xing
 * @date 2018/12/6
 */
public class PlantListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private PlantRepository plantRepository;

    public PlantListViewModelFactory(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantListViewModel(plantRepository);
    }
}
