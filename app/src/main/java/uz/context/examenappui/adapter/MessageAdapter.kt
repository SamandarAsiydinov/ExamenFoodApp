package uz.context.examenappui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.examenappui.R
import uz.context.examenappui.model.Message

class MessageAdapter(private val userList: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.message_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[position]

        if (holder is UserViewHolder) {
            holder.apply {
                title.text = user.name
                des.text = user.message
                imageView.setImageResource(user.image)
                if (user.isOnline) {
                    isOnlineView.setBackgroundResource(R.drawable.view_shape)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewMess)
        val title: TextView = view.findViewById(R.id.textTitleMessage)
        val des: TextView = view.findViewById(R.id.textMessage)
        val isOnlineView: View = view.findViewById(R.id.isOnlineView)
    }
}