package com.example.githubapifiltercourotines.extension

import android.app.Activity
import android.widget.Toast

fun Activity.toast(message: String?) {
    Toast.makeText(this, message ?: "Something wrong", Toast.LENGTH_SHORT).show()
}