import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


class smth extends JFrame implements ActionListener{

    private JLabel Result;
    private double CurrentNum;

    smth() {
        
        // Initializing the basic frame
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,800));
        this.setSize(600, 900);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(400,400));
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        int wide = this.getWidth();

        // Initializing basic labels for the Calculator to make it functional

        Result = new JLabel();

        Result.setText("Calc Here");
        Result.setSize(new Dimension(wide,this.getHeight()/5));
        Result.setPreferredSize(new Dimension(wide,this.getHeight()/5));
        Result.setMinimumSize(new Dimension(wide,50));
        Result.setForeground(Color.WHITE);
        Result.setBackground(Color.BLACK);
        Result.setOpaque(true);
        Result.setVerticalTextPosition(JLabel.TOP);
        Result.setHorizontalAlignment(JLabel.RIGHT);



        JLabel Calc_Display = new JLabel();

        GridLayout Calc_layout = new GridLayout();

        Calc_layout.setColumns(4);
        Calc_layout.setRows(4);
        Calc_layout.setHgap(1);
        Calc_layout.setVgap(3);
        Calc_layout.preferredLayoutSize(Calc_Display);

        // Setting the layout for the Buttons

        Calc_Display.setVisible(true);
        Calc_Display.setSize(new Dimension(wide,4*(this.getHeight()/5)));
        Calc_Display.setPreferredSize(new Dimension(wide,4*(this.getHeight()/5)));
        Calc_Display.setMinimumSize(new Dimension(wide,200));


        // Buttons for expressions
        String[] BtnNames = {"1","2","3","4","5","6","7","8","9","0","+","-","X","÷","=","C"};

        for (int x = 0; x<16; x++) {
            JButton thisBtn = new JButton();
            thisBtn.setText(BtnNames[x]);
            thisBtn.setVisible(true);
            thisBtn.setSize(new Dimension(wide/4,5));
            thisBtn.setPreferredSize(new Dimension(wide/4,5));
            thisBtn.setMinimumSize(new Dimension(wide/4,5));
            thisBtn.setVerticalTextPosition(JButton.CENTER);
            thisBtn.setHorizontalTextPosition(JButton.CENTER);
            thisBtn.setBackground(Color.WHITE);
            thisBtn.setForeground(Color.BLACK);
            thisBtn.setOpaque(true);

            Calc_Display.add(thisBtn);
        }

        Calc_Display.setLayout(Calc_layout);

        // Button for clear

        this.add(Result, BorderLayout.NORTH);
        this.add(Calc_Display, BorderLayout.SOUTH);

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

