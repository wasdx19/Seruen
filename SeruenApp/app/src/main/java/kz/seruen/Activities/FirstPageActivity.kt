package kz.seruen.Activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kz.seruen.R
import java.util.*
import kotlin.concurrent.timerTask

class FirstPageActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var timer:Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)
        auth= FirebaseAuth.getInstance()
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

        timer=Timer()
        timer.schedule(timerTask { updateUI(currentUser) },1000)
    }


    private fun updateUI(user: FirebaseUser?){
        if(user!=null){
            val intent = Intent(this@FirstPageActivity, MainActivity::class.java)
            startActivity(intent)
        }else{
            val intent = Intent(this@FirstPageActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}