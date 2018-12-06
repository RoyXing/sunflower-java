package com.xingzy;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.xingzy.adapters.PlantAdapter;
import com.xingzy.adapters.PlantDiffCallback;
import com.xingzy.databinding.FragmentPlantListBinding;
import com.xingzy.utilities.InjectorUtils;
import com.xingzy.viewmodels.PlantListViewModel;
import com.xingzy.viewmodels.PlantListViewModelFactory;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author xingzhengyi
 */
public class PlantListFragment extends Fragment {

    private PlantListViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPlantListBinding binding = FragmentPlantListBinding.inflate(inflater, container, false);
        PlantListViewModelFactory factory = InjectorUtils.providePlantListViewModelFactory(requireContext());
        viewModel = ViewModelProviders.of(this, factory).get(PlantListViewModel.class);
        PlantAdapter adapter = new PlantAdapter(new PlantDiffCallback());
        binding.plantList.setAdapter(adapter);
        subscribeUi(adapter);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_plant_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter_zone: {
                updateData();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateData() {
        if (viewModel.isFiltered()) {
            viewModel.clearGrowZoneNumber();
        } else {
            viewModel.setGrowZoneNumber(9);
        }
    }

    private void subscribeUi(PlantAdapter adapter) {
        viewModel.plantList().observe(getViewLifecycleOwner(), plants -> {
            if (plants != null) {
                adapter.submitList(plants);
            }
        });
    }

}
