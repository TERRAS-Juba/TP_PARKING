package com.example.parking_tp3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parking_tp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var Binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding= ActivityMainBinding.inflate(layoutInflater)
        val view=Binding.root
        setContentView(view)
        val parkings=loadData()
        Binding.recycleParking.layoutManager= LinearLayoutManager(this)
        val adapter=ParkingAdapter(this,parkings)
        Binding.recycleParking.adapter=adapter
    }

    fun loadData():List<Parking>{
        var parkings=mutableListOf<Parking>()
        var noms=getResources().getStringArray(R.array.noms)
        var positions=getResources().getStringArray(R.array.positions)
        var status=getResources().getStringArray(R.array.status)
        var capacites=getResources().getStringArray(R.array.capacites)
        var distances=getResources().getStringArray(R.array.distances)
        var durees=getResources().getStringArray(R.array.durees)
        var longitudes=getResources().getStringArray(R.array.longitudes)
        var latitudes=getResources().getStringArray(R.array.latitudes)
        var tarifs=getResources().getStringArray(R.array.tarifs)
        var horaires=getResources().getStringArray(R.array.horaires)
        var heures_ouverture=getResources().getStringArray(R.array.heures_ouverture)
        var heures_fermeture=getResources().getStringArray(R.array.heures_fermeture)
        for (i in noms.indices){
            var parking=Parking(
                noms[i],
                positions[i],
                status[i],
                capacites[i],
                distances[i],
                durees[i],
                R.drawable.parking,
                longitudes[i].toDouble(),
                latitudes[i].toDouble(),
                tarifs[i].toDouble(),
                horaires[i],
                heures_ouverture[i],
                heures_fermeture[i]
            )
            parkings.add(parking)
        }
        return parkings
    }
}