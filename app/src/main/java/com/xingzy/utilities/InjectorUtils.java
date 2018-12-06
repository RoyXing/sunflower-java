package com.xingzy.utilities;

import android.content.Context;

import com.xingzy.data.AppDatabase;
import com.xingzy.data.GardenPlantingRepository;
import com.xingzy.data.PlantRepository;
import com.xingzy.viewmodels.GardenPlantingListViewModelFactory;
import com.xingzy.viewmodels.PlantDetailViewModelFactory;
import com.xingzy.viewmodels.PlantListViewModelFactory;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class InjectorUtils {

    private static PlantRepository getPlantRepository(Context context) {
        return PlantRepository.getInstance(AppDatabase.getInstance(context).plantDao());
    }

    private static GardenPlantingRepository getGardenPlantingRepository(Context context) {
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context).gardenPlantingDao());
    }

    public static GardenPlantingListViewModelFactory provideGardenPlantingListViewModelFactory(Context context) {
        return new GardenPlantingListViewModelFactory(getGardenPlantingRepository(context));
    }

    public static PlantListViewModelFactory providePlantListViewModelFactory(Context context) {
        return new PlantListViewModelFactory(getPlantRepository(context));
    }

    public static PlantDetailViewModelFactory providePlantDetailViewModelFactory(Context context, String plantId) {
        return new PlantDetailViewModelFactory(getGardenPlantingRepository(context),
                getPlantRepository(context)
                ,plantId);
    }
}
