package com.xingzy.viewmodels;

import com.xingzy.data.GardenPlantingRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class GardenPlantingListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GardenPlantingRepository repository;

    public GardenPlantingListViewModelFactory(GardenPlantingRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        GardenPlantingListViewModel viewModel = new GardenPlantingListViewModel(repository);
        return (T) viewModel;
    }
}
