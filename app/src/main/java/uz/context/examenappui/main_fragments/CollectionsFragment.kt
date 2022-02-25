package uz.context.examenappui.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.examenappui.R
import uz.context.examenappui.adapter.CollectionAdapter
import uz.context.examenappui.model.Collections

class CollectionsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val items: ArrayList<Collections> = ArrayList()
    private lateinit var collectionAdapter: CollectionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_collections, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        collectionAdapter = CollectionAdapter(items())
        recyclerView.adapter = collectionAdapter
    }

    private fun items(): ArrayList<Collections> {
        for (i in 0..30) {
            items.add(Collections(R.drawable.img_android, "Android"))
        }
        return items
    }
}