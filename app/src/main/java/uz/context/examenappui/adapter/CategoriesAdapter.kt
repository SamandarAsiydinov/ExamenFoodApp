package uz.context.examenappui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.context.examenappui.R
import uz.context.examenappui.model.Categories

class CategoriesAdapter(
    private val categories: ArrayList<Categories>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_hor_layout, parent, false)
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
        val imageView: ImageView = view.findViewById(R.id.imageViewHor)
        val textView: TextView = view.findViewById(R.id.textTitleHor)
    }
}