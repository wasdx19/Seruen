package kz.seruen.Fragments.PlacesPageFragments

import android.graphics.Bitmap
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_place.*
import kz.seruen.Place
import kz.seruen.R
import kz.seruen.Services.RecyclerItemClickListener
import kz.seruen.Utils.Adapters.PlacesAdapter
import kz.seruen.Utils.Adapters.PlacesButtonAdapter
import kotlin.collections.ArrayList
import kotlin.collections.HashMap



class PlacesPageFragment1 : Fragment() {

    private val placesByType = HashMap<String, ArrayList<Place>>()
    private var placesTypeList: ArrayList<String> = ArrayList<String>()
    private var btn_type: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_places_page1, container, false)

/*        var img_basket:ImageView = view.findViewById(R.id.image_basket)
        img_basket.setOnClickListener {
            Toast.makeText(activity?.applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
            start()
        }*/
        loadPlacesData()
        val listViewPlaces:ListView = view!!.findViewById(R.id.listView_places)
        val clubPlaces = getPlacesByType("News")
        val placesAdapter = PlacesAdapter(clubPlaces, activity!!.applicationContext)
        listViewPlaces.adapter = placesAdapter
        addPlacesTypeData()
        val ll : RecyclerView = view.findViewById(R.id.listView_places_button)
        ll!!.layoutManager = LinearLayoutManager(activity!!.applicationContext, OrientationHelper.HORIZONTAL, false)
        ll!!.adapter = PlacesButtonAdapter(placesTypeList)

        ll!!.addOnItemTouchListener(
                RecyclerItemClickListener(this!!.activity!!, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Toast.makeText(activity?.applicationContext, "Clicked "+position, Toast.LENGTH_SHORT).show()
                        start()
                    }
                })
        )
        /*btn_type = view!!.findViewById(R.id)
        btn_type?.setOnClickListener(){
            loadPlacesData()
            val listViewPlaces:ListView = view!!.findViewById(R.id.listView_places)
            val clubPlaces = getPlacesByType("Clubs")
            val placesAdapter = PlacesAdapter(clubPlaces, activity!!.applicationContext)
            listViewPlaces.adapter = placesAdapter
        }*/
        return view
    }

    fun getPlacesByType(type: String): ArrayList<Place>{
        val places = placesByType[type]
        if(places!=null)
            return places
        else
            return ArrayList<Place>()
    }

    fun loadPlacesData(){
        addPlacesTypeData(placesByType)
    }

    fun addPlacesTypeData(placesByType: MutableMap<String, ArrayList<Place>>){
        val places_list = ArrayList<Place>()

        var place = Place()
        for(i in 1..20){
            place = Place()
            place.name = "Showplace" + i.toString()
            place.info = " " + i.toString() + "/" + (i%7+1).toString() + "    |    " + (i*1000).toString() + "KZT"
            places_list.add(place)
        }

        placesByType.put("News", places_list)
    }

    fun addPlacesTypeData(){
        placesTypeList.add("Showplaces")
        placesTypeList.add("News")
        placesTypeList.add("Movie")
        placesTypeList.add("Bar")
        placesTypeList.add("Club")
        placesTypeList.add("Nature")
        placesTypeList.add("Fitness")
        placesTypeList.add("Zoo")
    }

    fun start(){
        loadPlacesData()
        val listViewPlaces:ListView = view!!.findViewById(R.id.listView_places)
        val clubPlaces = getPlacesByType("News")
        val placesAdapter = PlacesAdapter(clubPlaces, activity!!.applicationContext)
        listViewPlaces.adapter = placesAdapter
    }

    companion object {
        fun newInstance(): PlacesPageFragment1 {
            val fragment = PlacesPageFragment1()
            return fragment
        }
    }

}
