package com.example.michal.kotlinapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.michal.kotlinapp.DataBase.DataBaseDetails
import com.example.michal.kotlinapp.DataBase.DataBaseHandler
import com.example.michal.kotlinapp.View.TrainFragment
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), LocationCallback  {

    private val str1 : String = "Start: Słomniki, Cel: Kraków"
    private val str2 : String = "Start: Kraków, Cel: Słomniki"


    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationHandler = LocationHandler()
        locationHandler.requestForUpdate(applicationContext, this)


        val simpleTime = SimpleDateFormat("HH:mm")
        val simpleDay = SimpleDateFormat("EEEE")

        val tv: TextView = findViewById(R.id.time)
        tv.text = simpleDay.format(Date()).toUpperCase() + ", " + simpleTime.format(Date())

//        val dbHandler = DataBaseHandler(applicationContext)
//
//        val db = dbHandler.writableDatabase
//
//        val values = ContentValues().apply {
//            put(DataBaseDetails.LAST_STATION_COLUMN, "Kraków")
//            put(DataBaseDetails.DAYS_COLUMN, "codz")
//            put(DataBaseDetails.DIRECTION_COLUMN, "sk")
//            put(DataBaseDetails.PLATFORM_COLUMN, "5")
//            put(DataBaseDetails.TYPE_COLUMN, "KMŁ")
//        }
//
//        val newRow = db?.insert(DataBaseDetails.TABLE_NAME, null, values )


        for (i in 1..3 ){
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()

            val fragment1 = TrainFragment.newInstance("test$i")

            transaction.add(R.id.conteiner, fragment1, "fragment_$i")
            transaction.commit()

        }


    }

    override fun onLocationLoaded(latitude: Double) {
        val tv: TextView = findViewById(R.id.header)

        if(latitude > 50.18){
            tv.text = this.str1
        } else {
            tv.text = this.str2
        }

    }

}
