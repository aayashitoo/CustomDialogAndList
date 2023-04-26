package com.majid.customdialogandlist

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.majid.customdialogandlist.databinding.CustomDatanameBinding
import com.majid.customdialogandlist.databinding.FragmentCustomDlgBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomDlg.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomDlgFragment : Fragment() {
    lateinit var binding: FragmentCustomDlgBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomDlgBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.btnCustomDialog.setOnClickListener {
            var dialog = Dialog(requireActivity())
            val dialogBinding = CustomDatanameBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            // dialog.setCancelable(True)
            dialogBinding.btnSave.setOnClickListener {
                if (dialogBinding.etName.text.toString().isEmpty()) {
                    dialogBinding.etName.error = "Enter your Name"
                } else {
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CustomDlg.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = CustomDlgFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}
