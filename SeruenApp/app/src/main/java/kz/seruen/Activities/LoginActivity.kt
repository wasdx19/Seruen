package kz.seruen.Activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_page.*
import kz.seruen.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        button_signIn.setOnClickListener(this)
        button_signUp.setOnClickListener(this)

        auth= FirebaseAuth.getInstance()
    }

    public override fun onStart() {
        super.onStart()
    }

    private fun signIn(email:String, password:String){
        Log.d(TAG, "signIn:$email")
        if (!validateForm()) {
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser
                updateUI(user)
            } else {
                Log.w(TAG, "signInWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }

            if (!task.isSuccessful) {
                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm(): Boolean {
        var valid = true

        val email = loginField.text.toString()
        if (TextUtils.isEmpty(email)) {
            loginField.error = "Required."
            valid = false
        } else {
            loginField.error = null
        }

        val password = passwordField.text.toString()
        if (TextUtils.isEmpty(password)) {
            passwordField.error = "Required."
            valid = false
        } else {
            passwordField.error = null
        }

        return valid
    }

    private fun updateUI(user: FirebaseUser?){
        if(user!=null){
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(baseContext, "User null", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signUp(){
        val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        val id= v!!.id
        when(id){
            R.id.button_signIn->signIn(loginField.text.toString(),passwordField.text.toString())
            R.id.button_signUp->signUp()
        }
    }

    companion object {
        private const val TAG = "EmailSignIn"
    }
}

