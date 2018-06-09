package mustafa.ahmad.com.androidarchitecturecomponents.Activities.Adapters

import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item
import mustafa.ahmad.com.androidarchitecturecomponents.R


class RecyclerViewAdapter(list: List<Item>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    // TAG for Logging
    private val TAG = this.javaClass.name
    private var itemList: List<Item> = list

    // constructor

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = itemList[position].title
        holder.body.text = itemList[position].body
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.title)
        val body: TextView = itemView.findViewById(R.id.body)

    }
}