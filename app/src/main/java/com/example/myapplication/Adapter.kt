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
    class ViewHolder(
            private val binding: SpisokBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ds: DataStrings) {
            binding.textOneTV.text = ds.TextOne
            binding.textTwoTV.text = ds.TextTwo
            binding.textThreeTV.text = ds.TextThree
            binding.textFourTV.text = ds.TextFour
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = SpisokBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val spsk = stroki[position]
        viewHolder.bind(spsk)
    }

    override fun getItemCount() = stroki.size

}
