package com.xingzy;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xingzy.adapters.GardenPlantDiffCallback;
import com.xingzy.adapters.GardenPlantingAdapter;
import com.xingzy.databinding.FragmentGardenBinding;
import com.xingzy.viewmodels.GardenPlantingListViewModel;
import com.xingzy.viewmodels.GardenPlantingListViewModelFactory;
import com.xingzy.utilities.InjectorUtils;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


/**
 * A simple {@link Fragment} subclass.
 *
 * @author xingzhengyi
 */
public class GardenFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentGardenBinding binding = FragmentGardenBinding.inflate(inflater, container, false);
        GardenPlantingAdapter adapter = new GardenPlantingAdapter(new GardenPlantDiffCallback());
        binding.gardenList.setAdapter(adapter);
        subscribeUi(adapter, binding);
        return binding.getRoot();
    }

    private void subscribeUi(GardenPlantingAdapter adapter, FragmentGardenBinding binding) {
        GardenPlantingListViewModelFactory factory = InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext());
        GardenPlantingListViewModel viewModel = ViewModelProviders.of(this, factory).get(GardenPlantingListViewModel.class);

        viewModel.gardenPlantings().observe(getViewLifecycleOwner(), gardenPlantings ->
                binding.setHasPlantings(gardenPlantings != null && !gardenPlantings.isEmpty())
        );

        viewModel.plantAndGardenPlantings().observe(getViewLifecycleOwner(), result -> {
            if (result!=null&&result.size()>0){
                adapter.submitList(result);
            }
        });
    }
}
