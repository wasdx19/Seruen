package kz.seruen.Fragments.MapPageFragments

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import kz.seruen.Fragments.HomePageFragments.HomePageFragment2

import kz.seruen.R

class MapPageFragment1 : Fragment() {

    var fragmentActivity: FragmentActivity?=null
    var mapTripButton: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        return inflater.inflate(R.layout.activity_map1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(view)

        mapTripButton?.setOnClickListener {
            val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val tripFragment:Fragment= MapPageFragment2.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, tripFragment!!)?.addToBackStack(null)
            tr?.commit()
        }
    }

    fun initialize(view:View){
        mapTripButton=view.findViewById(R.id.button_trip)
        fragmentActivity=activity
    }

    companion object {

        fun newInstance(): MapPageFragment1 {
            val fragment = MapPageFragment1()
            return fragment
        }
    }

}
