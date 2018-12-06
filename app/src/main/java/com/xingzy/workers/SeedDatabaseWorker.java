package com.xingzy.workers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.xingzy.data.AppDatabase;
import com.xingzy.data.Plant;
import com.xingzy.utilities.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class SeedDatabaseWorker extends Worker {

    public SeedDatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        JsonReader reader = null;
        try {
            InputStream inputStream = getApplicationContext().getAssets().open(Constants.PLANT_DATA_FILENAME);
            reader = new JsonReader(new InputStreamReader(inputStream));

            List<Plant> list;
            list = new Gson().fromJson(reader, new TypeToken<List<Plant>>() {
            }.getType());
/*
            JsonArray asJsonArray = new JsonParser().parse(reader).getAsJsonArray();
            for (JsonElement element:asJsonArray){
                list.add(new Gson().fromJson(element,Plant.class));
            }
*/
            AppDatabase database = AppDatabase.getInstance(getApplicationContext());
            database.plantDao().insertAll(list);
            return Result.SUCCESS;

        } catch (IOException e) {
            e.printStackTrace();
            return Result.FAILURE;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
