package kz.seruen.Fragments.PlacesPageFragments

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import kz.seruen.R

class PlacesPageFragment3: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_place_moreinfo, container, false)


        return view
    }


    companion object {
        fun newInstance(): PlacesPageFragment3 {
            val fragment = PlacesPageFragment3()
            return fragment
        }
    }
}