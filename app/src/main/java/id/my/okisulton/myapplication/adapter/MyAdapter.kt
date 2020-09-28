package id.my.okisulton.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.my.okisulton.myapplication.R
import id.my.okisulton.myapplication.model.Post
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var myList = emptyList<Post>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.itemView.userId_tv.text = myList[position].userId.toString()
       holder.itemView.id_tv.text = myList[position].id.toString()
       holder.itemView.title_tv.text = myList[position].title
       holder.itemView.body_tv.text = myList[position].body
    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }

}
