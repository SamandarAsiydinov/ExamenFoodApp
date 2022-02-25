package uz.context.examenappui.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.examenappui.R
import uz.context.examenappui.adapter.MessageAdapter
import uz.context.examenappui.model.Message

class MessageFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private val messageItem: ArrayList<Message> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewMessage)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        messageAdapter = MessageAdapter(messageItem())
        recyclerView.adapter = messageAdapter
    }

    private fun messageItem(): ArrayList<Message> {
        for (i in 0..30) {
            messageItem.add(Message(R.drawable.img_android, "Android", "Message", true))
        }
        return messageItem
    }
}