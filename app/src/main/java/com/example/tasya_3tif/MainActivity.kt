package com.example.tasya_3tif

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tasya_3tif.databinding.ActivityFourthBinding
import com.example.tasya_3tif.databinding.ActivityMainBinding
import com.example.tasya_3tif.pertemuan_3.ThirdResultActivity
import kotlin.jvm.java
import com.example.tasya_3tif.pertemuan_4.FourthActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            /*tambahkan bagian berikut*/
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)

            //Mengambil value dari inputNama dan menampilkan di Logcat
            val kirim = binding.inputan.text

            Toast.makeText(this, "Pesan berhasil dikirim ke $kirim", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}