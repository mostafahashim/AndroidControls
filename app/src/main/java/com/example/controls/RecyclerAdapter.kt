package com.example.controls

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.controls.databinding.ItemProgressLoadingBinding
import com.example.controls.databinding.ItemRecyclerBinding



class RecyclerAdapter(
    var items: ArrayList<RecyclerViewItemModel>,
    var listener: OnRecyclerItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context
    val ItemViewData = 1
    val ItemViewProgress = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        if (viewType == ItemViewData) {
            val binding = DataBindingUtil.inflate(
                inflater,
                R.layout.item_recycler,
                parent,
                false
            ) as ItemRecyclerBinding
            return ViewHolder(binding)
        } else {
            val binding = DataBindingUtil.inflate(
                inflater,
                R.layout.item_progress_loading,
                parent,
                false
            ) as ItemProgressLoadingBinding
            return ProgressViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].holderType!!.isEmpty()) ItemViewData else ItemViewProgress
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProgressViewHolder)
            return

        var holder = holder as ViewHolder
        holder.binding.model = items[holder.layoutPosition]

        holder.binding.root.setOnClickListener { view: View ->
            listener.onRecyclerItemClickListener(holder.layoutPosition)
        }
    }

    fun setList(list: ArrayList<RecyclerViewItemModel>) {
        items = list
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ProgressViewHolder(var binding: ItemProgressLoadingBinding) :
        RecyclerView.ViewHolder(binding.root)
}