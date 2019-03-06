package kz.seruen.Utils.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import kz.seruen.Place
import kz.seruen.R

class PlacesButtonAdapter(items: ArrayList<Place>, ctx: Context): ArrayAdapter<Place>(ctx, R.layout.activity_places_button, items){

    private class PlacesButtonViewHolder{
        internal var type: Button? = null
        val view: View? = null
        init{
            this.type = view?.findViewById<Button>(R.id.places_button_type)
        }
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View{
        var view = view

        val viewHolder: PlacesButtonViewHolder

        if(view==null){
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.activity_places_button, viewGroup, false)

            viewHolder = PlacesButtonViewHolder()
            viewHolder.type = view!!.findViewById<View>(R.id.places_button_type) as Button
        }else{
            viewHolder = view.tag as PlacesButtonViewHolder
        }

        val place = getItem(i)
        viewHolder.type!!.text = place!!.type

        view.tag = viewHolder

        return view
    }



}