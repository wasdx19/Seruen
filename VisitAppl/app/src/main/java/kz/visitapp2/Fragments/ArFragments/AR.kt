package kz.visitapp2.Fragments.ArFragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kz.visitapp2.R

class AR : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        return inflater.inflate(R.layout.activity_ar, container, false)
    }

    companion object {

        fun newInstance(): AR {
            val fragment = AR()
            return fragment
        }
    }
}
