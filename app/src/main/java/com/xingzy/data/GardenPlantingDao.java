package com.xingzy.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
@Dao
public interface GardenPlantingDao {

    @Query("select * from garden_plantings")
    LiveData<List<GardenPlanting>> getGardenPlantings();

    @Query("select * from garden_plantings where id = :gardenPlantingId")
    LiveData<List<GardenPlanting>> getGardenPlanting(String gardenPlantingId);

    @Query("select * from garden_plantings where plant_id = :plantId")
    LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId);

    /**
     * This query will tell Room to query both the {@link Plant} and {@link GardenPlanting} tables and handle
     * the object mapping.
     */
    @Transaction
    @Query("select * from plants")
    LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings();

    @Insert
    long insertGardenPlanting(GardenPlanting gardenPlanting);

    @Delete
    void deleteGardenPlanting(GardenPlanting gardenPlanting);
}
