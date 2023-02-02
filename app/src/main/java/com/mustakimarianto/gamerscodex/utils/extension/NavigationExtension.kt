package com.mustakimarianto.gamerscodex.utils.extension

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun NavDirections.navigateToDirection(view: View) {
    Navigation.findNavController(view).navigate(this)
}