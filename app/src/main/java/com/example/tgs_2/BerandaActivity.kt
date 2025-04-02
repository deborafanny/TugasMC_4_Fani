package com.example.tgs_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        // Inisialisasi Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Beranda"

        // Inisialisasi EditText dan Button
        val txtDesc = findViewById<EditText>(R.id.txtDesc)
        val btnShare = findViewById<Button>(R.id.btnExplore)
        val btnLogout = findViewById<ImageView>(R.id.btnLogout)
        val btnRecyclerView = findViewById<Button>(R.id.button) // ID tombol RecyclerView

        // Ketika tombol Share ditekan
        btnShare.setOnClickListener {
            val textToShare = txtDesc.text.toString().trim()
            if (textToShare.isNotEmpty()) {
                shareText(textToShare)
            } else {
                txtDesc.error = "Tulis sesuatu untuk dibagikan!"
            }
        }

        // Ketika tombol Logout ditekan
        btnLogout.setOnClickListener {
            logoutUser()
        }

        // Ketika tombol RecyclerView ditekan
        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecviewActivity::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk berbagi teks ke aplikasi lain
    private fun shareText(text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
    }

    // Fungsi untuk Logout
    private fun logoutUser() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
