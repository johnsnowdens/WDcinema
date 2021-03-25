package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SpisokBinding

class Adapter( val stroki: MutableList<DataStrings>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val  textOneTV:TextView = view.findViewById(R.id.textOneTV)
        val textTwoTV:TextView = view.findViewById(R.id.textTwoTV)
        val textThreeTV:TextView = view.findViewById(R.id.textThreeTV)
        val textFourTV:TextView = view.findViewById(R.id.textFourTV)


        fun bind(ds:DataStrings){
            textOneTV.text = ds.TextOne
            textTwoTV.text =ds.TextTwo
            textThreeTV.text = ds.TextThree
            textFourTV.text = ds.TextFour

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.spisok, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
   val spsk = stroki[position]
   viewHolder.bind(spsk)

    }


    override fun getItemCount() =  stroki.size

}
