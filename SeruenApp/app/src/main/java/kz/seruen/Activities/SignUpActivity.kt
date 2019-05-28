package kz.seruen.Activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_signup_page.*
import kz.seruen.R
import kz.seruen.Utils.DBUtilsFb
import kz.seruen.Utils.Sliders.GuidePageSlider

class SignUpActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var auth: FirebaseAuth

    private var loginField:EditText?=null
    private var passwordField:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val button=findViewById<View>(R.id.button_signUp)
        loginField=findViewById(R.id.sloginField)
        passwordField=findViewById(R.id.spasswordField)

        button.setOnClickListener(this)

        auth= FirebaseAuth.getInstance()
    }

    public override fun onStart() {
        super.onStart()
    }

    private fun createAccount(email:String, password:String){
        Log.d(SignUpActivity.TAG, "createAccount:$email")
        if (!validateForm()) {
            return
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Log.d(SignUpActivity.TAG, "createUserWithEmail:success")
                val user = auth.currentUser
                DBUtilsFb.addUser(auth.uid!!)
                updateUI(user)
            } else {
                Log.w(SignUpActivity.TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
    }

    private fun validateForm(): Boolean {
        var valid = true

        val email = sloginField.text.toString()
        if (TextUtils.isEmpty(email)) {
            sloginField.error = "Required."
            valid = false
        } else {
            sloginField.error = null
        }

        val password = spasswordField.text.toString()
        if (TextUtils.isEmpty(password)) {
            spasswordField.error = "Required."
            valid = false
        } else {
            spasswordField.error = null
        }

//        val name=nameField.text.toString()
//        if (TextUtils.isEmpty(name)) {
//            nameField.error = "Required."
//            valid = false
//        } else {
//            nameField.error = null
//        }
//
//        val checkPass=passwordCheckField.text.toString()
//        if (TextUtils.isEmpty(checkPass)) {
//            passwordCheckField.error = "Required."
//            valid = false
//        } else {
//            passwordCheckField.error = null
//        }
//
//        if(checkPass.equals(password)){
//            return valid
//        }else{
//            Toast.makeText(baseContext,"Wrong check password",Toast.LENGTH_SHORT).show()
//            valid=false
//        }

        return valid
    }

    private fun updateUI(user: FirebaseUser?){
        if(user!=null){
            val intent = Intent(this@SignUpActivity, GuidePageSlider::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(baseContext, "User null", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        val id= v!!.id
        when(id){
            R.id.button_signUp->createAccount(loginField?.text.toString(),passwordField?.text.toString())
        }
    }

    companion object {
        private const val TAG = "EmailSignUp"
    }
}