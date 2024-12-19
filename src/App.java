import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


class smth extends JFrame implements ActionListener{

    private JLabel Result;
    private double CurrentNum;

    private JLabel MainFrame;
    smth() {
        
        // Initializing the basic frame
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(400,900));
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());


        // Initializing basic Buttons for the Calculator to make it functional
        JLabel Calc_Display = new JLabel();
        this.setLayout(new GridLayout());



        // Buttons for expressions
        JLabel[] Req_Buttons = new JLabel[16];



        // Button for clear


        this.add(Calc_Display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

public class App {
    public static void main(String[] args) {
        new smth();
    }
}

