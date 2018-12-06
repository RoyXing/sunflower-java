package com.xingzy.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
@Entity(tableName = "plants")
public class Plant {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private String plantId;
    private String name;
    private String description;
    private int growZoneNumber;
    private int wateringInterval;
    private String imageUrl;

    public Plant(@NonNull String plantId, String name, String description, int growZoneNumber) {
        this.plantId = plantId;
        this.name = name;
        this.description = description;
        this.growZoneNumber = growZoneNumber;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrowZoneNumber() {
        return growZoneNumber;
    }

    public void setGrowZoneNumber(int growZoneNumber) {
        this.growZoneNumber = growZoneNumber;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public void setWateringInterval(int wateringInterval) {
        this.wateringInterval = wateringInterval;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
