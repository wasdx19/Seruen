package kz.seruen.Utils.Adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kz.seruen.Services.ModelObject

class CustomPagerAdapter(private val mContext: Context) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val modelObject = ModelObject.values()[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(modelObject.layoutResId, collection, false) as ViewGroup
        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return ModelObject.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val customPagerEnum = ModelObject.values()[position]
        return mContext.getString(customPagerEnum.titleResId)
    }


}
