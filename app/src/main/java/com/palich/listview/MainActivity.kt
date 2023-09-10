package com.palich.listview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<RecyclerView>(R.id.recyclerView)

        val api = SuperHeroApiClient().client.create(SuperHeroApiInterface::class.java)
        api.getSuperHero()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isNotEmpty()) {
                    val items = it
                    val adapter = MyRecyclerViewAdapter(items) {}
                    listView.adapter = adapter
                } else {
                    Toast.makeText(this, "No super heroes", Toast.LENGTH_SHORT).show()
                }
            }, {
                Toast.makeText(this, "Error $it", Toast.LENGTH_SHORT).show()
            })

        listView.layoutManager = LinearLayoutManager(this)
    }
}
