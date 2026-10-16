package com.example.tasya_3tif.home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tasya_3tif.R
import com.example.tasya_3tif.databinding.FragmentHomeBinding
import com.example.tasya_3tif.home.pertemuan_4.FourthActivity
import com.example.tasya_3tif.home.pertemuan_5.FifthActivity
import com.example.tasya_3tif.home.pertemuan_7.SeventhActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.tasya_3tif.AuthActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        // ini burtton mengarah ke desain P4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            /*tambahkan bagian berikut*/
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)

            //Mengambil value dari inputNama dan menampilkan di Logcat
            val kirim = binding.inputan.text

            Toast.makeText(requireContext(), "Pesan berhasil dikirim ke $kirim", Toast.LENGTH_SHORT)
                .show()
            requireActivity().finish()
        }

        // ini burtton mengarah ke desain P5
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        // Akses SharedPreferences "user_pref"
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        // Logout: tampilkan konfirmasi AlertDialog, jika "Ya" hapus data lalu finish()
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ -> dialog.dismiss() }
                .show()
        }
        // ini burtton mengarah ke desain P7
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }
    }
}