package com.example.theresume

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class NewSkillDialogFragment : DialogFragment() {
    interface NewSkillDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment, skill: String)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    var newSkillDialogListener: NewSkillDialogListener? = null

    companion object {
        fun newInstance(title: Int): NewSkillDialogFragment {
            val newSkillDialogFragment = NewSkillDialogFragment()
            val args = Bundle()
            args.putInt("dialog_title", title)
            newSkillDialogFragment.arguments = args
            return newSkillDialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments?.getInt("dialog_title")
        val builder = AlertDialog.Builder(activity)
        if (title != null) {
            builder.setTitle(title)
        }

        val dialogView = activity?.layoutInflater?.inflate(R.layout.dialog_new_task, null)
        val skill = dialogView?.findViewById<EditText>(R.id.skill)

        builder.setView(dialogView)
            .setPositiveButton(
                R.string.save,
             { dialog, id ->
                if (skill != null) {
                    newSkillDialogListener?.onDialogPositiveClick(
                        this,
                        skill.text.toString()
                    )
                };
            })
            .setNegativeButton(
                android.R.string.cancel
            , { dialog, id -> newSkillDialogListener?.onDialogNegativeClick(this) })
        return builder.create()
    }

    override fun onAttach(activity: Activity) { // 6
        super.onAttach(activity)
        try {
            newSkillDialogListener = activity as NewSkillDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement NewSkillDialogListener")
        }
    }
}