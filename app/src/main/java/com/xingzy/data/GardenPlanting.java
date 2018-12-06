package com.xingzy.data;

import java.util.Calendar;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
@Entity(tableName = "garden_plantings",
        foreignKeys = {@ForeignKey(entity = Plant.class, parentColumns = "id", childColumns = "plant_id")},
        indices = {@Index(value = "plant_id")})
public class GardenPlanting {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long gardenPlantingId;

    @ColumnInfo(name = "plant_id")
    private String plantId;

    @ColumnInfo(name = "plant_date")
    private Calendar plantDate;

    @ColumnInfo(name = "last_watering_date")
    private Calendar lastWateringDate;

    @Ignore
    public GardenPlanting(String plantId) {
        this.plantId = plantId;
        this.plantDate = Calendar.getInstance();
        this.lastWateringDate = Calendar.getInstance();
    }

    public GardenPlanting(String plantId, Calendar plantDate, Calendar lastWateringDate) {
        this.plantId = plantId;
        this.plantDate = plantDate;
        this.lastWateringDate = lastWateringDate;
    }

    public long getGardenPlantingId() {
        return gardenPlantingId;
    }

    public void setGardenPlantingId(long gardenPlantingId) {
        this.gardenPlantingId = gardenPlantingId;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public Calendar getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(Calendar plantDate) {
        this.plantDate = plantDate;
    }

    public Calendar getLastWateringDate() {
        return lastWateringDate;
    }

    public void setLastWateringDate(Calendar lastWateringDate) {
        this.lastWateringDate = lastWateringDate;
    }
}
