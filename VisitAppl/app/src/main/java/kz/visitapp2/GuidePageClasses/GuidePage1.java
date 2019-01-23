package kz.visitapp2.GuidePageClasses;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import kz.visitapp2.R;

//import com.larvalabs.svgandroid.SVG;
//import com.larvalabs.svgandroid.SVGParser;

public class GuidePage1 extends AppCompatActivity {
//    TextView text1;
//    TextView text2;
//    TextView text3;
//    TextView text4;
//    TextView text5;
//    Typeface tfc1;
//
    Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page1);

        //-----------------------------------------------------------------------------------------------
//        text1 = (TextView)findViewById(R.id.GP1_text_1);
//        text2 = (TextView)findViewById(R.id.GP1_text_2);
//        text3 = (TextView)findViewById(R.id.GP1_text_3);
//        text5 = (TextView)findViewById(R.id.GP1_button_skip);
//        tfc1 = Typeface.createFromAsset(getAssets(), "fonts/futura_medium.ttf");
//
//        text1.setTypeface(tfc1);
//        text2.setTypeface(tfc1);
//        text3.setTypeface(tfc1);
//        text5.setTypeface(tfc1);

        //-----------------------------------------------------------------------------------------------
//
//        skip=findViewById(R.id.GP1_button_skip);
//        skip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GuidePage1.this,UserRegPage.class);
//                startActivity(intent);
//            }
//        });
    }
}
