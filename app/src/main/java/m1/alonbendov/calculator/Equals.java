package m1.alonbendov.calculator;

import android.view.View;

import java.util.ArrayList;

public class Equals implements View.OnClickListener {
    public static boolean minusKeep = false;

    public static ArrayList<String> addCharToLast(ArrayList<String> math, char c) {
        String mathLast = math.get(math.size() - 1);
        mathLast = mathLast + c;
        math.remove(math.size() - 1);
        math.add(mathLast);
        return math;
    }

    public static boolean isNumDot(char c) {
        if (Character.isDigit(c) || c == '.') return true;
        return false;
    }

    @Override
    public void onClick(View v) {
        String string = MainActivity.smallsGet();
        if (string.equals("")) return;

        if (!Character.isDigit(MainActivity.smallsGet().charAt(MainActivity.smallsGet().length() - 1))) {
            //Toast - last has to be a number
            return;
        }

        ArrayList<String> math = new ArrayList<>();


        for (Character c : string.toCharArray()) {
            if (math.size() == 0) {
                math.add(c.toString());
                if (!Character.isDigit(c)) minusKeep = true;
                continue;
            }
            if (minusKeep) {
                math = addCharToLast(math, c);
                minusKeep = false;
                continue;
            }

            String mathLast = math.get(math.size() - 1);
            Character lastChar = mathLast.charAt(mathLast.length() - 1);

            if(isNumDot(lastChar)){
                if (isNumDot(c)){
                    math = addCharToLast(math, c );
                }
                else{
                    math.add(c.toString());
                }
            }else{
                if (isNumDot(c)){
                    math.add(c.toString());
                }
                else{
                    minusKeep = true;
                    math.add(c.toString());
                }
            }

        }
        boolean stop = false;
        for (int i = 0; stop; i++) {
            String part = math.get(i);
            if (part.equals("*")) {
                Double result = Double.parseDouble(math.get(i - 1)) * Double.parseDouble(math.get(i + 1));
                math.remove(i + 1);
                math.remove(i);
                math.remove(i - 1);
                math.add(i - 1, result.toString());
                i = 0;
            }
            if (part.equals("/")) {

            }
            stop = true;
        }


        MainActivity.sChange(math.get(0));
    }
}
