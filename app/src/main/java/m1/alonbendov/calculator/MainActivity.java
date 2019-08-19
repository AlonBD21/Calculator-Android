package m1.alonbendov.calculator;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MainActivity extends Activity {
    static private TextView s;
    static private TextView smalls;
    static private String currentNum = "";
    static public Object isPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Refrences
        s = findViewById(R.id.s);
        smalls = findViewById(R.id.smalls);
        s.setText("");
        smalls.setText("");
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button cross = findViewById(R.id.cross);
        Button slash = findViewById(R.id.slash);
        Button back = findViewById(R.id.back);
        Button dot = findViewById(R.id.dot);
        Button clr = findViewById(R.id.clr);
        Button equal = findViewById(R.id.equal);
        Button[] btnsNum = new Button[10];
        btnsNum[0] = findViewById(R.id.z);
        btnsNum[1] = findViewById(R.id.a);
        btnsNum[2] = findViewById(R.id.b);
        btnsNum[3] = findViewById(R.id.c);
        btnsNum[4] = findViewById(R.id.d);
        btnsNum[5] = findViewById(R.id.e);
        btnsNum[6] = findViewById(R.id.f);
        btnsNum[7] = findViewById(R.id.g);
        btnsNum[8] = findViewById(R.id.h);
        btnsNum[9] = findViewById(R.id.i);
        //Listeners
        for (int i = 0; i < btnsNum.length; i++) btnsNum[i].setOnClickListener(new Number());
        plus.setOnClickListener(new Action());
        minus.setOnClickListener(new Action());
        cross.setOnClickListener(new Action());
        slash.setOnClickListener(new Action());

        clr.setOnClickListener(new Action.ClearAll());
        back.setOnClickListener(new Action.Clear());
        dot.setOnClickListener(new Action.Dot());
        equal.setOnClickListener(new Equals());

    }

    //S Functions
    public static void sClr() {
        s.setText("");
    }

    static void sChange(String out) {
        s.setText(out);
    }
    public static String sGet() {
        return s.getText() + "";
    }

    //Smalls Functions
    public static void smallsClr() {
        smalls.setText("");
    }

    static void smallsChange(String out) {
        smalls.setText(out);
    }

    public static void smallsAdd(String out) {
        final String smallsTxt = smallsGet(); //current num system
        if (smallsTxt != "") {
            if (!Character.isDigit(smallsTxt.charAt(smallsTxt.length() - 1)) && smallsTxt.charAt(smallsTxt.length() - 1) != '.') {
                currentNum = out;
            } else currentNum = currentNum + out;
        }else currentNum = out;

        smallsChange(smallsTxt + out);
    }

    public static String smallsGet() {
        return smalls.getText() + "";
    }

    //Other functions
    public static String getCurrentNum() {
        return currentNum;
    }
    public static void clrCurrentNum(){
        currentNum = "";
    }
    public static void makeCurrentNum(){
        String smalls = smallsGet();
        int last = smalls.lastIndexOf('*');
        last = Math.max(last,smalls.lastIndexOf('/'));
        last = Math.max(last,smalls.lastIndexOf('+'));
        last = Math.max(last,smalls.lastIndexOf('-'));
        if (smalls.length()-1>last){
            smalls = smalls.substring(last+1);
        }else{
            currentNum = "";
        }
    }

    //Add Split Function
}