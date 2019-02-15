package kz.seruen.Utils.Sliders

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.WindowManager
import android.widget.Button


import kz.seruen.Utils.Adapters.CustomPagerAdapter
import kz.seruen.R
import kz.seruen.Activities.RegistrationPageActivities.UserRegPage
import me.relex.circleindicator.CircleIndicator

class GuidePageSlider : AppCompatActivity() {
    internal lateinit var skip: Button
    internal lateinit var get_start: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        val viewpager = findViewById<View>(R.id.viewpager) as ViewPager
        viewpager.adapter = CustomPagerAdapter(this)

        val adapter = CustomPagerAdapter(this)
        //viewpager.setPageTransformer(true, ZoomInTransformer());

        val indicator = findViewById<View>(R.id.indicator) as CircleIndicator
        indicator.setViewPager(viewpager)

        skip = findViewById(R.id.btn_skip)
        get_start = findViewById(R.id.btn_get_started)

        viewpager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                if(position==2){
                    skip.visibility=View.INVISIBLE

                    get_start.visibility=View.VISIBLE
                }
            }

        })
        skip.setOnClickListener {
            val intent = Intent(this@GuidePageSlider, UserRegPage::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        get_start.setOnClickListener {
            val intent = Intent(this@GuidePageSlider, UserRegPage::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}


