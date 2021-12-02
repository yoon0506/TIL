package com.yoon.customviewtest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yoon.customviewtest.databinding.ItemPurchaseBooksBinding

class PurchaseBookAdapter(private val bookList: ArrayList<Book>) :
    RecyclerView.Adapter<PurchaseBookAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PurchaseBookAdapter.ViewHolder {
        val binding = ItemPurchaseBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PurchaseBookAdapter.ViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    inner class ViewHolder(private val binding: ItemPurchaseBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book?) {
            if (book != null) {
                val urlString = book.bookCoverUrl
                Log.d("checkCheck", "urlString : $urlString")
                if (urlString.isNotEmpty()) {
                    Picasso.get().load(urlString).into(binding.bookCover)
                    Log.d("checkCheck", "book cover : $urlString")
                } else {
                    binding.bookCover.visibility = View.GONE
                }
            }
        }
    }
}

