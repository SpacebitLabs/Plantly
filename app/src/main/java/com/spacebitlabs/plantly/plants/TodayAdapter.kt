package com.spacebitlabs.plantly.plants

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.spacebitlabs.plantly.R
import com.spacebitlabs.plantly.data.entities.Plant
import com.spacebitlabs.plantly.inflate
import kotlinx.android.synthetic.main.today_list_item.view.*

class TodayAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<TodayAdapter.TodayHolder>() {
    private val plantList: ArrayList<Plant> = ArrayList()

    override fun getItemCount(): Int = plantList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayHolder {
        return TodayHolder(parent.inflate(R.layout.today_list_item))
    }

    override fun onBindViewHolder(holder: TodayHolder, position: Int) {
        holder.bind(plantList[position])
    }

    fun setPlantList(plants: List<Plant>) {
        val diffResult = DiffUtil.calculateDiff(PlantDiffCallback(plantList, plants))
        plantList.clear()
        plantList.addAll(plants)
        diffResult.dispatchUpdatesTo(this)
    }

    class TodayHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(plant: Plant) = with(itemView) {
            name.text = plant.name
            image.setImageResource(R.drawable.sample_plant)
        }
    }
}