package com.nadikarim.valproject1.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nadikarim.valproject1.R
import com.nadikarim.valproject1.core.domain.model.Agent
import com.nadikarim.valproject1.databinding.ListLayoutBinding

class AgentAdapter : RecyclerView.Adapter<AgentAdapter.ViewHolder>() {

    private var listData = ArrayList<Agent>()
    var onItemClick: ((Agent) -> Unit)? = null

    fun setData(newListData: List<Agent>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ListLayoutBinding.bind(itemView)
        fun bind(data: Agent) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.displayIcon)
                    .into(binding.agentImage)
                agentName.text = data.displayName
                description.text = data.description
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size
}