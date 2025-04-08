package com.example.tgs_2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecviewActivity : AppCompatActivity() {
    private lateinit var makananRecyclerView: RecyclerView
    private lateinit var makananAdapter: MyAdapter
    private lateinit var listMakanan: ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recview)

        // Inisialisasi RecyclerView
        makananRecyclerView = findViewById(R.id.makanan)

        // Inisialisasi listMakanan
        listMakanan = ArrayList()

        // Menambahkan data makanan
        listMakanan.add(ItemData(R.drawable.rendang, "Rendang", "Sumatra Barat"))
        listMakanan.add(ItemData(R.drawable.papeda, "Papeda", "Papua"))
        listMakanan.add(ItemData(R.drawable.babi, "Babi Guling", "Bali"))
        listMakanan.add(ItemData(R.drawable.pempek, "Pempek", "Sumatra Selatan"))
        listMakanan.add(ItemData(R.drawable.coto, "Coto Makassar", "Sulawesi Selatan"))
        listMakanan.add(ItemData(R.drawable.rendang, "Rendang", "Sumatra Barat"))
        listMakanan.add(ItemData(R.drawable.papeda, "Papeda", "Papua"))
        listMakanan.add(ItemData(R.drawable.babi, "Babi Guling", "Bali"))
        listMakanan.add(ItemData(R.drawable.pempek, "Pempek", "Sumatra Selatan"))
        listMakanan.add(ItemData(R.drawable.coto, "Coto Makassar", "Sulawesi Selatan"))


        // Debugging log untuk memastikan data telah dimasukkan
        Log.d("RecviewActivity", "Jumlah item di listMakanan: ${listMakanan.size}")

        // Setup RecyclerView
        makananRecyclerView.layoutManager = LinearLayoutManager(this)
        makananRecyclerView.setHasFixedSize(true)

        // Inisialisasi adapter dan set ke RecyclerView
        makananAdapter = MyAdapter(listMakanan)
        makananRecyclerView.adapter = makananAdapter
    }
}
