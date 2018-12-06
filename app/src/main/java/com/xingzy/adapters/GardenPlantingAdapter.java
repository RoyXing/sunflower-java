package com.xingzy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xingzy.GardenFragmentDirections;
import com.xingzy.R;
import com.xingzy.data.PlantAndGardenPlantings;
import com.xingzy.databinding.ListItemGardenPlantingBinding;
import com.xingzy.viewmodels.PlantAndGardenPlantingsViewModel;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class GardenPlantingAdapter extends ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder> {

    public GardenPlantingAdapter(@NonNull DiffUtil.ItemCallback<PlantAndGardenPlantings> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemGardenPlantingBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item_garden_planting, parent, false);
        return new ViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlantAndGardenPlantings plantings = getItem(position);
        holder.itemView.setTag(plantings);
        holder.bind(createOnClickListener(plantings.getPlant().getPlantId()), plantings);

    }

    private View.OnClickListener createOnClickListener(String plantId) {
        return v -> {
            GardenFragmentDirections.ActionGardenFragmentToPlantDetailFragment direction = new GardenFragmentDirections.ActionGardenFragmentToPlantDetailFragment(plantId);
            Navigation.findNavController(v).navigate(direction);
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ListItemGardenPlantingBinding binding;

        public ViewHolder(@NonNull View itemView, ListItemGardenPlantingBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(View.OnClickListener onClickListener, PlantAndGardenPlantings plantings) {
            binding.setClickListener(onClickListener);
            binding.setViewModel(new PlantAndGardenPlantingsViewModel(itemView.getContext(), plantings));
            binding.executePendingBindings();
        }
    }
}
