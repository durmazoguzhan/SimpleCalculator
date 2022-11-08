package com.oguzhandurmaz.kotlinsimplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var firstNumber:Int=0
    private var secondNumber:Int=0
    lateinit var resultCalc:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun isNumbersNull():Boolean{
        return if(firstNumberText.text.toString()!=""&&secondNumberText.text.toString()!=""){
            true
        } else{
            resultText.text="Please enter the numbers."
            false
        }
    }

    private fun getNumbers(){
            firstNumber=firstNumberText.text.toString().toInt()
            secondNumber=secondNumberText.text.toString().toInt()
    }

    fun sum(view:View){
        if(isNumbersNull()){
            getNumbers()
            resultCalc=(firstNumber+secondNumber).toString()
            resultText.text="Result : $resultCalc"
        }
    }

    fun minus(view:View){
        if(isNumbersNull()){
            getNumbers()
            resultCalc=(firstNumber-secondNumber).toString()
            resultText.text="Result : $resultCalc"
        }
    }

    fun multiply(view: View){
        if(isNumbersNull()){
            getNumbers()
            resultCalc=(firstNumber*secondNumber).toString()
            resultText.text="Result : $resultCalc"
        }
    }

    fun divide(view: View){
        if(isNumbersNull()){
            if (!isSecondNumberZero()){
                getNumbers()
                val resultCalc=(firstNumber/secondNumber).toString()
                resultText.text="Result : $resultCalc"
            }
            else{
                resultText.text="Can't divide to zero."
            }
        }
    }

    private fun isSecondNumberZero():Boolean{
        return secondNumberText.text.toString()=="0"
    }
}