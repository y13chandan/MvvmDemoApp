package com.emsib.mvvmdemoapp.screen.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emsib.mvvmdemoapp.databinding.BaseBindingViewHolder
import com.emsib.mvvmdemoapp.databinding.RowLayoutPostBinding
import com.emsib.mvvmdemoapp.models.Post

class HomeAdapter(
    private val posts: List<Post>
): RecyclerView.Adapter<BaseBindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        return ContractViewHolder(RowLayoutPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: BaseBindingViewHolder, position: Int) = holder.onBind(position)

    inner class ContractViewHolder(private val binding: RowLayoutPostBinding) : BaseBindingViewHolder(binding) {
        override fun onBind(item: Any) {
            super.onBind(item)
            binding.item = posts[item as Int]
            binding.executePendingBindings()
        }
    }
}