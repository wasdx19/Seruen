package kz.visitapp2;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainPage1 extends Fragment {

    TextView headerTV;

    public static MainPage1 newInstance(){
        MainPage1 fragment=new MainPage1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        headerTV=getActivity().findViewById(R.id.headerTv);
        //grad(headerTV);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.activity_main_page1,container,false);
    }

    public void grad(TextView v) {
        Shader myShader = new LinearGradient(
                0, 0, 0, 100,
                Color.WHITE, Color.BLACK,
                Shader.TileMode.CLAMP);
        v.getPaint().setShader(myShader);
    }
}
