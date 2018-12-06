package com.xingzy.viewmodels;

import android.content.Context;

import com.xingzy.R;
import com.xingzy.data.GardenPlanting;
import com.xingzy.data.PlantAndGardenPlantings;

import java.text.SimpleDateFormat;
import java.util.Locale;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class PlantAndGardenPlantingsViewModel extends ViewModel {

    private Context context;
    private PlantAndGardenPlantings plantings;
    private String plantDateString;
    private String wateringPrefix;
    private String wateringSuffix;

    public PlantAndGardenPlantingsViewModel(Context context, PlantAndGardenPlantings plantings) {
        this.context = context;
        this.plantings = plantings;
        GardenPlanting gardenPlanting = plantings.getGardenPlantings().get(0);
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.US);
        plantDateString = format.format(gardenPlanting.getPlantDate().getTime());
        String waterDateString = format.format(gardenPlanting.getLastWateringDate().getTime());
        wateringPrefix = context.getResources().getString(R.string.watering_next_prefix, waterDateString);
        wateringSuffix = context.getResources().getQuantityString(R.plurals.watering_next_suffix, plantings.getPlant().getWateringInterval(), plantings.getPlant().getWateringInterval());
    }

    public ObservableField<String> imageUrl() {
        return new ObservableField<>(plantings.getPlant().getImageUrl());
    }

    public ObservableField<String> plantDate() {
        String plantDate = context.getResources().getString(R.string.planted_date, plantings.getPlant().getName(), plantDateString);
        return new ObservableField<>(plantDate);
    }

    public ObservableField<String> waterDate() {
        return new ObservableField<>(wateringPrefix + "-" + wateringSuffix);
    }
}
