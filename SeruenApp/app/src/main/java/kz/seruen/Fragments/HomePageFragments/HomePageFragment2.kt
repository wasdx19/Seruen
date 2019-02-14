package kz.seruen.Fragments.HomePageFragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import kz.seruen.R

class HomePageFragment2 : Fragment() {

    internal var back: ImageView?=null

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view= inflater.inflate(R.layout.activity_main_page2,container,false)
        val fragmentActivity: FragmentActivity?=activity

        back= view!!.findViewById(R.id.backButton)
        back?.setOnClickListener {
            val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val tripFragment:Fragment=HomePageFragment1.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, tripFragment!!)
            tr?.commit()
        }


        return view
    }

    companion object {
        fun newInstance(): HomePageFragment2 {
            val fragment = HomePageFragment2()
            return fragment
        }
    }

}
