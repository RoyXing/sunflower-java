package com.xingzy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xingzy.PlantListFragmentDirections;
import com.xingzy.data.Plant;
import com.xingzy.databinding.ListItemPlantBinding;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author roy.xing
 * @date 2018/12/6
 */
public class PlantAdapter extends ListAdapter<Plant, PlantAdapter.ViewHolder> {

    public PlantAdapter(@NonNull DiffUtil.ItemCallback<Plant> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemPlantBinding binding = ListItemPlantBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = getItem(position);
        holder.itemView.setTag(plant);
        holder.bind(createOnClickListener(plant.getPlantId()), plant);
    }

    private View.OnClickListener createOnClickListener(String plantId) {
        return v -> {
            PlantListFragmentDirections.ActionPlantListFragmentToPlantDetailFragment directions = new PlantListFragmentDirections.ActionPlantListFragmentToPlantDetailFragment(plantId);
            Navigation.findNavController(v).navigate(directions);
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ListItemPlantBinding binding;

        public ViewHolder(@NonNull View itemView, ListItemPlantBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(View.OnClickListener listener, Plant plant) {
            binding.setClickListener(listener);
            binding.setPlant(plant);
            binding.executePendingBindings();
        }
    }
}
