package com.example.theresume

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import kotlin.concurrent.fixedRateTimer

class Skills_1 : AppCompatActivity(), NewSkillDialogFragment.NewSkillDialogListener {

    private var skillItems = ArrayList<String>()
    private var listView: ListView? = null
    private var listAdapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills_1)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
             */
            showNewTaskUI()
        }
        listView = findViewById(R.id.list_view)
        populateListView()
    }

    private fun populateListView() {
        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skillItems)
        listView?.adapter = listAdapter
    }

    override fun onDialogPositiveClick(dialog: DialogFragment, skill: String) {
        skillItems.add(skill)
        listAdapter?.notifyDataSetChanged()
        Snackbar.make(findViewById<FloatingActionButton>(R.id.fab),
            "Skill added successfully",
            Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show()

    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        TODO("Not yet implemented")
    }

    fun showNewTaskUI(){
        val newFragment = NewSkillDialogFragment.newInstance(R.string.add_new_skill_dialog_title)
        newFragment.show(supportFragmentManager, "newskill")
    }
}