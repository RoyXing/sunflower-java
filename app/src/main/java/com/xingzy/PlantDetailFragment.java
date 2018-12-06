package com.xingzy;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.xingzy.databinding.FragmentPlantDetailBinding;
import com.xingzy.utilities.InjectorUtils;
import com.xingzy.viewmodels.PlantDetailViewModel;
import com.xingzy.viewmodels.PlantDetailViewModelFactory;

import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


/**
 * A simple {@link Fragment} subclass.
 *
 * @author xingzhengyi
 */
public class PlantDetailFragment extends Fragment {

    private String shareText = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String plantId = "";
        if (getArguments() != null) {
            plantId = PlantDetailFragmentArgs.fromBundle(getArguments()).getPlantId();
        }
        FragmentPlantDetailBinding binding = FragmentPlantDetailBinding.inflate(inflater, container, false);
        PlantDetailViewModelFactory factory = InjectorUtils.providePlantDetailViewModelFactory(requireContext(), plantId);
        PlantDetailViewModel viewModel = ViewModelProviders.of(this, factory).get(PlantDetailViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.fab.setOnClickListener(v -> {
            viewModel.addPlantToGarden();
            Snackbar.make(v, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show();
        });

        viewModel.plant().observe(getViewLifecycleOwner(), plant -> {
            if (plant == null) {
                shareText = "";
            } else {
                shareText = getString(R.string.share_text_plant, plant.getName());
            }
        });

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_plant_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            Intent shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                    .setText(shareText)
                    .setType("text/plain")
                    .createChooserIntent();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // If we're on Lollipop, we can open the intent as a document
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            } else {
                // Else, we will use the old CLEAR_WHEN_TASK_RESET flag
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            }
            startActivity(shareIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
