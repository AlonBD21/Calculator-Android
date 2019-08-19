package m1.alonbendov.calculator;

import android.view.View;
import android.widget.Button;

public class Action implements View.OnClickListener {
    static private boolean closeMinus = false;

    @Override
    public void onClick(View v) {//dont use smallsAdd()
        String bTxt = ((Button) v).getText() + "";
        String smalls = MainActivity.smallsGet();
        if (smalls.length() > 0) {
            if (smalls.charAt(smalls.length() - 1) == '.') {
                //Toast
                return;
            }
        }
        if (!bTxt.equals("-")) { //for the actions not "-"
            if (smalls.length() > 0) { //add act only if smalls is not empty and smalls is ending on digit
                if (Character.isDigit(smalls.charAt(smalls.length() - 1))) {
                    String act = (bTxt).replace("X", "*");
                    MainActivity.smallsAdd(act);
                } else ;//toast
            } else ; //toast
        } else {//for "-"
            if (smalls.length() > 0) {
                if (smalls.charAt(smalls.length() - 1) == '+') {
                    smalls = smalls.substring(0, smalls.length() - 1);
                    smalls = smalls + "-";
                    MainActivity.smallsChange(smalls);
                } else if (smalls.charAt(smalls.length() - 1) == '-') {
                    smalls = smalls.substring(0, smalls.length() - 1);
                    smalls = smalls + "+";
                    MainActivity.smallsChange(smalls);
                } else {
                    MainActivity.smallsChange(MainActivity.smallsGet() + "-");
                }
            } else MainActivity.smallsChange(MainActivity.smallsGet() + "-");
        }
        String newSmalls = MainActivity.smallsGet();
        if (smalls.length() > 0) {
            if (!Character.isDigit(newSmalls.charAt(newSmalls.length() - 1))) {
                MainActivity.clrCurrentNum();
            }
        }
    }

    public static class ClearAll implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            MainActivity.sClr();
            MainActivity.smallsClr();
            MainActivity.clrCurrentNum();
        }
    }

    public static class Clear implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String smalls = MainActivity.smallsGet();
            if (smalls != "") {
                smalls = smalls.substring(0, smalls.length() - 1);
                MainActivity.smallsChange(smalls);
            }
            MainActivity.makeCurrentNum();
        }
    }

    public static class Dot implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(Number.isFreezeNeeded()){
                return;
            }
            String currentNum = MainActivity.getCurrentNum();
            if (!currentNum.contains(".") && currentNum != "")
                MainActivity.smallsAdd(".");
        }
    }
}