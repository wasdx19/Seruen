package kz.seruen.Fragments.PlacesPageFragments

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import kz.seruen.Place
import kz.seruen.R
import kz.seruen.Utils.Adapters.PlacesAdapter
import kz.seruen.Utils.Adapters.PlacesButtonAdapter
import kotlin.collections.ArrayList
import kotlin.collections.HashMap



class PlacesPageFragment1 : Fragment() {

    private val placesByType = HashMap<String, ArrayList<Place>>()
    private var placesTypeList: ArrayList<Place> = ArrayList<Place>()
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
        val listViewPlacesType:ListView = view!!.findViewById(R.id.listView_places_button)
        addPlacesTypeData()

        var img_basket:ImageView = view.findViewById(R.id.image_basket)
        img_basket.setOnClickListener {
            Toast.makeText(activity?.applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
            start()
        }

        var placesTypeAdapter:PlacesButtonAdapter = PlacesButtonAdapter(placesTypeList,activity!!.applicationContext)
        listViewPlacesType.adapter = placesTypeAdapter
        listViewPlacesType.onItemClickListener=AdapterView.OnItemClickListener{adapterView,view,position:Int,id:Long->
            Toast.makeText(activity, "Click on ", Toast.LENGTH_SHORT).show()
        }
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

    companion object {
        fun newInstance(): PlacesPageFragment1 {
            val fragment = PlacesPageFragment1()
            return fragment
        }
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
            place.name = "Club" + i.toString()
            place.info = " " + i.toString() + "/" + (i%7+1).toString() + "    |    " + (i*1000).toString() + "KZT"
            places_list.add(place)
        }

        placesByType.put("Clubs", places_list)
    }

    fun addPlacesTypeData(){
        var place = Place()
        place.type = "News"
        placesTypeList.add(place)

        place = Place()
        place.type = "Eat"
        placesTypeList.add(place)

        place = Place()
        place.type = "Movie"
        placesTypeList.add(place)

        place = Place()
        place.type = "Bar"
        placesTypeList.add(place)

        place = Place()
        place.type = "Club"
        placesTypeList.add(place)

        place = Place()
        place.type = "Nature"
        placesTypeList.add(place)

        place = Place()
        place.type = "Fitness"
        placesTypeList.add(place)

        place = Place()
        place.type = "Zoo"
        placesTypeList.add(place)

    }

    fun start(){
        loadPlacesData()
        val listViewPlaces:ListView = view!!.findViewById(R.id.listView_places)
        val clubPlaces = getPlacesByType("Clubs")
        val placesAdapter = PlacesAdapter(clubPlaces, activity!!.applicationContext)
        listViewPlaces.adapter = placesAdapter
    }
}
