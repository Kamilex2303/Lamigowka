import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;




class Trudna extends JFrame {
    Random r = new Random();
    JTextField tab[][] = new JTextField[9][9] ;
    JTextField t = new JTextField(10);
    JTextField imie = new JTextField();
    JButton checkButton = new JButton("Check");
    JButton zapis = new JButton("Zapisz"),
    wczytaj = new JButton("Wczytaj"),
    menu = new JButton("Menu"),
    instrukcja = new JButton("Instrukcja");
    JPanel plansza = new JPanel();
    JPanel sterowanie = new JPanel();
    public Trudna() {
        int i,j;
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,2));
        cp.add(plansza);cp.add(sterowanie);
        sterowanie.add(t);
        t.setEditable(false);
        t.setHorizontalAlignment(SwingConstants.CENTER);
        sterowanie.add(checkButton);
        sterowanie.add(imie);
        sterowanie.add(zapis);
        sterowanie.add(wczytaj);
        sterowanie.add(instrukcja);
        sterowanie.add(menu);
        checkButton.addActionListener(new CheckButton());
        checkButton.setEnabled(false);
        zapis.addActionListener(new ZapiszButton());
        wczytaj.addActionListener(new WczytajButton());
        menu.addActionListener(new MenuButton());
        instrukcja.addActionListener(new InstrukcjaButton());
        sterowanie.setLayout(new GridLayout(9,1));
        plansza.setLayout(new GridLayout(9,9));
        for (i=0;i<9;i++)
            for (j=0;j<9;j++){
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


        tab[0][1].setBackground(Color.black);
        tab[0][1].setText("999");
        tab[0][1].setEditable(false);

        tab[0][5].setText("10");
        tab[0][5].setEditable(false);

        tab[0][8].setBackground(Color.black);
        tab[0][8].setText("1000");
        tab[0][8].setEditable(false);

        tab[1][0].setText("9");
        tab[1][0].setEditable(false);

        tab[1][2].setText("8");
        tab[1][2].setEditable(false);

        tab[1][4].setBackground(Color.black);
        tab[1][4].setText("1001");
        tab[1][4].setEditable(false);

        tab[1][7].setBackground(Color.black);
        tab[1][7].setText("1002");
        tab[1][7].setEditable(false);

        tab[1][8].setText("4");
        tab[1][8].setEditable(false);

        tab[2][1].setText("3");
        tab[2][1].setEditable(false);

        tab[2][2].setBackground(Color.black);
        tab[2][2].setText("1003");
        tab[2][2].setEditable(false);

        tab[2][4].setText("6");
        tab[2][4].setEditable(false);

        tab[2][6].setText("1");
        tab[2][6].setEditable(false);

        tab[3][0].setBackground(Color.black);
        tab[3][0].setText("1004");
        tab[3][0].setEditable(false);

        tab[3][2].setBackground(Color.black);
        tab[3][2].setText("1005");
        tab[3][2].setEditable(false);

        tab[3][3].setText("10");
        tab[3][3].setEditable(false);

        tab[3][4].setBackground(Color.black);
        tab[3][4].setText("1006");
        tab[3][4].setEditable(false);

        tab[3][7].setText("9");
        tab[3][7].setEditable(false);

        tab[3][8].setBackground(Color.black);
        tab[3][8].setText("1007");
        tab[3][8].setEditable(false);

        tab[4][0].setText("12");
        tab[4][0].setEditable(false);

        tab[4][1].setBackground(Color.black);
        tab[4][1].setText("1008");
        tab[4][1].setEditable(false);

        tab[4][2].setText("11");
        tab[4][2].setEditable(false);

        tab[4][4].setBackground(Color.black);
        tab[4][4].setText("1009");
        tab[4][4].setEditable(false);

        tab[4][6].setBackground(Color.black);
        tab[4][6].setText("1010");
        tab[4][6].setEditable(false);

        tab[5][1].setText("6");
        tab[5][1].setEditable(false);

        tab[5][3].setBackground(Color.black);
        tab[5][3].setText("1011");
        tab[5][3].setEditable(false);

        tab[5][4].setText("7");
        tab[5][4].setEditable(false);

        tab[5][6].setText("4");
        tab[5][6].setEditable(false);

        tab[5][7].setBackground(Color.black);
        tab[5][7].setText("1012");
        tab[5][7].setEditable(false);

        tab[6][0].setBackground(Color.black);
        tab[6][0].setText("1013");
        tab[6][0].setEditable(false);

        tab[6][2].setText("7");
        tab[6][2].setEditable(false);

        tab[6][3].setBackground(Color.black);
        tab[6][3].setText("1014");
        tab[6][3].setEditable(false);

        tab[6][5].setText("3");
        tab[6][5].setEditable(false);

        tab[6][8].setText("8");
        tab[6][8].setEditable(false);

        tab[7][1].setText("5");
        tab[7][1].setEditable(false);

        tab[7][4].setText("9");
        tab[7][4].setEditable(false);

        tab[7][5].setBackground(Color.black);
        tab[7][5].setText("1015");
        tab[7][5].setEditable(false);

        tab[7][6].setBackground(Color.black);
        tab[7][6].setText("1016");
        tab[7][6].setEditable(false);

        tab[7][7].setText("8");
        tab[7][7].setEditable(false);

        tab[8][0].setBackground(Color.black);
        tab[8][0].setText("1017");
        tab[8][0].setEditable(false);

        tab[8][2].setBackground(Color.black);
        tab[8][2].setText("1018");
        tab[8][2].setEditable(false);

        tab[8][3].setText("4");
        tab[8][3].setEditable(false);

        tab[8][4].setBackground(Color.black);
        tab[8][4].setText("1019");
        tab[8][4].setEditable(false);

        tab[8][7].setBackground(Color.black);
        tab[8][7].setText("1020");
        tab[8][7].setEditable(false);

        cp.setSize(1200 , 600);
        cp.setVisible(true);


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

    void puste(){
        int licznik2 =0;
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
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

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[0][i].getText()) != Integer.parseInt(tab[0][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][0].getText()) != Integer.parseInt(tab[j][0].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[1][i].getText()) != Integer.parseInt(tab[1][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][1].getText()) != Integer.parseInt(tab[j][1].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[2][i].getText()) != Integer.parseInt(tab[2][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][2].getText()) != Integer.parseInt(tab[j][2].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[3][i].getText()) != Integer.parseInt(tab[3][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][3].getText()) != Integer.parseInt(tab[j][3].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[4][i].getText()) != Integer.parseInt(tab[4][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][4].getText()) != Integer.parseInt(tab[j][4].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[5][i].getText()) != Integer.parseInt(tab[5][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][5].getText()) != Integer.parseInt(tab[j][5].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[6][i].getText()) != Integer.parseInt(tab[6][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][6].getText()) != Integer.parseInt(tab[j][6].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[7][i].getText()) != Integer.parseInt(tab[7][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][7].getText()) != Integer.parseInt(tab[j][7].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[8][i].getText()) != Integer.parseInt(tab[8][j].getText())){
                    rezultat++;
                }
        }

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++)
                if (Integer.parseInt(tab[i][8].getText()) != Integer.parseInt(tab[j][8].getText())){
                    rezultat++;
                }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int licznik =0 ;
        for (int i = 0; i < 9; i++) {
            if(tab[0][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[0][i].getText()));

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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
            if(tab[5][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[5][i].getText()));
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

        for (int i = 0; i < 9; i++) {
            if(tab[6][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[6][i].getText()));
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

        for (int i = 0; i < 9; i++) {
            if(tab[7][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[7][i].getText()));
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

        for (int i = 0; i < 9; i++) {
            if(tab[8][i].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[8][i].getText()));
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
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

        for (int i = 0; i < 9; i++) {
            if(tab[i][5].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][5].getText()));
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

        for (int i = 0; i < 9; i++) {
            if(tab[i][6].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][6].getText()));
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

        for (int i = 0; i < 9; i++) {
            if(tab[i][7].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][7].getText()));
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

        for (int i = 0; i < 9; i++) {
            if(tab[i][8].getBackground() != Color.black)
                list.add(Integer.parseInt(tab[i][8].getText()));
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
        int czarne =0;
        for(int i=0 ; i<9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if (tab[i][j].getBackground() == Color.black)
                    czarne++;
            }
        }
        czarne=czarne*2;

        if(licznik==((9*8*2)-czarne) && rezultat == 144*9){
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

    class ZapiszButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				FileOutputStream fos = new FileOutputStream(imie.getText());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						oos.writeObject(tab[i][j].getText());
					}
				}
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// klasa wczytuj�ca stan gry z pliku
	class WczytajButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				FileInputStream fis = new FileInputStream(imie.getText());
				ObjectInputStream ois = new ObjectInputStream(fis);
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						tab[i][j].setText((String) ois.readObject());
					}
				}
				ois.close();
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
	
	  class InstrukcjaButton implements ActionListener{

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	JFrame f = new JFrame();
	        	f.setSize(400, 400);
	        	Container cont = f.getContentPane();
	        	JLabel tekst = new JLabel();
	        	cont.setLayout(new GridLayout(1,2));
	        	cont.add(tekst);
	        	tekst.setText("<html>Kilka pól prostokąta zaczerniono, a w niektóre wpisano liczby. <br> Zadanie polega na wypełnieniu liczbami wszystkich pustych pól tak, aby spełnione były następujące warunki:<br>w każdym rzędzie i w każdej kolumnie kwadratu powinny znaleźć się różne liczby;<br>wszystkie liczby w każdym rzędzie (kolumnie) powinny być kolejnymi w ciągu liczb naturalnych;<br> inaczej mówiąc, po ustawieniu ich od najmniejszej do największej różnica między każdymi <br>dwiema kolejnymi liczbami powinna być równa jeden.</html>");
	        	f.setVisible(true);
	        	
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