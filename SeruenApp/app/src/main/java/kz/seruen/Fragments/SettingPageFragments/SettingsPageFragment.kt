package kz.seruen.Fragments.SettingPageFragments

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager

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

    companion object {
        fun newInstance(): SettingsPageFragment {
            val fragment = SettingsPageFragment()
            return fragment
        }
    }
}
