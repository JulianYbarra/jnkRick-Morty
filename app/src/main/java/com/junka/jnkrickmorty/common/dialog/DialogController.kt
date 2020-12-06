package com.junka.jnkrickmorty.common.dialog

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.junka.jnkrickmorty.common.dialog.base.BaseBottomSheetDialog
import javax.inject.Inject


class DialogController @Inject constructor(
    private val activity: FragmentActivity){

    private val supportFragmentManager: FragmentManager
        get() = activity.supportFragmentManager

    private fun showDialog(dialog: BaseBottomSheetDialog, checkIsPresent: Boolean = true) {
        supportFragmentManager.run {
            if (checkIsPresent) {
                if (isFragmentDialogVisible(dialog.getDialogTag()).not()) {
                    dialog.show(this, dialog.getDialogTag())
                }
            } else {
                dialog.show(this, dialog.getDialogTag())
            }
        }
    }

    private fun FragmentManager.isFragmentDialogVisible(tag: String): Boolean {
        return findFragmentByTag(tag) != null
    }
}