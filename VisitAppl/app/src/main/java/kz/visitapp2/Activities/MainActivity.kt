package kz.visitapp2.Activities

import android.annotation.SuppressLint
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kz.visitapp2.Fragments.ArFragments.AR
import kz.visitapp2.Fragments.HomePageFragments.HomePageFragment1
import kz.visitapp2.Fragments.MapPageFragments.MapPageFragment1
import kz.visitapp2.Fragments.PlacesPageFragments.PlacesPageFragment1
import kz.visitapp2.R
import kz.visitapp2.Fragments.SettingPageFragments.SettingsPageFragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botNav = findViewById<BottomNavigationView>(R.id.navbar)

        botNav.setOnNavigationItemSelectedListener { menuItem ->
            var selectedFragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.home -> selectedFragment = HomePageFragment1.newInstance()
                R.id.places -> selectedFragment = PlacesPageFragment1.newInstance()
                R.id.ar -> selectedFragment = AR.newInstance()
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
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }


}
