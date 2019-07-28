package com.leverages.careerticketcafe.controllers.Seminar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leverages.careerticketcafe.R

class SeminarListAdapter(private val list: List<Seminar>)
    : RecyclerView.Adapter<SeminarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeminarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SeminarViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SeminarViewHolder, position: Int) {
        val seminar: Seminar = list[position]
        holder.bind(seminar)
    }

    override fun getItemCount(): Int = list.size

}

// xmlで作ったviewパーツたちにSeminar fragmentからとったデータを入れる
class SeminarViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.seminar_list_item, parent, false)) {
    private var mTopCompanyNameView: TextView? = null
    private var mTitleView: TextView? = null
    private var mDateView: TextView? = null
    private var mCapacityView: TextView? = null
    private var mBottomCompanyName: TextView? = null

    init {
        mTopCompanyNameView = itemView.findViewById(R.id.seminarTopCompanyNameTextView)
        mTitleView = itemView.findViewById(R.id.seminarTitleTextView)
        mDateView = itemView.findViewById(R.id.seminarDateTextView)
        mCapacityView = itemView.findViewById(R.id.seminarCapacityTextView)
        mBottomCompanyName = itemView.findViewById(R.id.seminarBottomCompanyNameTextView)
    }

    fun bind(seminar: Seminar) {
        mTopCompanyNameView?.text = seminar.topCompanyName
        mTitleView?.text = seminar.title
        mDateView?.text = seminar.date
        mCapacityView?.text = seminar.capacity
        mBottomCompanyName?.text = seminar.bottomCompanyName
    }
}
