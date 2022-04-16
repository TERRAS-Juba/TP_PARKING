package com.example.parking_tp3

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parking_tp3.databinding.ActivityDetailsPakingBinding
import com.example.parking_tp3.databinding.ActivityMainBinding

class DetailsPaking : AppCompatActivity() {
    lateinit var Binding:ActivityDetailsPakingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getSupportActionBar()?.hide();
        Binding= ActivityDetailsPakingBinding.inflate(layoutInflater)
        val view=Binding.root
        setContentView(view)
        val parking= intent.getSerializableExtra("current") as Parking
        Binding.image.setImageResource(parking.image)
        Binding.nom.text=parking.nom
        Binding.position.text=parking.position
        Binding.statut.text=parking.statut
        if (parking.statut == "Fermé") {
            Binding.statut.setTextColor(Color.parseColor("#f00020"))
        } else {
            Binding.statut.setTextColor(Color.parseColor("#008000"))
        }
        Binding.capacite.text=parking.capacite.plus(" % ")
        Binding.distance.text=parking.distance.plus(" KM ")
        Binding.duree.text=parking.duree.plus(" min ")
        Binding.distance.setTextColor(Color.parseColor("#0080ff"))
        Binding.ouvertureFermeture.text=parking.heure_ouverture.plus(" a ").plus(parking.heure_fermeture)
        Binding.horaire.text=parking.horaire
        Binding.tarif.text= parking.tarif.toString().plus(" DZ ")
        Binding.map.setOnClickListener({
            val latitude = parking.latitude
            val longitude = parking.longitude
            val intent = Uri.parse("geo:$latitude,$longitude").let {
            Intent(Intent.ACTION_VIEW,it)
        }
            startActivity(intent)

        })
        Binding.share.setOnClickListener({
            val intent= Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,
                    parking.nom)
                type = "text/plain"
            }
            startActivity(intent)
        })
    }
}