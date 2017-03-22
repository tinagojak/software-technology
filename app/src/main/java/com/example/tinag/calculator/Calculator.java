package com.example.tinag.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.tinag.calculator.Calculator.State.ADD;
import static com.example.tinag.calculator.Calculator.State.DIV;
import static com.example.tinag.calculator.Calculator.State.MUL;
import static com.example.tinag.calculator.Calculator.State.SUB;

public class Calculator extends Activity implements View.OnClickListener{

    ArrayList<Button> numberButtons = new ArrayList<>();
    TextView numberView;

    public enum State {
        ADD, SUB, MUL, DIV, INIT
    }

    State state = State.INIT;
    int firstNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);

        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);

        Button buttonTimes = (Button) findViewById(R.id.buttonTimes);
        buttonTimes.setOnClickListener(this);

        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);

        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(this);

        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(this);

        setUpNumberButtonListener();

        numberView = (TextView) findViewById(R.id.textView);


    }

    public void setUpNumberButtonListener(){

        for (int i=0; i<=9; i++){
            String buttonName = "button" + i;

            int id = getResources().getIdentifier(buttonName, "id", R.class.getPackage().getName());

            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            numberButtons.add(button);
        }
    }

    private void clearNumberView() {
        String tempString = numberView.getText().toString();
        if(!tempString.equals("")){
            firstNumber = Integer.valueOf(tempString);
        }
        numberView.setText("");
    }

    private void clearTextView() {
        numberView.setText("0");
        firstNumber = 0;
        state = State.INIT;
    }

    private void calculateResult() {
        int secondNumber = 0;
        String tempString = numberView.getText().toString();
        if(!tempString.equals("")){
            secondNumber = Integer.valueOf(tempString);
        }
        int result;
        switch(state){
            case ADD:
                result = Calculations.doAddition(firstNumber, secondNumber);
                break;
            case SUB:
                result = Calculations.doSubtraction(firstNumber, secondNumber);
                break;
            case MUL:
                result = Calculations.doMultiplication(firstNumber, secondNumber);
                break;
            case DIV:
                result = Calculations.doDivision(firstNumber, secondNumber);
                break;
            default:
                result = secondNumber;
        }
        numberView.setText(Integer.toString(result));
    }


    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;


        switch (clickedButton.getId()) {
            case R.id.buttonPlus:
                clearNumberView();
                state = ADD;
                break;
            case R.id.buttonMinus:
                clearNumberView();
                state = SUB;
                break;
            case R.id.buttonTimes:
                clearNumberView();
                state = MUL;
                break;
            case R.id.buttonDivide:
                clearNumberView();
                state = DIV;
                break;
            case R.id.buttonEqual:
                calculateResult();
                state = State.INIT;
                break;
            case R.id.buttonC:
                clearTextView();
                break;
            default:
                String recentNumber = numberView.getText().toString();
                if (recentNumber.equals("0")) {
                    recentNumber = "";
                }
                recentNumber +=  clickedButton.getText().toString();
                numberView.setText(recentNumber);

        }

    }
}

