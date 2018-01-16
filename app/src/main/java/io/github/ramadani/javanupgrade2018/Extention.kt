package io.github.ramadani.javanupgrade2018

import android.content.Context
import android.widget.Toast

/**
 * Created by dani on 1/16/18.
 */

fun Context.toast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}