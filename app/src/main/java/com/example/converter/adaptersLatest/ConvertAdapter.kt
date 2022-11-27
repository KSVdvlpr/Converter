package com.example.converter.adaptersLatest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.converter.R
import com.example.converter.databinding.ListItemBinding
import java.text.SimpleDateFormat
import java.util.*

class ConvertAdapter : ListAdapter<ItemModel, ConvertAdapter.Holder>(Comparator()) { // по форме записи еще раз
    class Holder(view: View) : RecyclerView.ViewHolder(view) { // ??
        val binding = ListItemBinding.bind(view)
        fun bind(item: ItemModel) = with(binding) {
            date.text = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(item.date)
            currencyName.text = item.baseCurrencyName
            nowValueText.text = item.referenceCurrency.name
            rightValue.text = item.referenceCurrency.value.toString()
        }
    }

    class Comparator : DiffUtil.ItemCallback<ItemModel>() { // ??
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}
