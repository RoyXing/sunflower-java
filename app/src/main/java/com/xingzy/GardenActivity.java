package com.xingzy;

import android.os.Bundle;

import com.xingzy.databinding.GardenActivityBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;
import static androidx.navigation.ui.NavigationUI.setupWithNavController;

/**
 * @author xingzhengyi
 */
public class GardenActivity extends AppCompatActivity {

    private GardenActivityBinding binding;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.garden_activity);

        navController = Navigation.findNavController(this, R.id.garden_nav_fragment);

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(binding.drawerLayout).build();

        //绑定头部信息
        setSupportActionBar(binding.toolbar);
        setupActionBarWithNavController(this, navController, appBarConfiguration);

        //绑定侧滑menu的点击事件
        setupWithNavController(binding.navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
