package kz.seruen.Activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login_page.*
import kz.seruen.Activities.InterestsPageActivities.InterestsPage
import kz.seruen.R

class LoginActivity : AppCompatActivity() {
    val user_log = null
    val user_passw = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        var login_button: Button = findViewById(R.id.login_button)
        login_button.setOnClickListener {
            val intent = Intent(this, InterestsPage::class.java)
            var user_login = login.text.toString()
            var user_password = password.text.toString()
            if (user_login != null || user_password != null) {
                if (user_login.equals("admin") && user_password.equals("admin")) {
                    intent.putExtra("user_login", user_login)
                    intent.putExtra("user_password", user_password)
                    startActivity(intent)
                } else
                    error_text.setText("Input correct DATA!")
            } else {
                error_text.setText("Input DATA!")
            }
        }
    }
}

