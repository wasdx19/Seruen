package kz.seruen.Fragments.MapPageFragments

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

import kz.seruen.R

class MapPageFragment2 : Fragment() {

    var mapBackButton: ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.activity_map2,container,false)
        val fragmentActivity: FragmentActivity?=activity

        mapBackButton= view!!.findViewById(R.id.map_back_btn)
        mapBackButton?.setOnClickListener {
            val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val tripFragment:Fragment= MapPageFragment1.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, tripFragment!!)?.addToBackStack(null)
            tr?.commit()
        }

        return view
    }

    companion object {
        fun newInstance():MapPageFragment2{
            val fragment=MapPageFragment2()
            return fragment
        }
    }
}
