package com.xingzy;


import android.os.Bundle;

import com.xingzy.databinding.FragmentGardenBinding;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 *
 * @author xingzhengyi
 */
public class GardenFragment extends Fragment {

    private FragmentGardenBinding binding;

    public GardenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGardenBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

}
