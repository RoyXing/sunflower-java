package com.xingzy.data;

import android.content.Context;

import com.xingzy.utilities.Constants;
import com.xingzy.workers.SeedDatabaseWorker;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
@Database(entities = {GardenPlanting.class, Plant.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
abstract public class AppDatabase extends RoomDatabase {

    abstract public GardenPlantingDao gardenPlantingDao();

    abstract public PlantDao plantDao();

    private static AppDatabase appDatabase;

    public synchronized static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = buildDatabase(context);
        }
        return appDatabase;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, Constants.DATABASE_NAME).addCallback(new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(SeedDatabaseWorker.class).build();
                WorkManager.getInstance().enqueue(request);
            }
        }).build();
    }
}
