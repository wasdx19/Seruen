package kz.visitapp2.PlacePageClasses;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kz.visitapp2.R;

public class PlacesPage1 extends Fragment {

    public static PlacesPage1 newInstance(){
        PlacesPage1 fragment=new PlacesPage1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.activity_places_page1,container,false);
    }
}
