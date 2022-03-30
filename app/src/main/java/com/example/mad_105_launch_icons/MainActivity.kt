package com.example.mad_105_launch_icons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

/*********************************************************************************
 * Program to convert between US Dollars and Japanese Yen
 * Using a conversion rate of $1 = 122.4 Yen
 * Author:  Al Jette
 * Date: 29-March-2022
 * Params, From the layout screen (all text):
 *   inputIdCurrText = idInputCurrency => the user input currency to convert
 *   RBDollarYen = idDollarInput => if the user selected to input Dollars to convert to Yen
 *   RBYen_Dollar = idYenInput => if the user selected to input Yen to convert to Dollars
 *   inputConvert = idConvert =>  user input button to do the conversion
 *   outputIDCurrText = idResults => output of the currency converter
 *
 * Params, used in the calculations (all double):
 *   inputAmount (double) <= inputIdCurrText
 *   outputResults (double) => outputIDCurrText
 *   convRate (double) = 122.4  (as of 29-Mar-2022)
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setters and Getters for Android Input
        val inputIdCurrText: EditText = findViewById(R.id.idInputCurrency)
        val rbDollarYen = findViewById<RadioButton>(R.id.idDollarInput)
        val rbYenDollar = findViewById<RadioButton>(R.id.idYenInput)
        val inputConvert:  Button = findViewById(R.id.idConvert)
        val outputIDCurrText: TextView = findViewById(R.id.idResults)

        // When the user clicks on the Convert Button
        inputConvert.setOnClickListener {
            val currency = DecimalFormat ("#,###,###.00")
            val convRate: Double = 122.4
            var inputAmount = inputIdCurrText.text.toString().toDouble()
            var outResults: Double = 0.0

            // If converting Dollars to Yen
            if (rbDollarYen.isChecked){
                if (inputAmount <= 10000.00) {
                    outResults = inputAmount * convRate
                    outputIDCurrText.text = currency.format(outResults) + " Yen"

                } else {
                    outputIDCurrText.text = "    "
                    Toast.makeText(this@MainActivity, "Maximum input is $10,000", Toast.LENGTH_LONG).show()
                }
            }
            // If converting Yen to Dollars
            if (rbYenDollar.isChecked) {
                if (inputAmount/convRate <= 10000.00) {
                    outResults = inputAmount / convRate
                    outputIDCurrText.text = currency.format(outResults) + " Dollars"
                } else {
                    outputIDCurrText.text = "    "
                    Toast.makeText(this@MainActivity, "Maximum input is 1,224,000 Yen", Toast.LENGTH_LONG).show()
                }

            }

        }
    }
}