package kz.visitapp2.MainPageClasses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kz.visitapp2.R;

public class MainPage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page3);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
