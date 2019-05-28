package kz.seruen.Fragments.PlacesPageFragments

import android.content.Intent
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import com.google.firebase.database.*
import kz.seruen.Activities.MainActivity
import kz.seruen.Places
import kz.seruen.Services.Place
import kz.seruen.R
import kz.seruen.Services.Interest
import kz.seruen.Services.RecyclerItemClickListener
import kz.seruen.Utils.Adapters.PlacesAdapter
import kz.seruen.Utils.Adapters.PlacesButtonAdapter
import kotlin.collections.ArrayList
import kotlin.collections.HashMap



class PlacesPageFragment1 : Fragment() {
    private var fragmentActivity: FragmentActivity?=null
    private val placesByType = HashMap<String, ArrayList<Places>>()

    private var btn_type: Button? = null
    private var ivBasket:ImageView?=null

    lateinit var interestList:MutableList<Interest>
    lateinit var placesList:MutableList<Place>
    lateinit var placeHashMap:HashMap<String,Place>
    private var placesTypeList: ArrayList<String> = ArrayList<String>()
    lateinit var places:ArrayList<Place>
    lateinit var places1:ArrayList<Place>

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

        /*HORIZONTAL Recycler view zone*/
        val ll : RecyclerView = view.findViewById(R.id.listView_places_button)
        ll.layoutManager = LinearLayoutManager(activity!!.applicationContext, OrientationHelper.HORIZONTAL, false)

        /*GET FROM FIREBASE INTERESTS*/
        val refInterest=FirebaseDatabase.getInstance().getReference("Interests")
        interestList= mutableListOf()
        refInterest.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(i in p0.children){
                        val interest=i.getValue(Interest::class.java)
                        interestList.add(interest!!)
                    }
                    for(i in interestList){
                        placesTypeList.add(i.name!!)
                    }

                    ll.adapter = PlacesButtonAdapter(placesTypeList)
                }
            }
        })

        /*VERTICAL LISTVIEW ZONE*/
        val listViewPlaces:ListView = view.findViewById(R.id.listView_places)

        /*GET FROM FIREBASE PLACES*/
        val refPlaces=FirebaseDatabase.getInstance().getReference("Places")
        placesList= mutableListOf()
        places= arrayListOf()
        refPlaces.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(i in p0.children){
                        val place=i.getValue(Place::class.java)
                        placesList.add(place!!)
                    }
                    for(i in placesList){
                        places.add(i)
                    }
                    val placesAdapter = PlacesAdapter(places, activity!!.applicationContext)
                    listViewPlaces.adapter = placesAdapter
                }
            }
        })

        /*HORIZONTAL RECYCLEVIEW ONCLICK*/
        ll.addOnItemTouchListener(RecyclerItemClickListener(this.activity!!, object : RecyclerItemClickListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                start(position)
            }
        }))

        listViewPlaces.isClickable = true
        listViewPlaces.onItemClickListener=object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemValue=listViewPlaces.getItemAtPosition(position) as String
                Toast.makeText(activity!!.applicationContext, "Clicked item :"+itemValue,Toast.LENGTH_SHORT).show()
                val click=view?.findViewById<RelativeLayout>(R.id.click)
                click?.setOnClickListener {
                    val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
                    val tr = fragmentManager?.beginTransaction()
                    val infoFragment:Fragment= PlacesPageFragment3.newInstance()
                    tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                    tr?.replace(R.id.frame, infoFragment!!)?.addToBackStack(null)
                    tr?.commit()
                }
            }
        }

//        ivBasket=view.findViewById(R.id.image_basket)
//        ivBasket?.setOnClickListener {
//            val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
//            val tr = fragmentManager?.beginTransaction()
//            val infoFragment:Fragment= PlacesPageFragment3.newInstance()
//            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
//            tr?.replace(R.id.frame, infoFragment!!)?.addToBackStack(null)
//            tr?.commit()
//
////            DBUtilsFb.addPlace("The Art Museum named after Kasteev",1000.0,"Satpaeva 50a","Tuesday - Sunday","10:00 - 18:00","MAK",
////                    "loremIpsumaddasdadadasdqwdqwdqwd","MUSEUM")
//        }

        return view
    }

    fun generatePlacesByType(){
        placeHashMap= hashMapOf()
        for(i in placesTypeList){
            for(j in places){
                if(i.equals(j.type)){
                    placeHashMap.put(i,j)
                }
            }
        }
    }

    fun start(position:Int){
        val listViewPlaces:ListView=view!!.findViewById(R.id.listView_places)
        places1 = arrayListOf()
        places1.clear()

        generatePlacesByType()

        var itrs:String?=null
        for(i in placesTypeList.indices){
            if(i.equals(position)){
                itrs=placesTypeList.get(position)
            }
        }
        for(i in placeHashMap){
            if(itrs.equals(i.key)){
                places1.add(i.value)
            }
        }
        val placesAdapter = PlacesAdapter(places1, activity!!.applicationContext)
        listViewPlaces.adapter = placesAdapter
    }

    companion object {
        fun newInstance(): PlacesPageFragment1 {
            val fragment = PlacesPageFragment1()
            return fragment
        }
    }

}

