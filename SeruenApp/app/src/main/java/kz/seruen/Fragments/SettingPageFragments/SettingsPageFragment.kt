package kz.seruen.Fragments.SettingPageFragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*
import kz.seruen.Activities.LoginActivity
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import kz.seruen.Activities.MainActivity
import java.util.*


import kz.seruen.R

class SettingsPageFragment : Fragment() {

    var chBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        return inflater.inflate(R.layout.activity_settings, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadLocate()
        exitButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@SettingsPageFragment.context, LoginActivity::class.java)
            startActivity(intent)
            onDestroy()
        }

        chBtn = view?.findViewById(R.id.change_lang)
        chBtn?.setOnClickListener {
            showChangeLang()
        }
    }

    companion object {
        fun newInstance(): SettingsPageFragment {
            val fragment = SettingsPageFragment()
            return fragment
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun showChangeLang(){

        val langLists = arrayOf("English", "Russian", "Kazakh")

        val mBuilder = AlertDialog.Builder(this@SettingsPageFragment.context)
        mBuilder.setTitle("Choose language")
        mBuilder.setSingleChoiceItems(langLists, -1){ dialog, which ->
            if(which == 0){
                setLocate("en")
                (activity as MainActivity).recreate()
            }else if(which == 1){
                setLocate("ru")
                (activity as MainActivity).recreate()
            }else if(which == 2){
                setLocate("kk")
                (activity as MainActivity).recreate()
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocate(Lang: String){

        val locale = Locale(Lang)
        Locale.setDefault(locale)

        val config = Configuration()
        config.locale = locale
        (activity as MainActivity).baseContext.resources.updateConfiguration(config, (activity as MainActivity).baseContext.resources.displayMetrics)

        val editor = (activity as MainActivity).getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate(){
        val sharedPreferences = (activity as MainActivity).getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        setLocate(language)
    }
}
