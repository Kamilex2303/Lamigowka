import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Main extends JFrame {

    public Main() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1, 2));
        cp.setSize(100, 100);
        JButton latweButton = new JButton("Latwa");
        JButton trudnaButton = new JButton("Trudna");
        cp.add(latweButton);
        cp.add(trudnaButton);

        latweButton.addActionListener(new LatwaButton());
        trudnaButton.addActionListener(new TrudnaButton());
    }


    class LatwaButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            setVisible(false);
            JFrame l;
			try {
				l = new Latwa();
				 l.setSize(1200 , 600);
		            l.setVisible(true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           



        }
    }

    class TrudnaButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            setVisible(false);
            JFrame f = new Trudna();
            f.setSize(1200,600);
            f.setVisible(true);

        }
    }

    public static void main(String[] args) {
            JFrame f = new Main();
            f.setSize(300, 100);
            f.setVisible(true);
    }

}