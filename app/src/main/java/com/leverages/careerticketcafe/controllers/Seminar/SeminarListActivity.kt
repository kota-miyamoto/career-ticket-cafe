package com.leverages.careerticketcafe.controllers.Seminar

import com.leverages.careerticketcafe.controllers.Seminar.SeminarFragment
import com.leverages.careerticketcafe.controllers.Seminar.SingleFragmentActivity

class SeminarListActivity : SingleFragmentActivity() {
    override fun createFragment() = SeminarFragment.newInstance()
}
