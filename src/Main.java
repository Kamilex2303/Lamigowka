import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Model{
    char  tab[][] = new char[9][9];

}


class Main extends JFrame {
    Random r = new Random();
    Model model = new Model();
    JTextField tab[][] = new JTextField[9][9] ;
    JTextField t = new JTextField(10);
    JPanel plansza = new JPanel();
    JPanel sterowanie = new JPanel();
    public Main() {
        int i,j;
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,2));
        cp.add(plansza);cp.add(sterowanie);
        sterowanie.add(t);
        t.setHorizontalAlignment(SwingConstants.CENTER);

        sterowanie.setLayout(new GridLayout(9,1));
        plansza.setLayout(new GridLayout(9,9));
        for (i=0;i<9;i++)
            for (j=0;j<9;j++){
                tab[i][j]=new JTextField("");
                tab[i][j].setBackground(Color.LIGHT_GRAY);
                plansza.add(tab[i][j]);
                tab[i][j].getDocument().addDocumentListener(new B(i ,j));
            }

        middle();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void middle(){
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                tab[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
    }

    class B implements DocumentListener {

        int i;
        int j;

        B(int i , int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public void insertUpdate(DocumentEvent e)  {

            t.setText(i + " , "+j);

        }

        @Override
        public void removeUpdate(DocumentEvent e) {

        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }

    }

    public static void main(String[] args) {
        JFrame f = new Main();
        f.setSize(1200,600);
        f.setLocation(500,300);
        f.setVisible(true);
    }
}