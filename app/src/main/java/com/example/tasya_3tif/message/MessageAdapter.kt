package com.example.tasya_3tif.message

import android.content.Context
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.View
import com.example.tasya_3tif.databinding.ItemMessageBinding
import com.bumptech.glide.Glide

class MessageAdapter(
    context: Context,
    private val  Messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, Messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val data = Messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.textWaktu.text = data.time

        return view
    }
}