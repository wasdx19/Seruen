package kz.seruen.Fragments.MapPageFragments

import android.location.Location
import android.location.LocationListener
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
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerPlugin
import kz.seruen.R

class MapPageFragment1 : Fragment(), OnMapReadyCallback,LocationListener, PermissionsListener {

    private var fragmentActivity: FragmentActivity?=null
    private var mapTripButton: Button?=null
    private var mapView: MapView?=null
    private var map: MapboxMap?=null
    private var permissionsManager:PermissionsManager?=null
    private var locationEngine: LocationEngine?=null
    private var locationLayerPlugin:LocationLayerPlugin?=null
    private var location:Location?=null

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

    fun initialize(){
        mapTripButton=view?.findViewById(R.id.button_trip)
        fragmentActivity=activity
        mapView=view?.findViewById(R.id.mapView)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        map=mapboxMap
        enableLocation()
    }

    private fun enableLocation(){
        if(PermissionsManager.areLocationPermissionsGranted(context)){
            initializeLocationEngine()
            initializeLocationLayer()
        }else{
            permissionsManager= PermissionsManager(this)
            permissionsManager!!.requestLocationPermissions(activity)
        }
    }

    private fun initializeLocationEngine(){

    }

    private fun initializeLocationLayer(){
        locationLayerPlugin = LocationLayerPlugin(mapView!!, map!!)
        locationLayerPlugin = LocationLayerPlugin(mapView!!, map!!, locationEngine)

    }

    override fun onLocationChanged(p0: Location?) {
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
    }

    override fun onProviderEnabled(p0: String?) {
    }

    override fun onProviderDisabled(p0: String?) {
    }

    override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {
    }

    override fun onPermissionResult(granted: Boolean) {
        if(granted){
            enableLocation()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }


    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause(){
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop(){
        super.onStop()
        mapView?.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
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
}
