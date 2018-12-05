package edu.csumb.sverrebroen.calculator

import android.media.VolumeShaper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    enum class Operation{
        EQUALS, ADD, SUBTRACT, MULTIPLY, DIVIDE, NONE
    }

    var runningNumber:String = ""
    var leftValue:String = ""
    var rightValue:String = ""
    var calculation: Int = 0

    var currentOperation = Operation.NONE



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        oneBtn.setOnClickListener {
            numberPressed(1)
        }

        twoBtn.setOnClickListener {
            numberPressed(2)
        }

        threeBtn.setOnClickListener {
            numberPressed(3)
        }

        fourBtn.setOnClickListener {
            numberPressed(4)
        }

        fiveBtn.setOnClickListener {
            numberPressed(5)
        }

        sixBtn.setOnClickListener {
            numberPressed(6)
        }

        sevenBtn.setOnClickListener {
            numberPressed(7)
        }

        eightBtn.setOnClickListener {
            numberPressed(8)
        }

        nineBtn.setOnClickListener {
            numberPressed(9)
        }

        zeroBtn.setOnClickListener {
            numberPressed(0)
        }

        clearBtn.setOnClickListener {
            runningNumber = ""
            leftValue = ""
            rightValue = ""
            calculation = 0
            currentOperation = Operation.NONE
            textResult.text = ""
        }

        equalBtn.setOnClickListener {
            processOperations(Operation.EQUALS)
        }

        addBtn.setOnClickListener {
            processOperations(Operation.ADD)
        }

        subtractBtn.setOnClickListener {
            processOperations(Operation.SUBTRACT)
        }

        multiplyBtn.setOnClickListener {
            processOperations(Operation.MULTIPLY)
        }

        divideBtn.setOnClickListener {
            processOperations(Operation.DIVIDE)
        }



    }

    fun processOperations(operation : Operation) {
        if(currentOperation != Operation.NONE) {
            if (runningNumber != "") {
                rightValue = runningNumber
                runningNumber = ""
                when (currentOperation) {
                    Operation.ADD -> {
                        calculation = leftValue.toInt() + rightValue.toInt()
                    }

                    Operation.SUBTRACT -> {
                        calculation = leftValue.toInt() - rightValue.toInt()
                    }

                    Operation.MULTIPLY -> {
                        calculation = leftValue.toInt() * rightValue.toInt()
                    }

                    Operation.DIVIDE -> {
                        calculation = leftValue.toInt() / rightValue.toInt()
                    }
                }

                leftValue = calculation.toString()
                textResult.text = leftValue
            }
        }
        else{
            leftValue = runningNumber
            runningNumber = ""
        }
        currentOperation = operation
    }

    fun numberPressed(number: Int){
        runningNumber += number.toString()
        textResult.text = runningNumber
    }
}
