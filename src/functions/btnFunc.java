package functions;

import javax.swing.JOptionPane;
import javax.swing.JLabel;


public class btnFunc {
    // Just a class which will involve all the buttons and the actions and according to that, it will perform the result including the unexpected errors

    // Creating a function operation where all the mathematical operations will be handled. This function will be used when "=" sign is pressed
    @SuppressWarnings("null")
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
            if (t.charAt(i) == '÷') {
                newTxt.setCharAt(i, '/');
                reqNormalization = true;
            }
            else if (t.charAt(i) == 'x' || t.charAt(i) == '+' || t.charAt(i) =='-') {
                reqNormalization = true;
            }
        }

        if (reqNormalization == true) {
            try {

                double toReturn = Double.parseDouble(newTxt.toString());
                txt.setText(Double.toString(toReturn)+op);
                
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null,"Error, you tried to divide something by 0... ","Error", JOptionPane.WARNING_MESSAGE);
                throw err;
            }

            
        } else {

            txt.setText(t+op);

        }

        return CurrentNum;

        


        
    } 

}
