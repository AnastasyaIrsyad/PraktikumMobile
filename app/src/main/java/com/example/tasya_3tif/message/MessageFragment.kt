package com.example.tasya_3tif.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tasya_3tif.R
import com.example.tasya_3tif.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://avatarapi.runflare.run/public/1", "19:01"),
        MessageModel("Budi", "Sudah makan?", "https://avatarapi.runflare.run/public/2", "13:19"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://avatarapi.runflare.run/public/3", "16:00"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://avatarapi.runflare.run/public/4", "11:01"),
        MessageModel("Eka", "Nice job kemarin!", "https://avatarapi.runflare.run/public/5", "02:23"),
        MessageModel("Fajar", "Lagi ngapain?", "https://avatarapi.runflare.run/public/6", "01:59"),
        MessageModel("Gita", "Boleh minta tolong?", "https://avatarapi.runflare.run/public/7", "20:34"),
        MessageModel("Hana", "Lihat email ya", "https://avatarapi.runflare.run/public/8", "21:11"),
        MessageModel("Irfan", "Oke noted", "https://avatarapi.runflare.run/public/9", "22:27"),
        MessageModel("Joko", "Sampai jumpa besok", "https://avatarapi.runflare.run/public/10", "13:59")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }
}