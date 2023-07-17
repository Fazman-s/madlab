package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bsub,bmul,bdiv,bdot, bclear, bequals;
    TextView input;
    String op1="", op2="";
    String operator="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);

        badd=findViewById(R.id.badd);
        bsub=findViewById(R.id.bsub);
        bmul=findViewById(R.id.bmul);
        bdiv=findViewById(R.id.bdiv);
        bdot=findViewById(R.id.bdot);
        bclear=findViewById(R.id.clear);
        bequals=findViewById(R.id.beq);

        input=findViewById(R.id.tv);

        b0.setOnClickListener(this::setValue);
        b1.setOnClickListener(this::setValue);
        b2.setOnClickListener(this::setValue);
        b3.setOnClickListener(this::setValue);
        b4.setOnClickListener(this::setValue);
        b5.setOnClickListener(this::setValue);
        b6.setOnClickListener(this::setValue);
        b7.setOnClickListener(this::setValue);
        b8.setOnClickListener(this::setValue);
        b9.setOnClickListener(this::setValue);
        bdot.setOnClickListener(this::setValue);

        badd.setOnClickListener(this::setOperator);
        bsub.setOnClickListener(this::setOperator);
        bmul.setOnClickListener(this::setOperator);
        bdiv.setOnClickListener(this::setOperator);

        bclear.setOnClickListener(this::clear);
        bequals.setOnClickListener(this::evaluate);

    }

    private void setValue(View v){
        CharSequence text=((Button)v).getText();
        if(operator.equals("")){
            op1+=text;
        }else {
            op2 += text;
        }
        input.setText(input.getText()+""+text);
    }

     private void setOperator(View v){
         CharSequence text = ((Button) v).getText();
         op1 = input.getText().toString();
         operator = text.toString();
         CharSequence t = ((Button)v).getText();
         input.setText(input.getText()+""+t);
     }

     private void clear(View v){
        operator="";
        op1="";
        op2="";
        input.setText("");
     }

     private void evaluate(View v){
        if(operator.equals(""))
            return;
        double result=0;
        boolean flag=true;

        switch(operator){
            case "+":
                result=(Double.parseDouble(op1)+Double.parseDouble(op2));
                break;
            case "-":
                result=(Double.parseDouble(op1)-Double.parseDouble(op2));
                break;
            case "*":
                result=(Double.parseDouble(op1)*Double.parseDouble(op2));
                break;
            case "/":
                if(Double.parseDouble(op2)==0.0)
                    flag=false;
                else{
                    result=(Double.parseDouble(op1)/Double.parseDouble(op2));
                }
                break;
        }
         op1=((result%1!=0))? String.valueOf(result):
                String.valueOf(((int)result));
                input.setText(op1);
                operator = "";
                op2="";
                if(flag==false)
                    input.setText("Error.Divide by zero!!");

    }


}

