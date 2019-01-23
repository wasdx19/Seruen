package kz.visitapp2.GuidePageClasses;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import kz.visitapp2.R;

public class GuidePage2 extends AppCompatActivity {

    Button nxtBtn;
    Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page2);
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
