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
        holder.name.text = indicador.nombre
    }

    override fun getItemCount()=indicadorList.size
}
interface PassTheData {
    fun passTheIndicador(superHeroes: IndicadorEntity)
}