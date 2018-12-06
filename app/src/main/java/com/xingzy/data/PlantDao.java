package com.xingzy.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
@Dao
public interface PlantDao {

    @Query("select * from plants order by name")
    LiveData<List<Plant>> getPlants();

    @Query("select * from plants where growZoneNumber = :growZoneNumber order by name")
    LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber);

    @Query("select * from plants where id=:plantId")
    LiveData<Plant> getPlant(String plantId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Plant> plants);
}
