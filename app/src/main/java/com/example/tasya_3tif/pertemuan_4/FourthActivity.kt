package com.example.tasya_3tif.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tasya_3tif.R
import com.example.tasya_3tif.databinding.ActivityFourthBinding
import com.google.android.material.snackbar.Snackbar
import com.example.tasya_3tif.MainActivity
import android.util.Log
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityFourthBinding
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age",0)
        Log.w("Data Intent","Nama: $name , Usia: $age, Asal: $from")

        binding.btnKembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //Mengambil value dari inputNama dan menampilkan di Logcat
            val kembali = binding.btnKembali.text
            // Log.e("Klik btnSubmit","Tombol berhasil di tekan. Isi dari inputNama = $nama")

            Toast.makeText(this, "Pesan berhasil dikirim ke $kembali", Toast.LENGTH_SHORT).show()
        }

        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
                    // finish()
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }

        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // finish()
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    // finish()
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }
    }
}