package kz.seruen.Utils.Adapters

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kz.seruen.Activities.MainActivity
import kz.seruen.Fragments.PlacesPageFragments.PlacesPageFragment3
import kz.seruen.Places
import kz.seruen.Services.Place
import kz.seruen.R

class PlacesAdapter(items:ArrayList<Place>, ctx: Context):
        ArrayAdapter<Place>(ctx, R.layout.activity_place, items){
    private var fragmentActivity: FragmentActivity?=null
    var arr:ArrayList<Place>?=items

    private class PlaceViewHolder{
        internal var name: TextView? = null
        internal var info: TextView? = null
        internal var ivInfo: ImageView?=null
        internal var ivLike: ImageView?=null
        internal var click:RelativeLayout?=null
        val view: View? = null
        init {
            this.name = view?.findViewById<TextView>(R.id.place_name)
            this.info = view?.findViewById<TextView>(R.id.place_info)
            this.ivInfo =view?.findViewById<ImageView>(R.id.place_info_logo)
            this.ivLike=view?.findViewById<ImageView>(R.id.place_like_logo)
            this.click=view?.findViewById<RelativeLayout>(R.id.click)
        }
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        val viewHolder: PlaceViewHolder

        if(view==null){
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.activity_place, viewGroup, false)

            viewHolder = PlaceViewHolder()
            viewHolder.name = view!!.findViewById<View>(R.id.place_name) as TextView
            viewHolder.info = view!!.findViewById<View>(R.id.place_info) as TextView
            viewHolder.ivInfo=view!!.findViewById<View>(R.id.place_info_logo) as ImageView
            viewHolder.click=view!!.findViewById<RelativeLayout>(R.id.click) as RelativeLayout
        }else{
            viewHolder = view.tag as PlaceViewHolder
        }

        val place = getItem(i)
        viewHolder.name!!.text = place!!.name
        viewHolder.info!!.text= place!!.averCost.toString()

        view.tag = viewHolder

        view.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Pos"+i,Toast.LENGTH_SHORT).show()
            val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val infoFragment: Fragment = PlacesPageFragment3.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, infoFragment)?.addToBackStack(null)
            tr?.commit()
        })

        return view
    }

    override fun getItem(position: Int): Place? {
        return arr?.get(position)
    }
}