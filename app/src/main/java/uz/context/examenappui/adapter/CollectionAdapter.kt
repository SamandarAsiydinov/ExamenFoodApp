package uz.context.examenappui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.examenappui.R
import uz.context.examenappui.model.Categories
import uz.context.examenappui.model.Collections

class CollectionAdapter(
    private val categories: ArrayList<Collections>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categorie_layout, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = categories[position]

        if (holder is CategoriesViewHolder) {
            holder.apply {
                textView.text = item.title
                imageView.setImageResource(item.image)
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewCat)
        val textView: TextView = view.findViewById(R.id.textCat)
    }
}