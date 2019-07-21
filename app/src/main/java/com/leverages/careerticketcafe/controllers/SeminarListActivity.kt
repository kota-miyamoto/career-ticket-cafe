

package com.leverages.careerticketcafe.controllers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leverages.careerticketcafe.R
import kotlinx.android.synthetic.main.activity_seminar_list.*
import kotlinx.android.synthetic.main.seminar_list_item.*

class SeminarListActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar_list)

        val title = "this is a title"
        val description = "this is description"

        val seminarList = mutableListOf(title, description)

        seminarList.add(title)
        seminarList.add(description)

        seminarRecyclerView.adapter = RecyclerAdapter(this, this, seminarList)
        seminarRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }
}


class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val itemImageView: ImageView = view.findViewById(R.id.seminarImageView)
    val itemTitleTextView: TextView = view.findViewById(R.id.seminarTitleView)
    val itemDescriptionTextView: TextView = view.findViewById(R.id.seminarDescriptionView)
}


class RecyclerAdapter(private val context: Context, private val itemClickListener: RecyclerViewHolder.ItemClickListener, private val seminarList:List<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var mRecyclerView : RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.let {
            it.itemImageView.setImageResource(R.mipmap.ic_launcher)
            it.itemTitleTextView.text = seminarList[position]
            it.itemDescriptionTextView.text = seminarList[position]
        }
    }

    override fun getItemCount(): Int {
        return seminarList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.seminar_list_item, parent, false)

        mView.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewHolder(mView)
    }

}