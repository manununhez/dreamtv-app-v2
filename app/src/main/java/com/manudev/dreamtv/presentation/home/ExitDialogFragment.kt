package com.manudev.dreamtv.presentation.home

import android.app.Dialog
import android.os.Bundle
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.util.TypedValue.applyDimension
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.manudev.dreamtv.R

class ExitDialogFragment : DialogFragment() {
    private lateinit var viewRoot: Dialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //do nothing. We disable onBackPressed
        viewRoot = Dialog(requireContext(), R.style.DefaultDialogFragmentStyle)

        viewRoot.setContentView(R.layout.fragment_exit_dialog)

        val btnExit = viewRoot.findViewById<Button>(R.id.btnExit)
        val btnCancel = viewRoot.findViewById<Button>(R.id.btnCancel)


        btnExit.textSize = customTextSize(SMALL)
        btnCancel.textSize = customTextSize(SMALL)
        btnCancel.requestFocus()


        btnCancel.setOnClickListener { navToHome() }
        btnExit.setOnClickListener { exitApp() }

        btnExit.setOnFocusChangeListener { _, hasFocus ->
            btnExit.textSize = if (hasFocus) customTextSize(LARGE) else customTextSize(SMALL)
        }

        btnCancel.setOnFocusChangeListener { _, hasFocus ->
            btnCancel.textSize = if (hasFocus) customTextSize(LARGE) else customTextSize(SMALL)
        }


        return viewRoot
    }

    private fun navToHome() {
        findNavController().popBackStack()
    }

    private fun exitApp() {
        requireActivity().finish()
    }

    private fun customTextSize(type: String): Float {
        return when (type) {
            SMALL -> applyDimension(COMPLEX_UNIT_SP, 9f, resources.displayMetrics)
            else -> applyDimension(COMPLEX_UNIT_SP, 10f, resources.displayMetrics)
        }
    }

    override fun onResume() {
        dialog?.window?.setLayout(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        super.onResume()
    }

    companion object {
        private const val SMALL: String = "Small"
        private const val LARGE: String = "Large"
    }
}