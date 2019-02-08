package kz.visitapp2.Activities.RegistrationPageActivities

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton

import kz.visitapp2.Activities.InterestsPageActivities.InterestsPage
import kz.visitapp2.R

class UserRegPage : AppCompatActivity() {
    internal lateinit var skip: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_reg_page)

        skip = findViewById(R.id.facebook_btn)
        skip.setOnClickListener {
            val intent = Intent(this@UserRegPage, InterestsPage::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

}
