package functions;

import javax.swing.JOptionPane;

public class buttons {
    // Just a class which will involve all the buttons and the actions and according to that, it will perform the result including the unexpected errors
    int CheckZero(int arg) {
        if (arg == 0) {

            JOptionPane.showMessageDialog(null,"Error, you tried to divide something by 0... ","Error", JOptionPane.WARNING_MESSAGE);
            
            return 0;
        }
        else return 1;
    }
}
