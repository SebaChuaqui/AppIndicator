package com.example.appindicator.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appindicator.R
import com.example.appindicator.Repository.IndicadorAdapter
import com.example.appindicator.Repository.IndicadorViewModel
import com.example.appindicator.Repository.PassTheData
import com.example.appindicator.local.IndicadorEntity
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(), PassTheData {

    private val model: IndicadorViewModel by activityViewModels()
    lateinit var mAdapter: IndicadorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = IndicadorAdapter(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = RecyclerViewIndicador
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        model.liveDataFromLocal.observe(viewLifecycleOwner, Observer {
            Log.d("view", it.toString())
            mAdapter.updateAdapter(it)
        })

    }

    override fun passTheIndicador(indicador: IndicadorEntity) {

        val mBundle = Bundle()
        mBundle.putString("id", indicador.id.toString())

        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)

    }
}



