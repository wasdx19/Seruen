package kz.visitapp2;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainPage1 extends Fragment {

    TextView headerTV;

    public static MainPage1 newInstance(){
        MainPage1 fragment=new MainPage1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getActivity().getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        headerTV=getActivity().findViewById(R.id.headerTv);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.activity_main_page1,container,false);
    }

    /*public void grad(TextView v) {
        Shader myShader = new LinearGradient(
                0, 0, 0, 100,
                Color.WHITE, Color.BLACK,
                Shader.TileMode.CLAMP);
        v.getPaint().setShader(myShader);
    }*/
}
