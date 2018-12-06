package com.xingzy.adapters;

import com.xingzy.data.Plant;
import com.xingzy.data.PlantAndGardenPlantings;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class PlantDiffCallback extends DiffUtil.ItemCallback<Plant> {

    @Override
    public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
        return oldItem.getPlantId().equals(newItem.getPlantId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
        return oldItem == newItem;
    }
}
