package com.example.adhitya_siswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterSiswa (private val dataset: MutableList<DataSiswa>):
    RecyclerView.Adapter<AdapterSiswa.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nis = view.findViewById<TextView>(R.id.data_nis)
        val nama = view.findViewById<TextView>(R.id.data_nama)
        val kelamin = view.findViewById<TextView>(R.id.data_kelamin)
        val btnEdit = view.findViewById<Button>(R.id.btnEdit)
        val btnHapus = view.findViewById<Button>(R.id.btnHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_siswa, parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataset[position]
        holder.nis.text = data.nis
        holder.nama.text = data.nama
        holder.kelamin.text = data.kelamin
        holder.btnHapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position,dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}