
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Model{
    char  tab[][] = new char[5][5];

}


class Latwa extends JFrame {
    Random r = new Random();
    Model model = new Model();
    JTextField tab[][] = new JTextField[5][5] ;
    JTextField t = new JTextField(10);
    JButton checkButton = new JButton("Check");
    JButton zapis = new JButton("Zapisz"),
            wczytaj = new JButton("Wczytaj"),
            menu = new JButton("Menu");
    JPanel plansza = new JPanel();
    JPanel sterowanie = new JPanel();
    public Latwa() {
        int i,j;
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,2));
        cp.add(plansza);cp.add(sterowanie);
        sterowanie.add(t);
        t.setEditable(false);
        t.setHorizontalAlignment(SwingConstants.CENTER);
        sterowanie.add(checkButton);
        sterowanie.add(zapis);
        sterowanie.add(wczytaj);
        sterowanie.add(menu);
        checkButton.addActionListener(new CheckButton());
        zapis.addActionListener(new ZapisButton());
        wczytaj.addActionListener(new WczytajButton());
        menu.addActionListener(new MenuButton());
        checkButton.setEnabled(false);
        sterowanie.setLayout(new GridLayout(5,1));
        plansza.setLayout(new GridLayout(5,5));
        for (i=0;i<5;i++)
            for (j=0;j<5;j++){
                tab[i][j]=new JTextField("");
                tab[i][j].setForeground(Color.black);
                tab[i][j].setBackground(Color.LIGHT_GRAY);
                plansza.add(tab[i][j]);
                tab[i][j].getDocument().addDocumentListener(new B(i ,j));
            }
        tab[3][0].setBackground(Color.black);
        tab[3][0].setText("999");
        tab[3][0].setEditable(false);

        tab[0][4].setText("5");
        tab[0][4].setEditable(false);


        tab[1][0].setText("3");
        tab[1][0].setEditable(false);

        tab[1][2].setText("1");
        tab[1][2].setEditable(false);

        tab[2][1].setBackground(Color.black);
        tab[2][1].setText("1001");
        tab[2][1].setEditable(false);

        tab[4][3].setBackground(Color.black);
        tab[4][3].setText("1002");
        tab[4][3].setEditable(false);

        cp.setSize(1200 , 600);
        cp.setVisible(true);


        middle();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void middle(){
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                tab[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
    }

    void puste(){
        int licznik2 =0;
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                if(tab[i][j].getText().equals("")){
                    licznik2++;
                    break;
                }
            }
        }

        if(licznik2==0){
            checkButton.setEnabled(true);
        }
        else{
            checkButton.setEnabled(false);
        }
    }

    void check(){
        int rezultat = 0;

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
            if (Integer.parseInt(tab[0][i].getText()) != Integer.parseInt(tab[0][j].getText())){
                rezultat++;
            }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[i][0].getText()) != Integer.parseInt(tab[j][0].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[1][i].getText()) != Integer.parseInt(tab[1][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[i][1].getText()) != Integer.parseInt(tab[j][1].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[2][i].getText()) != Integer.parseInt(tab[2][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[i][2].getText()) != Integer.parseInt(tab[j][2].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[3][i].getText()) != Integer.parseInt(tab[3][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[i][3].getText()) != Integer.parseInt(tab[j][3].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[4][i].getText()) != Integer.parseInt(tab[4][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++)
                if (Integer.parseInt(tab[i][4].getText()) != Integer.parseInt(tab[j][4].getText())){
                    rezultat++;
                }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int licznik =0 ;
        for (int i = 0; i < 5; i++) {
            if(tab[0][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[0][i].getText()));

        }

        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                    break;
                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[1][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[1][i].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;

                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[2][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[2][i].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[3][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[3][i].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[4][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[4][i].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

               for (int i = 0; i < 5; i++) {
            if(tab[i][0].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][0].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[i][1].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][1].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[i][2].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][2].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[i][3].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][3].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

        for (int i = 0; i < 5; i++) {
            if(tab[i][4].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][4].getText()));
        }
        Collections.sort(list);

        for(int i=0 ; i<list.size() ; i++)
        {
            for(int j=0 ; j<list.size() ; j++) {

                if (list.get(i) + 1 == list.get(j)) {
                    licznik++;
                }
            }
        }

        list.clear();

        int czarne =0;
        for(int i=0 ; i<5 ; i++) {
            for (int j = 0; j < 5; j++) {
                if (tab[i][j].getBackground() == Color.black)
                    czarne++;
            }
        }
        czarne=czarne*2;

        if(licznik==((5*4*2)-czarne) && rezultat == 20*10  ){
            t.setText("Dobrze");
        }
        else{
            t.setText("Zle");
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

            puste();

        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            puste();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            puste();
        }

    }

    class CheckButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            check();

        }
    }


    class ZapisButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    class WczytajButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    class MenuButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            JFrame f = new Main();
            f.setSize(300 , 100);
            f.setVisible(true);
        }
    }

}