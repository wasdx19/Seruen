package kz.seruen.Activities.GuidePageActivities

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

import kz.seruen.R

class GuidePage3 : AppCompatActivity() {

    internal var getStarted: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_page3)
        //
        //        getStarted=findViewById(R.id.GP3_button_start);
        //
        //        getStarted.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Intent intent = new Intent(GuidePage3.this,UserRegPage.class);
        //                startActivity(intent);
        //            }
        //        });
    }
}