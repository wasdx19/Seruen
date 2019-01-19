package kz.visitapp2;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView botNav=findViewById(R.id.navbar);

        botNav.setOnNavigationItemSelectedListener(menuItem -> {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.home:
                    selectedFragment = MainPage1.newInstance();
                    break;
                case R.id.places:
                    selectedFragment = PlacesPage1.newInstance();
                    break;
                case R.id.ar:
                    selectedFragment = AR.newInstance();
                    break;
                case R.id.map:
                    selectedFragment = Map1.newInstance();
                    break;
                case R.id.settings:
                    selectedFragment = Settings.newInstance();
                    break;
            }

            FragmentTransaction tr= getSupportFragmentManager().beginTransaction();
            tr.replace(R.id.frame,selectedFragment);
            tr.commit();
            return true;

        });
        FragmentTransaction tr1= getSupportFragmentManager().beginTransaction();
        tr1.replace(R.id.frame,MainPage1.newInstance());
        tr1.commit();
    }



}
