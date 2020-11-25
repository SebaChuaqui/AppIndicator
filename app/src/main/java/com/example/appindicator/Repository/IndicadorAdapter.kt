package com.example.appindicator.Repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appindicator.R
import com.example.appindicator.local.IndicadorEntity
import kotlinx.android.synthetic.main.indicador.view.*

class IndicadorAdapter(val mPassTheData: PassTheData): RecyclerView.Adapter<IndicadorAdapter.IndicadorViewHolder>() {

    private var indicadorList = emptyList<IndicadorEntity>()

    fun updateAdapter(mList: List<IndicadorEntity>){
        indicadorList= mList
        notifyDataSetChanged()
    }

    inner class IndicadorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name = itemView.idNombre
        val name2 = itemView.idNombre2
        val name3 = itemView.idNombre3
        val name4 = itemView.idNombre4
        val name5 = itemView.idNombre5
        val name6 = itemView.idNombre6
        val name7 = itemView.idNombre7
        val name8 = itemView.idNombre8
        val name9 = itemView.idNombre9
        val name10 = itemView.idNombre10
        val name11 = itemView.idNombre11
        val name12 = itemView.idNombre12
        val clickListener = itemView.setOnClickListener{
            mPassTheData.passTheIndicador((indicadorList[adapterPosition]))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicadorViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.indicador,parent,false)
        return IndicadorViewHolder(view)
    }

    override fun onBindViewHolder(holder: IndicadorViewHolder, position: Int) {
        val indicador= indicadorList[position]
        holder.name.text = indicador.id.toString()
        holder.name.text = indicador.bitcoin
        holder.name2.text = indicador.dolar
        holder.name3.text = indicador.dolarIntercambio
        holder.name4.text = indicador.euro
        holder.name5.text = indicador.imacec
        holder.name6.text = indicador.ipc
        holder.name7.text = indicador.ivp
        holder.name8.text = indicador.libraCobre
        holder.name9.text = indicador.tasaDesempleo
        holder.name10.text = indicador.tpm
        holder.name11.text = indicador.uf
        holder.name12.text = indicador.utm

    }

    override fun getItemCount()=indicadorList.size
}
interface PassTheData {
    fun passTheIndicador(indicador: IndicadorEntity)
}