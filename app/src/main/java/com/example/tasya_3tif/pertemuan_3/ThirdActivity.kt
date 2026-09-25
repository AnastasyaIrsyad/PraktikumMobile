package com.example.tasya_3tif.pertemuan_3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tasya_3tif.R
import com.example.tasya_3tif.databinding.ActivityThirdBinding
import android.content.Intent

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_third)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
            //Mengambil value dari inputNama dan menampilkan di Logcat
            val nama = binding.inputNama.text
            // Log.e("Klik btnSubmit","Tombol berhasil di tekan. Isi dari inputNama = $nama")

            Toast.makeText(this, "Pesan berhasil dikirim ke $nama", Toast.LENGTH_SHORT).show()
        }
    }
}