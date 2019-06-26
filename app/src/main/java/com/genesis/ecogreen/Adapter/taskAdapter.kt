package com.genesis.ecogreen.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.genesis.ecogreen.R
import com.genesis.ecogreen.Models.Task
import kotlinx.android.synthetic.main.cardview_tasks.view.*

class taskAdapter (
    var task : List<Task>,
    listener:OnItemClickListener) : RecyclerView.Adapter<taskAdapter.ViewHolder>(){

    companion object {
        private var listener1:OnItemClickListener? = null
    }

    init{
        listener1 = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_tasks, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = task.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(task[position])
        holder.setOnClickListener()
    }

    interface OnItemClickListener {
        fun onItemClickListener(view:View)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        override fun onClick(v: View?) {
            if (v != null) {
                listener1?.onItemClickListener(v)
            }
        }

        var context: Context = itemView.context

        fun setOnClickListener() {
            itemView.setOnClickListener(this)
        }

        fun bind(item: Task) = with(itemView) {

            Glide.with(task_logo.context)
                .load(item.image)
                .into(task_logo)

            task_name.text = item.nombre
        }

    }

}