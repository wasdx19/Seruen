package kz.seruen.Fragments.HomePageFragments

import android.annotation.SuppressLint
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main_page2.*

import kz.seruen.R

class HomePageFragment1 : Fragment() {

    internal var btn_trip: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        val v=inflater.inflate(R.layout.activity_main_page1, container, false)
        val fragmentActivity: FragmentActivity?=activity

        btn_trip= v!!.findViewById(R.id.bex_trip)
        btn_trip?.setOnClickListener {

            val fragmentManager:FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val tripFragment:Fragment=HomePageFragment2.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, tripFragment!!)?.addToBackStack(null)
            tr?.commit()
        }
        return v
    }

    companion object {

        fun newInstance(): HomePageFragment1 {
            val fragment = HomePageFragment1()
            return fragment
        }
    }
}
