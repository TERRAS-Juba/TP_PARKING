package com.example.parking_tp3

import android.app.Person
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ParkingAdapter(var context: Context, var parkings: List<Parking>) :
    RecyclerView.Adapter<ParkingAdapter.ParkingHolder>() {

    class ParkingHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageParking: ImageView = itemView.findViewById(R.id.imageParking)
        val nomParking: TextView = itemView.findViewById(R.id.nomParking)
        val positionParking: TextView = itemView.findViewById(R.id.positionParking)
        val statutParking: TextView = itemView.findViewById(R.id.statutParking)
        val capaciteParking: TextView = itemView.findViewById(R.id.capaciteParking)
        val distanceParking: TextView = itemView.findViewById(R.id.distanceParking)
        val dureeParking: TextView = itemView.findViewById(R.id.dureeParking)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_parking, parent, false)

        return ParkingHolder(view)
    }

    override fun onBindViewHolder(holder: ParkingHolder, position: Int) {
        val parking = parkings[position]
        holder.imageParking.setImageResource(parking.image)
        holder.nomParking.text = parking.nom
        holder.positionParking.text = parking.position
        holder.statutParking.text = parking.statut
        if (holder.statutParking.text == "Fermé") {
            holder.statutParking.setTextColor(Color.parseColor("#f00020"))
        } else {
            holder.statutParking.setTextColor(Color.parseColor("#008000"))
        }
        holder.capaciteParking.text = parking.capacite.plus(" % ")
        holder.distanceParking.text = parking.distance.plus(" Km ")
        holder.distanceParking.setTextColor(Color.parseColor("#0080ff"))
        holder.dureeParking.text = parking.duree.plus(" min ")
        //Changer les données
        // parking[position]=""
        //notifyDataSetChanged()
        holder.itemView.setOnClickListener({
            var intent = Intent(context, DetailsPaking::class.java)
            intent.putExtra("current",parkings[position])
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return parkings.size
    }
}