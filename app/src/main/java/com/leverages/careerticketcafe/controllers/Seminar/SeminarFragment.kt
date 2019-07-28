package com.leverages.careerticketcafe.controllers.Seminar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.leverages.careerticketcafe.R
import kotlinx.android.synthetic.main.fragment_main.*

data class Seminar(val topCompanyName: String, val title: String, val image: String, val date: String, val capacity: String, val bottomCompanyName: String)

class SeminarFragment : Fragment() {

    private val seminarList = listOf(
        Seminar(
            "レバレジーズ株式会社",
            "早稲田にカフェがオープンしました！",
            "raising_arizona.jpg",
            "2019/08/01",
            "定員3人",
            "レバレジーズ株式会社"
        ),
        Seminar(
            "レバレジーズ株式会社",
            "東大にもカフェがオープンしました！",
            "vampires_kiss.png",
            "2019/08/01",
            "定員3人",
            "レバレジーズ株式会社"
        ),
        Seminar(
            "レバレジーズ株式会社",
            "阪大にもカフェがオープンしました！",
            "con_air.jpg",
            "2019/08/01",
            "定員3人",
            "レバレジーズ株式会社"
        ),
        Seminar(
            "レバレジーズ株式会社",
            "慶応にもカフェがオープンしました！",
            "face_off.jpg",
            "2019/08/01",
            "定員3人",
            "レバレジーズ株式会社"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = SeminarListAdapter(seminarList)
        }
    }

    companion object {
        fun newInstance(): SeminarFragment =
            SeminarFragment()
    }
}


// FragmentManagerは1つのActivity内にあるすべてのFragmentのライフサイクルを処理するので、
// 1つづつfragmentをコミットする
abstract class SingleFragmentActivity : AppCompatActivity() {

    private val layoutResId: Int
        @LayoutRes
        get() = R.layout.activity_fragment

    protected abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResId)

        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)

        // すでに作られているfragmentは入れない
        if (fragment == null) {
            fragment = createFragment()
            // fragmentを作って、コミット
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}