package com.xingzy.data;

import android.content.Context;

import com.xingzy.utilities.TestUtils;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
@RunWith(AndroidJUnit4.class)
public class PlantDaoTest {
    @NonNull
    private AppDatabase appDatabase;
    @NonNull
    private PlantDao plantDao;

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        plantDao = appDatabase.plantDao();
        plantDao.insertAll(TestUtils.plants);
    }

    public void closeDb() {
        appDatabase.close();
    }

    @Test
    public void testGetPlants() {
        plantDao.getPlants().observeForever(new Observer<List<Plant>>() {
            @Override
            public void onChanged(List<Plant> plants) {
                Assert.assertThat(plants.size(), Matchers.equalTo(4));
            }
        });
    }
}
