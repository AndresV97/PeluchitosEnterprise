package com.example.peluchitosenterprise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PeluchitosAdapter : RecyclerView.Adapter<PeluchitosAdapter.PeluchitosViewHolder>{

    private var listaPeluchitos:List<Peluchitos>?=null
    private var context: Context?=null

    constructor(listPeluchitos:List<Peluchitos>,context: Context){
        this.listaPeluchitos = listPeluchitos
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeluchitosViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.peluchitos_item,parent,false)
        return PeluchitosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaPeluchitos?.size!!
    }

    override fun onBindViewHolder(holder: PeluchitosViewHolder, position: Int) {
        var peluchitos = listaPeluchitos!![position]
        holder.loadItem(peluchitos)
    }



    class PeluchitosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var peluchitos:Peluchitos?= null


        fun loadItem(peluchito: Peluchitos){
          /*  itemView.tvID.text = peluchito.id
            itemView.tvNombre.text = peluchito.nombre
            itemView.tvCantidad.text = peluchito.cantidad
            itemView.tvPrecio.text = peluchito.precio*/
        }

    }
}