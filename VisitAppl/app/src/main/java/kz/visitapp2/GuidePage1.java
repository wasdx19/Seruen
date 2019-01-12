package kz.visitapp2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.larvalabs.svgandroid.SVG;
//import com.larvalabs.svgandroid.SVGParser;

public class GuidePage1 extends AppCompatActivity {
    TextView text1;
    Typeface tfc1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page1);
        text1 = (TextView)findViewById(R.id.text_1);

        tfc1 = Typeface.createFromAsset(getAssets(), "fonts/futura_medium.ttf");
        text1.setTypeface(tfc1);

        //        ImageView imageView = (ImageView) findViewById(R.id.imgView);
//        SVG svg = SVGParser.getSVGFromResource(getResources(), R.drawable);
//        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        imageView.setImageDrawable(svg.createPictureDrawable());
    }
}
