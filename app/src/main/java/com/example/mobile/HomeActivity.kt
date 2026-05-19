package com.example.mobile

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.kabarkota.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageList: ArrayList<Image>
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // TOOLBAR
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // RECYCLERVIEW
        recyclerView = findViewById(R.id.recyclerView)

        // DATA
        imageList = arrayListOf(

            Image(
                R.drawable.crong,
                "Crong",
                "Crong adalah dinosaurus kecil sahabat Pororo"
            ),

            Image(
                R.drawable.eddy,
                "Eddy",
                "Eddy adalah rubah pintar"
            ),

            Image(
                R.drawable.harry,
                "Harry",
                "Harry suka bernyanyi"
            ),

            Image(
                R.drawable.loopy,
                "Loopy",
                "Loopy adalah berang-berang lucu"
            ),

            Image(
                R.drawable.petty,
                "Petty",
                "Petty adalah penguin perempuan"
            ),

            Image(
                R.drawable.poby,
                "Poby",
                "Poby adalah beruang putih baik hati"
            ),

            Image(
                R.drawable.pororo,
                "Pororo",
                "Pororo adalah karakter utama"
            )
        )

        // ADAPTER
        imageAdapter = ImageAdapter(imageList)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        recyclerView.adapter = imageAdapter

        // INTENT KE DETAIL
        imageAdapter.onItemClick = {

            val intent =
                Intent(this, DetailActivity::class.java)

            intent.putExtra("image", it)

            startActivity(intent)
        }
    }

    // MENAMPILKAN MENU
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_option, menu)

        return true
    }

    // AKSI MENU
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.menu_profile -> {
                Toast.makeText(
                    this,
                    "Profile Click",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.menu_setting -> {
                Toast.makeText(
                    this,
                    "Setting Click",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.menu_logout -> {
                Toast.makeText(
                    this,
                    "Logout Click",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}