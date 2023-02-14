package com.example.i.chat.customdialog

import androidx.fragment.app.DialogFragment

interface DialogListener {
    fun alarmButtonClickListener(dialog: DialogFragment)
    fun banButtonClickListener(dialog: DialogFragment)
    fun endButtonClickListener(dialog: DialogFragment)
}