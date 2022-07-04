package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button AC, Power, Back, Div, Mul, Plus, Min, One, Two, Three, Four, Five, Six, Seven, Eight,
                    Nine, Zero, Ans, Point, Equal;
    private String input, Answer;
    private boolean clearResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        Mul = findViewById(R.id.mul);
        Plus = findViewById(R.id.plus);
        Min = findViewById(R.id.min);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Zero = findViewById(R.id.zero);
        Ans = findViewById(R.id.ans);
        Point = findViewById(R.id.point);
        Equal = findViewById(R.id.equal);
    }

    public void ButtonClick(View view){
        Button button= (Button) view;
        String data=button.getText().toString();
        switch (data){
            case "AC":
                try {
                    input = "";
                }
                catch (Exception e){
                    //Display error
                }
                break;
            case "Ans":
                if(input==""){
                    try {
                        clearResult = false;
                        input += Answer;
                    }
                    catch (Exception e){
                        //Display error
                    }
                }
                break;
            case "x":
                try {
                    clearResult = false;
                    Solve();
                    input += "*";
                }
                catch (Exception e){
                    //Display error
                }
                break;
            case "^":
                try {
                    clearResult = false;
                    Solve();
                    input += "^";
                }
                catch (Exception e){
                    //Display error
                }
                break;
            case "=":
                try {
                    clearResult = true;
                    Solve();
                    Answer = input;
                }
                catch (Exception e){
                    //Display error
                }
                break;
            case "del":
                try {
                    if (input.length() > 0) {
                        clearResult = false;
                        String newText = input.substring(0, input.length() - 1);
                        input = newText;
                    }
                }
                catch (Exception e){
                    //Display error
                }
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    clearResult=false;
                    Solve();
                }
                else if(clearResult==true){
                    input="";
                    clearResult=false;
                }
                input+=data;
        }
        Screen.setText(input);
    }
    public void Solve(){
        if(input.split("\\*").length==2){
            String numbers[]=input.split("\\*");
            try{
                double mul=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                input=mul+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        else if(input.split("/").length==2){
            String numbers[]=input.split("/");
            try{
                double div=Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                input=div+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        else if(input.split("\\^").length==2){
            String numbers[]=input.split("\\^");
            try{
                double pow=Math.pow(Double.parseDouble(numbers[0]),Double.parseDouble(numbers[1]));
                input=pow+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        else if(input.split("\\+").length==2){
            String numbers[]=input.split("\\+");
            try{
                double sum=Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                input=sum+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        else if(input.split("\\-").length>1){
            String numbers[]=input.split("\\-");
            if(numbers[0]=="" && numbers.length==2){
                numbers[0]=0+"";
            }
            try{
                double sub=0;
                if(numbers.length==2) {
                    sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                }
                else if(numbers.length==3){
                    sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
                }
                input=sub+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        Screen.setText(input);
    }
}
