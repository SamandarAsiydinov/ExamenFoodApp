package uz.context.examenappui.adapter

import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.examenappui.R
import uz.context.examenappui.model.Restaurants

class ResAdapter(
    private val resItem: ArrayList<Restaurants>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_ver_layout, parent, false)
        return ResViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = resItem[position]

        if (holder is ResViewHolder) {
            holder.apply {
                imageVie.setImageResource(item.image)
                title.text = item.title
                des.text = item.des
                rating.rating = item.rate
            }
        }
    }

    override fun getItemCount(): Int {
        return resItem.size
    }
    class ResViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageVie: ImageView = view.findViewById(R.id.imageViewVer)
        val title: TextView = view.findViewById(R.id.textTitleVer)
        val des: TextView = view.findViewById(R.id.textDesVer)
        val rating: RatingBar = view.findViewById(R.id.ratingBar)
    }
}