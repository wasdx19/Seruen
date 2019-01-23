package kz.visitapp2.Services;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import kz.visitapp2.CustomPagerAdapter;
import kz.visitapp2.R;
import kz.visitapp2.RegistrationPageClasses.UserRegPage;
import me.relex.circleindicator.CircleIndicator;

public class Slider extends AppCompatActivity {
    Button skip;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new CustomPagerAdapter(this));

        CustomPagerAdapter adapter = new CustomPagerAdapter(this);

//        viewpager.setPageTransformer(true, new ZoomInTransformer());

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewpager);

        skip = findViewById(R.id.btn_skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slider.this, UserRegPage.class);
                startActivity(intent);
            }
        });
    }
}


