package kz.seruen.Utils.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kz.seruen.Place
import kz.seruen.R

class PlacesAdapter(items:ArrayList<Place>, ctx: Context):
        ArrayAdapter<Place>(ctx, R.layout.activity_place, items){

    private class PlaceViewHolder{
        internal var name: TextView? = null
        internal var info: TextView? = null
        val view: View? = null
        init {
            this.name = view?.findViewById<TextView>(R.id.place_name)
            this.info = view?.findViewById<TextView>(R.id.place_info)
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
        }else{
            viewHolder = view.tag as PlaceViewHolder
        }

        val place = getItem(i)
        viewHolder.name!!.text = place!!.name
        viewHolder.info!!.text= place!!.info

        view.tag = viewHolder
        return view
    }

}