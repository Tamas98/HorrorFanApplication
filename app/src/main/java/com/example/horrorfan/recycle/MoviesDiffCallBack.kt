package com.example.horrorfan.recycle

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.horrorfan.database.Movies
import java.sql.DataTruncation

class MoviesDiffCallBack : DiffUtil.ItemCallback<DataItem>()  {

    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}