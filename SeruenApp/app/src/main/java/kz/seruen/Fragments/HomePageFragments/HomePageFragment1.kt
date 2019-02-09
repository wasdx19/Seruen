package kz.seruen.Fragments.HomePageFragments

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

import kz.seruen.R

class HomePageFragment1 : Fragment() {

    internal var headerTV: TextView?=null
    internal var btn_trip: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        super.onCreate(savedInstanceState)
        headerTV = activity!!.findViewById(R.id.headerTv)

        /*btn_trip = view!!.findViewById(R.id.bex_trip)
        var selectedFragment: Fragment? = fragmentManager?.findFragmentById(R.id.a_m_p_2)
        btn_trip?.setOnClickListener {
            val tr = fragmentManager?.beginTransaction()
            tr?.replace(R.id.a_m_p_1, selectedFragment!!)
            tr?.commit()
        }*/

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main_page1, container, false)

    }

    companion object {

        fun newInstance(): HomePageFragment1 {
            val fragment = HomePageFragment1()
            return fragment
        }
    }
}
