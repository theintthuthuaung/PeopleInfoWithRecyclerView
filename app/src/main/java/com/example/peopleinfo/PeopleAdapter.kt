package com.example.peopleinfo

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter (peopleData:ArrayList<People> , var context: Context) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    var peopleData:ArrayList<People>
    init {
        this.peopleData = peopleData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout:View
        layout = LayoutInflater.from(context).inflate(R.layout.custom_item , parent , false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return peopleData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemData = peopleData[position]
        holder.name.text = itemData.name
        holder.image.setImageResource(itemData.image!!)

        holder.card.setOnClickListener{
            var alert = Dialog(context)
            alert.setContentView(R.layout.people_layout)

            var name = alert.findViewById<TextView>(R.id.alert_name)
            var desc = alert.findViewById<TextView>(R.id.alert_desc)
            var phone = alert.findViewById<TextView>(R.id.alert_phone)
            var image = alert.findViewById<ImageView>(R.id.alert_image)

            name.text = itemData.name
            desc.text = itemData.desc
            phone.text = itemData.phone
            image.setImageResource(itemData.image!!)

            alert.show()

            var callBTN = alert.findViewById<Button>(R.id.call_btn)
            callBTN.setOnClickListener {
                var intent = Intent(Intent.ACTION_DIAL , Uri.fromParts("tel",itemData.phone,null))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(context , intent , null)

                alert.dismiss()
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name:TextView
        var image:ImageView
        var card:CardView

        init {
            name = itemView.findViewById(R.id.person_name)
            image = itemView.findViewById(R.id.person_image)
            card = itemView.findViewById(R.id.people_card)
        }
    }

}