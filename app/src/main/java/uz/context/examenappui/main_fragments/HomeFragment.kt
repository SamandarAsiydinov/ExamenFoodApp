package uz.context.examenappui.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.examenappui.R
import uz.context.examenappui.adapter.CategoriesAdapter
import uz.context.examenappui.adapter.ResAdapter
import uz.context.examenappui.model.Categories
import uz.context.examenappui.model.Restaurants

class HomeFragment : Fragment() {

    private lateinit var recyclerHor: RecyclerView
    private lateinit var recyclerVer: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var resAdapter: ResAdapter
    private val catItem: ArrayList<Categories> = ArrayList()
    private val resItem: ArrayList<Restaurants> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerHor = view.findViewById(R.id.recyclerViewHomeHor)
        recyclerVer = view.findViewById(R.id.recyclerViewHome)
        recyclerVer.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerHor.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoriesAdapter = CategoriesAdapter(catItem())
        recyclerHor.adapter = categoriesAdapter
        resAdapter = ResAdapter(resItem())
        recyclerVer.adapter = resAdapter
    }

    private fun catItem(): ArrayList<Categories> {
        for (i in 0..20) {
            catItem.add(
                Categories(
                    R.drawable.img_android,
                    "Android"
                )
            )
        }
        return catItem
    }

    private fun resItem(): ArrayList<Restaurants> {
        for (i in 0..30) {
            resItem.add(Restaurants(R.drawable.img_android, "Android", "Programming", 5f))
        }
        return resItem
    }
}