package com.xingzy.adapters;

import com.xingzy.data.PlantAndGardenPlantings;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class GardenPlantDiffCallback extends DiffUtil.ItemCallback<PlantAndGardenPlantings> {
    @Override
    public boolean areItemsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
        return oldItem.getPlant().getPlantId() == newItem.getPlant().getPlantId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
        return oldItem.getPlant() == newItem.getPlant();
    }
}
