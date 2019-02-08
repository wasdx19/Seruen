package kz.seruen.Activities.GuidePageActivities

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Button
import kz.seruen.R

class GuidePage2 : AppCompatActivity() {

    internal var nxtBtn: Button? = null
    internal var skip: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_page2)
        //
        //        skip=findViewById(R.id.GP1_button_skip);
        //
        //
        //        skip.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Intent intent = new Intent(GuidePage2.this,UserRegPage.class);
        //                startActivity(intent);
        //            }
        //        });
    }
}
