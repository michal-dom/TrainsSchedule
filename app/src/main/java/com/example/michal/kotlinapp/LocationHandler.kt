package com.example.michal.kotlinapp

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log

class LocationHandler{

    private var locationManager:LocationManager? = null

    private lateinit var locationCallback: LocationCallback

    var latitude : Double = 0.0
    var longitude : Double = 0.0

    fun LocationHandler(){
    }

    @SuppressLint("MissingPermission")
    fun requestForUpdate(context: Context, locationCallback: LocationCallback){
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        this.locationCallback = locationCallback
        try {
            locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    100L, 10f, locationListener)
        }catch (e : Exception){
            Log.d("myTag", "Security Exception, no location available");
        }
    }



    private val locationListener:LocationListener = object : LocationListener{
        override fun onLocationChanged(p0: Location?) {
            if (p0 != null) {
                longitude = p0.longitude
                latitude = p0.latitude
                Log.e("test", p0.longitude.toString())
                locationCallback.onLocationLoaded(latitude)
            }

        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {

        }

        override fun onProviderEnabled(p0: String?) {

        }

        override fun onProviderDisabled(p0: String?) {
        }
    }
}