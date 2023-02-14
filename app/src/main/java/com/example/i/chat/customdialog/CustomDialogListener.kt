package com.example.i.chat.customdialog

import androidx.fragment.app.DialogFragment

interface CustomDialogListener {
    fun onDialogPositiveClick(dialog: DialogFragment)
    fun onDialogNegativeClick(dialog: DialogFragment)
}