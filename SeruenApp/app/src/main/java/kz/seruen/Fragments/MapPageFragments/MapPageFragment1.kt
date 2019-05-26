package kz.seruen.Fragments.MapPageFragments

import android.annotation.SuppressLint
import android.os.Build
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.annotations.Marker
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import kz.seruen.R

class MapPageFragment1 : Fragment(), PermissionsListener, OnMapReadyCallback,MapboxMap.OnMapClickListener {

    private var fragmentActivity: FragmentActivity?=null
    private var mapTripButton: Button?=null
    private var mapView: MapView?=null
    private var map: MapboxMap?=null
    private var permissionsManager:PermissionsManager=PermissionsManager(this)

    private var mapStart:Button?=null
    private var originPoint: Point?=null
    private var destPoint:Point?=null
    private var destMarker:Marker?=null


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
        mapView?.getMapAsync(this)
        mapTripButton?.setOnClickListener {
            val fragmentManager: FragmentManager?=fragmentActivity?.supportFragmentManager
            val tr = fragmentManager?.beginTransaction()
            val tripFragment:Fragment= MapPageFragment2.newInstance()
            tr?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
            tr?.replace(R.id.frame, tripFragment!!)?.addToBackStack(null)
            tr?.commit()
        }

        mapStart?.setOnClickListener{
            //potom
        }
    }

    fun initialize(){
        mapTripButton=view?.findViewById(R.id.button_trip)
        fragmentActivity=activity
        mapView=view?.findViewById(R.id.mapView)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        this.map=mapboxMap
        map?.setStyle(Style.MAPBOX_STREETS){
            enableLocationComponent(it)
        }
    }

    @SuppressLint("MissingPermission")
    private fun enableLocationComponent(mapStyle:Style){
        if(PermissionsManager.areLocationPermissionsGranted(activity)) {
            val customLocationComponentOptions = LocationComponentOptions
                    .builder(view!!.context)
                    .trackingGesturesManagement(true)
                    .accuracyColor(ContextCompat.getColor(view!!.context, R.color.GP_GC_1))
                    .build()

            val locationComponentActivationOptions = LocationComponentActivationOptions
                    .builder(view!!.context, mapStyle)
                    .locationComponentOptions(customLocationComponentOptions)
                    .useDefaultLocationEngine(true)
                    .build()

            map!!.locationComponent.apply {
                activateLocationComponent(locationComponentActivationOptions)
                isLocationComponentEnabled = true
                cameraMode = CameraMode.TRACKING
                renderMode = RenderMode.COMPASS
            }
        }else{
            permissionsManager= PermissionsManager(this)
            permissionsManager.requestLocationPermissions(activity)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        permissionsManager.onRequestPermissionsResult(requestCode,permissions,grantResults)
    }

    override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {
        Toast.makeText(view!!.context, "User location permission explanation", Toast.LENGTH_LONG).show()
    }

    override fun onPermissionResult(granted: Boolean) {
        if(granted){
            enableLocationComponent(map?.style!!)
        }else{
            Toast.makeText(view!!.context,"User location permission not garanted", Toast.LENGTH_LONG).show()
            activity?.finish()
        }
    }

    @SuppressLint("MissingPermission")
    override fun onMapClick(point: LatLng): Boolean {
        destMarker?.let {
            map?.removeMarker(it)
        }

        destMarker=map?.addMarker(MarkerOptions().position(point))
        destPoint=Point.fromLngLat(point.longitude,point.latitude)
        originPoint= Point.fromLngLat(map?.locationComponent?.lastKnownLocation!!.longitude,map?.locationComponent?.lastKnownLocation!!.latitude)

        mapStart?.isEnabled=true
        mapStart?.setBackgroundResource(R.color.GP_GC_2)

        return true
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
