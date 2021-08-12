package com.kras.bigwhale

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val birthDateButton = findViewById<Button>(R.id.enterBirthDate)
        birthDateButton.setOnClickListener { view ->
            setDatePicker(view)

        }

    }

    fun setDatePicker(view: View) {
        val calendarObj = Calendar.getInstance()
        val year = calendarObj.get(Calendar.YEAR)
        val month = calendarObj.get(Calendar.MONTH)
        val dayOfMonth = calendarObj.get(Calendar.DAY_OF_MONTH)



       val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, bdYear, bdMonth, bdDay ->
                val showDateOfBirth = findViewById<TextView>(R.id.showDateOfBirth)
                val bdInfo = "$bdDay/${bdMonth + 1}/$bdYear"

                showDateOfBirth.setText(bdInfo)
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                    val theDate = sdf.parse(bdInfo)
                val selectedDateInM = theDate.time!! / 60000
                val curentDate = sdf.parse(sdf.format(System.currentTimeMillis()))!! . time / 60000
                val resultPlace = findViewById<TextView>(R.id.resultView)
                resultPlace.setText((curentDate - selectedDateInM).toString())



            },
            year,
            month,
            dayOfMonth
        )

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }
}