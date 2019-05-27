package kz.seruen.Fragments.HomePageFragments

import android.annotation.SuppressLint
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.CardView
import android.view.*
import android.widget.Button
import android.widget.TextView
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_page2.*
import kz.seruen.Fragments.ArFragments.ArFragment
import kz.seruen.Fragments.MapPageFragments.MapPageFragment1
import kz.seruen.Fragments.PlacesPageFragments.PlacesPageFragment1

import kz.seruen.R

class HomePageFragment1 : Fragment() {
    internal var fragmentActivity:FragmentActivity?=null
    internal var btn_trip: Button?=null
    internal var ar_card: CardView?=null
    internal var map_card: CardView?=null
    internal var places_card: CardView?=null


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
        return inflater.inflate(R.layout.activity_main_page1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()

        btn_trip?.setOnClickListener {
            val fragmentManager:FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val tripFragment:Fragment=HomePageFragment2.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, tripFragment!!)?.addToBackStack(null)
            tr?.commit()
        }

        ar_card?.setOnClickListener {
            val fragmentManager:FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val arFragment:Fragment=ArFragment.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, arFragment!!)?.addToBackStack(null)
            val botNav= view?.findViewById<BottomNavigationViewEx>(R.id.botNav)
            /*var menu: Menu? = botNav?.menu
            var menuItem: MenuItem? = menu?.getItem(R.id.ar)
            menuItem?.setChecked(true)*/
            botNav?.setCurrentItem(3)
            tr?.commit()
        }

        map_card?.setOnClickListener {
            val fragmentManager:FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val mapFragment:Fragment=MapPageFragment1.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, mapFragment!!)?.addToBackStack(null)
            tr?.commit()
        }

        places_card?.setOnClickListener {
            val fragmentManager:FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val placesFragment:Fragment=PlacesPageFragment1.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, placesFragment!!)?.addToBackStack(null)
            tr?.commit()
        }

    }

    fun initialize(){
        btn_trip=view?.findViewById(R.id.bex_trip)
        fragmentActivity=activity
        ar_card=view?.findViewById(R.id.mp1_ar)
        map_card=view?.findViewById(R.id.mp1_map)
        places_card=view?.findViewById(R.id.mp1_places)
    }

    companion object {
        fun newInstance(): HomePageFragment1 {
            val fragment = HomePageFragment1()
            return fragment
        }
    }
}
