package com.spacebitlabs.plantly.calendar

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.spacebitlabs.plantly.MainViewModel
import com.spacebitlabs.plantly.R
import com.spacebitlabs.plantly.models.Plant
import kotlinx.android.synthetic.main.fragment_calendar.*

/**
 * Shows a calendar of past and upcoming watering dates.
 *
 * Green for a completed job
 * Red for a missed job
 * Yellow for make-up job
 * Blue for an upcoming job
 */
class CalendarFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_calendar, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProviders.of(activity).get(MainViewModel::class.java)

        add.setOnClickListener {
            model.setPlants(Plant("test"))
        }
    }

    companion object {
        fun newInstance(): CalendarFragment {
            val args = Bundle().apply { /* put params */}
            val fragment = CalendarFragment()
            fragment.arguments = args
            return fragment
        }
    }
}