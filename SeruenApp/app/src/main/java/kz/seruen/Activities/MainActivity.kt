package kz.seruen.Activities

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import kz.seruen.Fragments.ArFragments.ArFragment
import kz.seruen.Fragments.HomePageFragments.HomePageFragment1
import kz.seruen.Fragments.HomePageFragments.HomePageFragment2
import kz.seruen.Fragments.MapPageFragments.MapPageFragment1
import kz.seruen.Fragments.PlacesPageFragments.PlacesPageFragment1
import kz.seruen.R
import kz.seruen.Fragments.SettingPageFragments.SettingsPageFragment

class MainActivity : AppCompatActivity() {

    internal var tripBtn: Button?=null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botNav= findViewById<BottomNavigationViewEx>(R.id.botNav)
        botNav?.enableAnimation(false)
        botNav?.enableShiftingMode(true)
        botNav?.enableItemShiftingMode(false)

        tripBtn=findViewById(R.id.bex_trip)

        botNav?.setOnNavigationItemSelectedListener { menuItem ->
            var selectedFragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.home -> selectedFragment = HomePageFragment1.newInstance()
                R.id.places -> selectedFragment = PlacesPageFragment1.newInstance()
                R.id.ar -> selectedFragment = ArFragment.newInstance()
                R.id.map -> selectedFragment = MapPageFragment1.newInstance()
                R.id.settings -> selectedFragment = SettingsPageFragment.newInstance()
            }

            val tr = supportFragmentManager.beginTransaction()
            tr.replace(R.id.frame, selectedFragment!!)
            tr.commit()
            true
        }

        val tr1 = supportFragmentManager.beginTransaction()
        tr1.replace(R.id.frame, HomePageFragment1.newInstance())
        tr1.commit()

        tripBtn?.setOnClickListener {
            var selectedFragment= HomePageFragment2.newInstance()
            val tr = supportFragmentManager?.beginTransaction()
            tr?.replace(R.id.frame, selectedFragment)
            tr?.commit()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }


}
