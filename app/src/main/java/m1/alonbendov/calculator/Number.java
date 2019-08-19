package m1.alonbendov.calculator;

import android.view.View;
import android.widget.Button;

public class Number implements View.OnClickListener {

    @Override
    public void onClick(View v) { //use only smallsADD()
        Button b = (Button)v;
        if (!isFreezeNeeded()){
            MainActivity.smallsAdd(b.getText()+"");
        }else{
            //Toast
        }

    }
    public static boolean isFreezeNeeded(){
        String currentNum = MainActivity.getCurrentNum();
        if(currentNum.equals("")){ return false; }
        if (currentNum.charAt(currentNum.length()-1) == '.') return false;
        if(currentNum.length() > 8){ return true; }
        if(MainActivity.smallsGet().length() > 40) return true;
        return false;
    }
}
