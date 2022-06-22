package com.example.progetto.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progetto.DetailedActivity
import com.example.progetto.model.Pc
import com.example.progetto.R
import com.example.progetto.adapters.PcAdapter

class FirstFragment: Fragment(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var pcList: ArrayList<Pc>
    private lateinit var pcAdapter: PcAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        //1.event
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        //2.event
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //3.event
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        pcList = ArrayList()

        pcList.add(Pc(R.drawable.xbox, "game1"))
        pcList.add(Pc(R.drawable.joker, "game2"))
        pcList.add(Pc(R.drawable.xbox, "game1"))
        pcList.add(Pc(R.drawable.joker, "game2"))
        pcList.add(Pc(R.drawable.xbox, "game1"))
        pcList.add(Pc(R.drawable.joker, "game2"))
        pcList.add(Pc(R.drawable.xbox, "game1"))
        pcList.add(Pc(R.drawable.joker, "game2"))
        pcList.add(Pc(R.drawable.xbox, "game1"))
        pcList.add(Pc(R.drawable.joker, "game2"))
        pcList.add(Pc(R.drawable.xbox, "game1"))
        pcList.add(Pc(R.drawable.joker, "game2"))
        pcList.add(Pc(R.drawable.xbox, "game1"))
        pcList.add(Pc(R.drawable.joker, "game2"))


        pcAdapter = PcAdapter(pcList)
        recyclerView.adapter = pcAdapter

        pcAdapter.onItemClick = {
            val intent = Intent(this.context, DetailedActivity::class.java)
            intent.putExtra("pc", it)
            startActivity(intent)
        }

    }
}