package functions;

import javax.swing.JOptionPane;
import javax.swing.JLabel;


public class btnFunc {
    // Just a class which will involve all the buttons and the actions and according to that, it will perform the result including the unexpected errors
    
    // Checking if the given number for division is 0 or not...
    static int CheckZero(double arg) {
            if (Math.round(arg)==0) {
    
                JOptionPane.showMessageDialog(null,"Error, you tried to divide something by 0... ","Error", JOptionPane.WARNING_MESSAGE);
                
                return 0;
            }
            else return 1;
        }
    
        // Creating a function operation where all the mathematical operations will be handled. This function will be used when "=" sign is pressed
        @SuppressWarnings("null")
        public static double Operation(String op, JLabel txt, double CurrentNum) {
    
            double x = Double.parseDouble(txt.getText());
    
            
            switch (op) {
                case("÷"):
                    int toCheck = CheckZero(x);
                if (toCheck == 0) {
                    return (Double) null;
                }
                x=(CurrentNum/x);
                break;
            case("x"):
                x=(CurrentNum*x);
                break;
            case("+"):
                x=(CurrentNum+x);
                break;
            case("-"):
                x=(CurrentNum-x);
                break;
        }

        return x;
    }




}
