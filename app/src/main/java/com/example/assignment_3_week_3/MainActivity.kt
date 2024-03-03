package com.example.assignment_3_week_3

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_3_week_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        tableLayout = findViewById(R.id.resultTableLayout)

        val staticRow = TableRow(this)
        staticRow.layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT)

        val firstStaticTextView = TextView(this)
        firstStaticTextView.text = getString(R.string.water_resource_name)
        firstStaticTextView.gravity = Gravity.CENTER
        firstStaticTextView.setTypeface(null,Typeface.BOLD)
        firstStaticTextView.setBackgroundResource(R.drawable.cell_shape)
        firstStaticTextView.setPadding(20, 20, 20, 20)

        val secondStaticTextView = TextView(this)
        secondStaticTextView.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        secondStaticTextView.text = getString(R.string.location)
        secondStaticTextView.gravity = Gravity.CENTER
        secondStaticTextView.setTypeface(null,Typeface.BOLD)
        secondStaticTextView.setBackgroundResource(R.drawable.cell_shape)
        secondStaticTextView.setPadding(20, 20, 20, 20)

        val thirdStaticTextView = TextView(this)
        thirdStaticTextView.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        thirdStaticTextView.text = getString(R.string.type)
        thirdStaticTextView.gravity = Gravity.CENTER
        thirdStaticTextView.setTypeface(null,Typeface.BOLD)
        thirdStaticTextView.setBackgroundResource(R.drawable.cell_shape)
        thirdStaticTextView.setPadding(20, 20, 20, 20)

        staticRow.addView(firstStaticTextView)
        staticRow.addView(secondStaticTextView)
        staticRow.addView(thirdStaticTextView)

        tableLayout.addView(staticRow)

        mainBinding.addButton.setOnClickListener {
            val waterResource = mainBinding.waterResourceNameEditText.text.toString()
            val location = mainBinding.locationEditText.text.toString()
            val type = mainBinding.typeEditText.text.toString()

            if (waterResource.isEmpty()){
                Toast.makeText(this,
                    getString(R.string.water_resource_name_field_is_empty), Toast.LENGTH_SHORT).show()
            }else if (location.isEmpty()){
                Toast.makeText(this, getString(R.string.location_field_is_empty), Toast.LENGTH_SHORT).show()
            }else if (type.isEmpty()){
                Toast.makeText(this, getString(R.string.type_field_is_empty), Toast.LENGTH_SHORT).show()
            }else{
                addDynamicRow(waterResource, location, type)
            }
        }
    }

    private fun addDynamicRow(waterResource: String, location: String, type: String) {
        val rowData = TableRow(this)
        rowData.layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT)

        val firstTextView = TextView(this)
        firstTextView.text = waterResource
        firstTextView.gravity = Gravity.CENTER
        firstTextView.setBackgroundResource(R.drawable.cell_shape)
        firstTextView.setPadding(15, 15, 15, 15)

        val secondTextView = TextView(this)
        secondTextView.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        secondTextView.text = location
        secondTextView.gravity = Gravity.CENTER
        secondTextView.setBackgroundResource(R.drawable.cell_shape)
        secondTextView.setPadding(15, 15, 15, 15)

        val thirdTextView = TextView(this)
        thirdTextView.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)

        thirdTextView.text = type
        thirdTextView.gravity = Gravity.CENTER
        thirdTextView.setBackgroundResource(R.drawable.cell_shape)
        thirdTextView.setPadding(15, 15, 15, 15)

        rowData.addView(firstTextView)
        rowData.addView(secondTextView)
        rowData.addView(thirdTextView)

        tableLayout.addView(rowData)
    }
}
