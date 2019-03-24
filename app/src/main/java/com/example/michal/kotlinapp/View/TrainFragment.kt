package com.example.michal.kotlinapp.View

import com.example.michal.kotlinapp.R

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TrainFragment : Fragment(){

    private lateinit var depTime : TextView
    private lateinit var arrTime : TextView
    private lateinit var lastStation : TextView
    private lateinit var platform : TextView
    private lateinit var type : TextView

    companion object {
        fun newInstance( params : String) : TrainFragment{
            val fragment = TrainFragment()
            var bundle = Bundle()
            bundle.putString("PAR", params)

            fragment.arguments = bundle

            Log.e("test", params)

            return fragment
        }
    }



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.train_fragment, container, false)

        this.arrTime = view.findViewById(R.id.arrTime)
        this.arrTime.text = arguments?.get("PAR") as CharSequence?
        this.depTime = view.findViewById(R.id.depTime)
        this.type = view.findViewById(R.id.type)
        this.platform = view.findViewById(R.id.platform)
        this.lastStation = view.findViewById(R.id.lastStation)

        Log.e("test2", arguments?.get("PAR") as String)

        return view

    }

}