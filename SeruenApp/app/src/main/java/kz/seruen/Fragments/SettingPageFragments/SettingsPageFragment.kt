package kz.seruen.Fragments.SettingPageFragments

import android.content.Intent
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*
import kz.seruen.Activities.LoginActivity
import kz.seruen.Activities.MainActivity

import kz.seruen.R

class SettingsPageFragment : Fragment() {

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

        exitButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@SettingsPageFragment.context, LoginActivity::class.java)
            startActivity(intent)
            onDestroy()
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
}
