package com.prakash.softwaricaclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.prakash.softwaricaclone.MainActivity
import com.prakash.softwaricaclone.R
import com.prakash.softwaricaclone.model.Student

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddStudentFragment : Fragment() {
    private lateinit var etFullName: EditText
    var lstStudent = ArrayList<student>()
    private lateinit var rdoGroup: RadioGroup
    private lateinit var etAge: EditText
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var etImageLink: EditText
    var gender = ""
    private lateinit var btnSend: Button
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            AddStudentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etFullName = view.findViewById(R.id.etFullName)
        etAge = view.findViewById(R.id.etAge)
        rdoGroup = view.findViewById(R.id.rdoGroup)
        rdoMale = view.findViewById(R.id.rdoMale)
        rdoFemale = view.findViewById(R.id.rdoFemale)
        rdoOthers = view.findViewById(R.id.rdoOther)
        etAddress = view.findViewById(R.id.etAddress)
        etImageLink = view.findViewById(R.id.etImageLink)
        btnSend = view.findViewById(R.id.btnSave)
        genderSelected()

        btnSend.setOnClickListener {
            if (isValid()) {
                Student.lstStudent.add(
                    MainActivity.student(
                        studentName = etFullName.text.toString(),
                        studentAge = etAge.text.toString(),
                        studentGender = gender,
                        studentAddress = etAddress.text.toString(),
                        imageLink = etImageLink.text.toString()
                    )
                )
                clear()
            }
        }
    }

    private fun clear() {
        etFullName.setText("")
        etAge.setText("")
        etAddress.setText("")
        rdoMale.isChecked = false
        rdoFemale.isChecked = false
        rdoOthers.isChecked = false
        //  etImageLink.setText("")
    }

    private fun genderSelected() {
        rdoGroup.setOnCheckedChangeListener { _, checkedID ->
            when (checkedID) {
                R.id.rdoMale -> {
                    gender = rdoMale.text.toString()
                }

                R.id.rdoFemale -> {
                    gender = rdoFemale.text.toString()
                }

                R.id.rdoMale -> {
                    gender = rdoFemale.text.toString()
                }
            }
        }
    }


    private fun isValid(): Boolean {
        when {
            etFullName.text.isEmpty() -> {
                etFullName.error = "Name cannot be Empty"
                etFullName.requestFocus()
                return false
            }
            etAge.text.isEmpty() -> {
                etAge.error = "Age cannot be Empty"
                etAge.requestFocus()
                return false
            }
            !rdoMale.isChecked && !rdoFemale.isChecked && !rdoOthers.isChecked -> {
                Toast.makeText(context, "Please Select a Gender", Toast.LENGTH_SHORT).show()
                rdoGroup.requestFocus()
                return false
            }
            etAddress.text.isEmpty() -> {
                etAddress.error = "Address cannot be Empty"
                etAddress.requestFocus()
                return false
            }
            etImageLink.text.isEmpty() -> {
                etImageLink.error = "Link cannot be Empty"
                etImageLink.requestFocus()
                return false
            }
        }
        return true
    }
}