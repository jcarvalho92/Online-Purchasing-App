package com.example.group5_mapd711_assign2_pizzaonline.views

//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.group5_mapd711_assign2_pizzaonline.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    //private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //adding the Options menu in the activity
        menuInflater.inflate(R.menu.maptypes,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val i = Intent(this, MapsActivity::class.java)

        //checking which menu was selected 
        when (item.itemId){
            R.id.standard ->
                i.putExtra("type", "standard")
            R.id.satellite ->
                i.putExtra("type", "satellite")
            R.id.hybrid ->
                i.putExtra("type", "hybrid")
        }

        startActivity(i)
        return true
    }


    override fun onMapReady(googleMap: GoogleMap) {
        var mMap = googleMap

        val intent = intent

        val type = intent.getStringExtra("type")

        //verifying which map was choosen
        when (type) {
            "standard" -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
            "satellite" -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
            "hybrid" -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
            else -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        }
        mMap = googleMap
        var zoomIn = 10.0F

        val location = intent.getStringExtra("location")

        //verifying which location was choosen
        when (location) {
            "mississauga" -> {
                // Add a marker in Mississauga
                val mississauga = LatLng(43.5872187, -79.7427284)
                mMap.addMarker(MarkerOptions().position(mississauga).title("MAPD Pizza in Mississauga").snippet("Monday - Sunday 10a.m. - 10p.m."))
                val cuf = CameraUpdateFactory.newLatLngZoom(mississauga, zoomIn)
                mMap.moveCamera(cuf)
            }
            "northyork" -> {
                // Add a marker in North York
                val northYork = LatLng(43.7932641, -79.355892)
                mMap.addMarker(MarkerOptions().position(northYork).title("MAPD Pizza in North York").snippet("Monday - Sunday 10a.m. - 10p.m."))
                val cuf = CameraUpdateFactory.newLatLngZoom(northYork, zoomIn)
                mMap.moveCamera(cuf)

            }
            "oakville" -> {
                // Add a marker in Oakville
                val oakville = LatLng(43.4885485, -79.9971199)
                mMap.addMarker(MarkerOptions().position(oakville).title("MAPD Pizza in Oakville").snippet("Monday - Sunday 10a.m. - 10p.m."))
                val cuf = CameraUpdateFactory.newLatLngZoom(oakville, zoomIn)
                mMap.moveCamera(cuf)
            }
            "scarborough" -> {
                // Add a marker in Scarborough
                val scarborough = LatLng(43.7072547, -79.2717423)
                mMap.addMarker(MarkerOptions().position(scarborough).title("MAPD Pizza in Scarborough").snippet("Monday - Sunday 10a.m. - 10p.m."))
                val cuf = CameraUpdateFactory.newLatLngZoom(scarborough, zoomIn)
                mMap.moveCamera(cuf)
            }
            "toronto" -> {
                // Add a marker in Toronto
                val toronto = LatLng(43.7894885, -79.4193911 )
                mMap.addMarker(MarkerOptions().position(toronto).title("MAPD Pizza in Toronto").snippet("Monday - Sunday 10a.m. - 10p.m."))
                val cuf = CameraUpdateFactory.newLatLngZoom(toronto, zoomIn)
                mMap.moveCamera(cuf)
            }
            else -> {
                // Add a marker in Toronto
                val toronto = LatLng(43.7894885, -79.4193911 )
                mMap.addMarker(MarkerOptions().position(toronto).title("MAPD Pizza in Toronto").snippet("Monday - Sunday 10a.m. - 10p.m."))

                // Add a marker in Mississauga
                val mississauga = LatLng(43.5872187, -79.7427284)
                mMap.addMarker(MarkerOptions().position(mississauga).title("MAPD Pizza in Mississauga").snippet("Monday - Sunday 10a.m. - 10p.m."))

                // Add a marker in Scarborough
                val scarborough = LatLng(43.7072547, -79.2717423)
                mMap.addMarker(MarkerOptions().position(scarborough).title("MAPD Pizza in Scarborough").snippet("Monday - Sunday 10a.m. - 10p.m."))

                // Add a marker in Oakville
                val oakville = LatLng(43.4885485, -79.9971199)
                mMap.addMarker(MarkerOptions().position(oakville).title("MAPD Pizza in Oakville").snippet("Monday - Sunday 10a.m. - 10p.m."))

                // Add a marker in North York
                val northYork = LatLng(43.7932641, -79.355892)
                mMap.addMarker(MarkerOptions().position(northYork).title("MAPD Pizza in North York").snippet("Monday - Sunday 10a.m. - 10p.m."))

                val builder = LatLngBounds.Builder()

                builder.include(mississauga)
                builder.include(toronto)
                builder.include(scarborough)
                builder.include(oakville)
                builder.include(northYork)

                val bounds = builder.build();

                val width = resources.displayMetrics.widthPixels
                val height = resources.displayMetrics.heightPixels
                val padding = 100

                val cuf = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding)
                mMap.animateCamera(cuf)
            }
        }
    }

}