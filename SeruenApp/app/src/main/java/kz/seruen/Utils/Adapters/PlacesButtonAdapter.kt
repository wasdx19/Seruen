package kz.seruen.Utils.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import kz.seruen.R

class PlacesButtonAdapter(val places_type: ArrayList<String>): RecyclerView.Adapter<PlacesButtonAdapter.ViewHolder>(){
    override fun getItemCount() = places_type.size

    override fun onBindViewHolder(holder: PlacesButtonAdapter.ViewHolder, position: Int) {
        holder.places_button_type.text = places_type[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.activity_places_button, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val places_button_type: Button = itemView.findViewById(R.id.places_button_type)
    }
}