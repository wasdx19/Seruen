package kz.seruen.Fragments.PlacesPageFragments

import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ListView
import kz.seruen.Place
import kz.seruen.R
import kz.seruen.Utils.Adapters.PlacesAdapter
import kotlin.collections.ArrayList
import kotlin.collections.HashMap



class PlacesPageFragment1 : Fragment() {

    private val placesByType = HashMap<String, ArrayList<Place>>()
    private var btn_club: Button? = null

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
        btn_club = view!!.findViewById(R.id.button_clubs)
        btn_club?.setOnClickListener(){
            loadPlacesData()
            val listView:ListView = view!!.findViewById(R.id.listView_places)
            val clubPlaces = getPlacesByType("Clubs")
            val placesAdapter = PlacesAdapter(clubPlaces, activity!!.applicationContext)
            listView.adapter = placesAdapter
        }
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
        place.name = "Qwerty"
        place.info = " 24/7   |    5000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club BhB"
        place.info = " 12/5   |    1200KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club 888"
        place.info = " 10/3   |    10000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Qwerty"
        place.info = " 24/7   |    5000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club BhB"
        place.info = " 12/5   |    1200KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club 888"
        place.info = " 10/3   |    10000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Qwerty"
        place.info = " 24/7   |    5000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club BhB"
        place.info = " 12/5   |    1200KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club 888"
        place.info = " 10/3   |    10000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Qwerty"
        place.info = " 24/7   |    5000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club BhB"
        place.info = " 12/5   |    1200KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club 888"
        place.info = " 10/3   |    10000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Qwerty"
        place.info = " 24/7   |    5000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club BhB"
        place.info = " 12/5   |    1200KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club 888"
        place.info = " 10/3   |    10000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Qwerty"
        place.info = " 24/7   |    5000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club BhB"
        place.info = " 12/5   |    1200KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club 888"
        place.info = " 10/3   |    10000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Qwerty"
        place.info = " 24/7   |    5000KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club BhB"
        place.info = " 12/5   |    1200KZT"
        places_list.add(place)

        place = Place()
        place.name = "Club 888"
        place.info = " 10/3   |    10000KZT"
        places_list.add(place)

        placesByType.put("Clubs", places_list)
    }
}
