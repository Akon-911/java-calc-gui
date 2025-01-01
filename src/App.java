import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import functions.btnFunc;


class smth extends JFrame {

    public static JLabel ResultLab;
    public static double CurrentNum;

    smth() {
        
        // Initializing the basic frame
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,800));
        this.setResizable(true);
        this.setSize(600, 600);
        this.setMinimumSize(new Dimension(500,600));
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        int wide = this.getWidth();

        // Initializing basic labels for the Calculator to make it functional

        ResultLab = new JLabel();
        CurrentNum = 0;

        ResultLab.setText("0"); // Converting the current num to String
        ResultLab.setFont(new Font("Times New Roman", 1, 45));
        ResultLab.setForeground(Color.WHITE);
        ResultLab.setBackground(Color.BLACK);
        ResultLab.setOpaque(true);
        ResultLab.setHorizontalAlignment(JLabel.RIGHT);


        JLabel Calc_Display = new JLabel();

        GridLayout Calc_layout = new GridLayout();

        Calc_layout.setColumns(4);
        Calc_layout.setRows(4);
        Calc_layout.setHgap(1);
        Calc_layout.setVgap(3);
        Calc_layout.preferredLayoutSize(Calc_Display);

        // Setting the layout for the Buttons

        Calc_Display.setVisible(true);
        Calc_Display.setPreferredSize(new Dimension(wide,4*(this.getHeight()/5)));
        Calc_Display.setMinimumSize(new Dimension(wide,210));


        // Buttons for expressions
        String[] BtnNames = {"1","2","3","+","4","5","6","-","7","8","9","x","÷","0","=","C"};

        for (int x = 0; x<16; x++) {
            JButton thisBtn = new JButton();
            thisBtn.setText(BtnNames[x]);
            thisBtn.setName(BtnNames[x]);
            thisBtn.setVisible(true);
            thisBtn.setVerticalTextPosition(JButton.CENTER);
            thisBtn.setHorizontalTextPosition(JButton.CENTER);
            thisBtn.setBackground(Color.BLACK);
            thisBtn.setForeground(Color.WHITE);
            thisBtn.setOpaque(true);
            thisBtn.setFont(new Font("Times New Roman", 1, 45));
            thisBtn.addMouseListener(new OverLayBtn(thisBtn));
            thisBtn.setFocusable(false);
            thisBtn.addActionListener(new ActWorker(thisBtn));

            Calc_Display.add(thisBtn);
        }

        Calc_Display.setLayout(Calc_layout);

        // Button for clear

        this.add(ResultLab, BorderLayout.NORTH);
        this.add(Calc_Display, BorderLayout.SOUTH);

    }

}

class ActWorker implements ActionListener {

    private JButton x;
    
    ActWorker(JButton forInp) {
        this.x = forInp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String opr = x.getName(); // Getting the input button character.

        // Setting the if-else statement
        if (opr == "x" || opr == "+" || opr == "-" || opr == "÷") { // For the operations
        
            smth.CurrentNum = btnFunc.Operation(opr,smth.ResultLab,smth.CurrentNum);
            
            // smth.ResultLab.setText("Operation Here");
        }
        else if (opr=="=") { // For the `equals to` button

            String t = smth.ResultLab.getText();
            
            StringBuffer newTxt = new StringBuffer(t);

            // Removing Accidental signs...
            if (t.endsWith("x") || t.endsWith("-") || t.endsWith("+") || t.endsWith("÷")) {
                newTxt = newTxt.deleteCharAt(t.length()-1);
                smth.ResultLab.setText(newTxt.toString());
            }

            String res = btnFunc.NrmInt(newTxt.toString(), smth.CurrentNum);
            if (res == "E0") {
                JOptionPane.showMessageDialog(null,"Error, you tried to divide something by 0... ","Error", JOptionPane.WARNING_MESSAGE);
                return; // to avoid errors...
            }
            smth.CurrentNum = Double.parseDouble(res);
            smth.ResultLab.setText(res);



        } else if (opr == "C") { // Making the Clear Button work

            smth.ResultLab.setText("0");
            smth.CurrentNum=0;

        } else { // For the rest of the numbers


            String thisInt = smth.ResultLab.getText();
            if (thisInt == "0") {
                smth.ResultLab.setText(opr);
            } else {
                smth.ResultLab.setText(thisInt + opr);
            }

        }
    }
    
}

// Overlays for the Buttons in calc
class OverLayBtn extends MouseAdapter {
    private JButton s;
    public OverLayBtn(JButton forInput) {
        this.s = forInput;
    }
    public void mouseEntered(MouseEvent x) {
        this.s.setBackground(Color.DARK_GRAY);
        this.s.setForeground(Color.LIGHT_GRAY);
    }
    public void mouseExited(MouseEvent x) {
        this.s.setBackground(Color.BLACK);
        this.s.setForeground(Color.WHITE);
    }
}

public class App {
    public static void main(String[] args) {
        new smth();
    }
}

