package kz.seruen.Fragments.PlacesPageFragments

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

import kz.seruen.R

class PlacesPageFragment2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places_page2)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
