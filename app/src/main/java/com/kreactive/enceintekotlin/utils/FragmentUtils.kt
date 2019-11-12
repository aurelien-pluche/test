package com.kreactive.enceintekotlin.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kreactive.enceintekotlin.R

fun replaceFragment(
    fragmentManager: FragmentManager, @IdRes container: Int,
    tag: String,
    fragmentCreator: () -> Fragment,
    transitionSharedElementsList: List<Pair<View, String>> = emptyList(),
    forceNewFragment: Boolean = false
) {
    if (fragmentManager.isStateSaved) {
        return
    }

    val fragment: Fragment = fragmentCreator()
    val stackCount = fragmentManager.backStackEntryCount
    for (i in 1..stackCount) {
        fragmentManager.popBackStackImmediate()
    }

    fragmentManager
        .beginTransaction()
        .setCustomAnimations(R.anim.fade_in_fragment, R.anim.fade_out_fragment)
        .apply {
            transitionSharedElementsList.forEach {
                addSharedElement(it.first, it.second)
            }
        }
        .replace(container, fragment, tag)
        .setPrimaryNavigationFragment(fragment)
        .commitNow()
}