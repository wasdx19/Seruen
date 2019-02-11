package kz.seruen.Fragments.HomePageFragments

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        val v=inflater.inflate(R.layout.activity_main_page1, container, false)

        /*btn_trip= v!!.findViewById(R.id.bex_trip)
        var selectedFragment: Fragment? = HomePageFragment2.newInstance()
        btn_trip?.setOnClickListener {
            val tr = fragmentManager?.beginTransaction()
            tr?.replace(R.id.frame, selectedFragment!!)
            tr?.commit()
        }*/

        return v
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    fun initView(v:View?){
        btn_trip=v!!.findViewById(R.id.bex_trip)
        btn_trip?.setOnClickListener(this)
    }

    fun changeFragment(){
        var selectedFragment: Fragment? = fragmentManager?.findFragmentById(R.id.a_m_p_2)
        val tr = fragmentManager?.beginTransaction()
        tr?.replace(R.id.a_m_p_1, selectedFragment!!)?.addToBackStack(null)
        tr?.commit()
    }

    override fun onClick(v: View?) {
        when (v?.getId()){
            R.id.bex_trip -> changeFragment()
        }
    }*/

    companion object {

        fun newInstance(): HomePageFragment1 {
            val fragment = HomePageFragment1()
            return fragment
        }
    }
}
