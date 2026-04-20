package com.example.mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // ✅ Binding setup (cukup ini saja, jangan setContentView dua kali)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // =========================
        // 🔹 EXPLICIT INTENT
        // =========================

        // ➜ Ke Login
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // ➜ Ke Register
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // =========================
        // 🔥 IMPLICIT INTENT
        // =========================

        // 🌐 Buka Website
        binding.btnWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }

        // 📍 Buka Maps (contoh lokasi)
        binding.btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("geo:-6.2,106.8")
            startActivity(intent)
        }

        // 📞 Dial Telepon
        binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:08123456789")
            startActivity(intent)
        }

        // =========================
        // 🔧 HANDLE EDGE TO EDGE
        // =========================
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }
}