package kz.seruen.Fragments.HomePageFragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kz.seruen.R

class HomePageFragment3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page3)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
