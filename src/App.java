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
        this.setPreferredSize(new Dimension(700,700));
        this.setSize(600, 800);
        // this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());


        // Initializing basic labels for the Calculator to make it functional

        Result = new JLabel();

        Result.setText("Calculations Here");
        Result.setPreferredSize(new Dimension(200,700));
        Result.setForeground(Color.WHITE);
        Result.setBackground(Color.BLACK);



        JLabel Calc_Display = new JLabel();

        GridLayout Calc_layout = new GridLayout();

        Calc_layout.setColumns(4);
        Calc_layout.setRows(4);
        Calc_layout.setHgap(0);
        Calc_layout.setVgap(1);

        Calc_Display.setLayout(Calc_layout);


        Calc_Display.setVisible(true);
        Calc_Display.setPreferredSize(new Dimension(500,400));



        // Buttons for expressions
        String[] BtnNames = {"1","2","3","4","5","6","7","8","9","0","+","-","X","÷","=","Clear"};

        for (int x = 0; x<16; x++) {
            JButton thisBtn = new JButton();
            thisBtn.setName(BtnNames[x]);
            thisBtn.setVisible(true);
            thisBtn.setPreferredSize(new Dimension(35,40));
            thisBtn.setVerticalTextPosition(JButton.CENTER);
            thisBtn.setHorizontalTextPosition(JButton.CENTER);

            System.out.println(thisBtn);
            Calc_Display.add(thisBtn);
        }



        // Button for clear

        this.add(Result, BorderLayout.NORTH);
        this.add(Calc_Display, BorderLayout.SOUTH);

        this.pack();

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

