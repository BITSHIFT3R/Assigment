package com.infy.telstra.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.infy.telstra.R
import com.infy.telstra.databinding.ItemFactBinding
import com.infy.telstra.model.FactItem

class FactAdapter(val factList:List<FactItem>) :RecyclerView.Adapter<FactAdapter.FactViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactAdapter.FactViewHolder {
       val itemFactBinding : ItemFactBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.context),
       R.layout.item_fact,
           parent,
           false)
        return FactViewHolder(itemFactBinding)
    }

    override fun onBindViewHolder(holder: FactAdapter.FactViewHolder, position: Int) {
       holder.itemFactBinding.factItem = factList[position]
    }

    override fun getItemCount(): Int {
       return factList.size
    }

    class FactViewHolder (val itemFactBinding: ItemFactBinding): RecyclerView.ViewHolder(itemFactBinding.root)
}