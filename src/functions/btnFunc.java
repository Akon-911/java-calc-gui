package functions;

import javax.swing.JOptionPane;
import javax.swing.JLabel;


public class btnFunc {
    // Just a class which will involve all the buttons and the actions and according to that, it will perform the result including the unexpected errors

    // Creating a function operation where all the mathematical operations will be handled. This function will be used when "=" sign is pressed
    public static double Operation(String op, JLabel txt, double CurrentNum) {

        String t = txt.getText();

        // operation = {'+','-','÷','x'};

        StringBuffer newTxt = new StringBuffer(t);

        if (t.endsWith("x") || t.endsWith("-") || t.endsWith("+") || t.endsWith("÷")) {
            
            newTxt.deleteCharAt(t.length()-1);
            t = newTxt.toString();
            
        }

        boolean reqNormalization = false;

        for(int i = 0; i<t.length(); i++) {
            
            if (t.charAt(i) == '÷' || t.charAt(i) == 'x' || t.charAt(i) == '+' || t.charAt(i) =='-') {
                reqNormalization = true;
            }
        }

        if (reqNormalization == true) {
            
            String nrm  = NrmInt(newTxt.toString(),CurrentNum);
            if (nrm =="e0") {
                JOptionPane.showMessageDialog(null,"Error, you tried to divide something by 0... ","Error", JOptionPane.WARNING_MESSAGE);
                return CurrentNum;
            } else {
                txt.setText(nrm+op);
            }
            
        } else {
            txt.setText(t+op);
        }

        return CurrentNum;
        
    };

    public static String NrmInt(String x, double num) {
        double firstInt, SecondInt;

        for (int i = 0; i<x.length();i++) {
            if (x.charAt(i) == '.') continue;
            if (!Character.isDigit(x.charAt(i))) {
                firstInt = Double.parseDouble(x.substring(0, i));
                SecondInt = Double.parseDouble(x.substring(i+1, x.length()));
                switch(x.charAt(i)){
                    case('x'):
                        num = firstInt*SecondInt;
                        break;
                    case('÷'):
                        if (SecondInt == Double.parseDouble("0")) {
                            return "e0";
                        } else {
                            num = firstInt / SecondInt;
                        }
                        break;
                    case('+'):
                        num = firstInt + SecondInt;
                        break;
                    case('-'):
                        num = firstInt - SecondInt;
                        break;
                }
                    
            };
            
        }
        String res = Double.toString(num);
        if (res.endsWith(".0")) return res.substring(0, res.length()-2);
        return res;
    }

}
