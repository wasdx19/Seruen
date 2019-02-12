package kz.seruen.Fragments.PlacesPageFragments

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_places_page1.*

import kz.seruen.R

class PlacesPageFragment1 : Fragment() {

    internal var btn_place: Button?=null
    internal var place_name: TextView?=null
    internal var place_info: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {

        val view = inflater.inflate(R.layout.activity_places_page1, container, false)
        btn_place =  view!!.findViewById(R.id.button_clubs)
        place_name = view!!.findViewById(R.id.textView_top_11)
        place_info = view!!.findViewById(R.id.textView_bottom_11)
        btn_place?.setOnClickListener{
            place_name?.setText("Clubs BHB")
            place_info?.setText(" 12/5   |   Ave: 12000KZT")
        }

        return view
    }

    companion object {

        fun newInstance(): PlacesPageFragment1 {
            val fragment = PlacesPageFragment1()
            return fragment
        }
    }
}
