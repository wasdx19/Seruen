package kz.visitapp2;

import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

//import com.larvalabs.svgandroid.SVG;
//import com.larvalabs.svgandroid.SVGParser;

public class GuidePage1 extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    Typeface tfc1;
    Typeface tfc2;
    Typeface tfc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page1);
        text1 = (TextView)findViewById(R.id.GP_text_1);
        text2 = (TextView)findViewById(R.id.GP_text_2);
        text3 = (TextView)findViewById(R.id.GP_text_3);

        tfc1 = Typeface.createFromAsset(getAssets(), "fonts/futura_medium.ttf");

        tfc2 = Typeface.createFromAsset(getAssets(), "fonts/futura_medium.ttf");

        tfc3 = Typeface.createFromAsset(getAssets(), "fonts/futura_medium.ttf");

        text1.setTypeface(tfc1);
        text2.setTypeface(tfc1);
        text3.setTypeface(tfc1);


        //        ImageView imageView = (ImageView) findViewById(R.id.imgView);
//        SVG svg = SVGParser.getSVGFromResource(getResources(), R.drawable);
//        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        imageView.setImageDrawable(svg.createPictureDrawable());
    }
}
