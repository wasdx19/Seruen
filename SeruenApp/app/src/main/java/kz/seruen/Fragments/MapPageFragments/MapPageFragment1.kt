package kz.seruen.Fragments.MapPageFragments

import android.annotation.SuppressLint
import android.location.Location
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import com.mapbox.android.core.location.LocationEngine
import com.mapbox.android.core.location.LocationEngineProvider
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.location.LocationComponent
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import kz.seruen.Fragments.HomePageFragments.HomePageFragment2

import kz.seruen.R

class MapPageFragment1 : Fragment(), PermissionsListener, OnMapReadyCallback {
    val REQUEST_CHECK_SETTINGS = 1

    lateinit var map: MapboxMap
    lateinit var permissionManager: PermissionsManager
    var originLocation: Location? = null

    var locationEngine: LocationEngine? = null
    var locationComponent: LocationComponent? = null

    var fragmentActivity: FragmentActivity?=null
    var mapTripButton: Button?=null
    var mapView: MapView?=null
    var permissionsManager:PermissionsManager?=null
    var mapboxMap:MapboxMap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity!!.window
            w.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {
        return inflater.inflate(R.layout.activity_map1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()

        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS){

            }
        }

        mapTripButton?.setOnClickListener {
            val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val tripFragment:Fragment= MapPageFragment2.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, tripFragment!!)?.addToBackStack(null)
            tr?.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    fun initialize(){
        mapTripButton=view?.findViewById(R.id.button_trip)
        fragmentActivity=activity
        mapView=view?.findViewById(R.id.mapView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView?.onDestroy()
    }

    companion object {
        fun newInstance(): MapPageFragment1 {
            val fragment = MapPageFragment1()
            return fragment
        }
    }

    fun enableLocation() {

    }

    @SuppressWarnings("MissingPermission")
    fun initializeLocationEngine() {

    }

    @SuppressWarnings("MissingPermission")
    fun initializeLocationComponent() {

    }

    fun setCameraPosition(location: Location) {

    }

    override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {
    }

    override fun onPermissionResult(granted: Boolean) {
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
    }
}
