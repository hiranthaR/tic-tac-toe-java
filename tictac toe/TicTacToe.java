import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TicTacToe {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    ArrayList<Integer> allNumbers = new ArrayList<>();
    ArrayList<Integer> manNumbers = new ArrayList<>();
    ArrayList<Integer> comNumbers = new ArrayList<>();
    int turn = 1;

    public TicTacToe() {
        owner();
        setView();
    }

    public void setView() {

        System.out.println("Loding View");

        Color backgroundColor = new Color(152, 222, 184);
        UIManager.put("Button.background", backgroundColor);
        UIManager.put("Button.font", new Font("Dialog", Font.BOLD, 56));
        UIManager.put("Button.focus", backgroundColor);
        UIManager.put("Panel.background", backgroundColor);

        JPanel panel = new JPanel(new GridLayout(3, 3, 1, 1));

        b1 = new JButton("");
        panel.add(b1);

        b2 = new JButton("");
        panel.add(b2);

        b3 = new JButton("");
        panel.add(b3);

        b4 = new JButton("");
        panel.add(b4);

        b5 = new JButton("");
        panel.add(b5);

        b6 = new JButton("");
        panel.add(b6);

        b7 = new JButton("");
        panel.add(b7);

        b8 = new JButton("");
        panel.add(b8);

        b9 = new JButton("");
        panel.add(b9);

        JFrame frame = new JFrame("Tic tac Toe");
        frame.setSize(300, 300);
        frame.add(panel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("");
                System.out.println("##################################################");
                System.exit(0);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        System.out.println("Loding View Complete");

        initializeActions();

    }

    private void initializeActions() {

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(1);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(2);

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(3);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(4);
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(5);
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(6);
            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(7);
            }
        });

        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(8);
            }
        });

        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setManTurn(9);
            }
        });

        System.out.println("Initialize Buttons Complete");
    }

    private void setButton(int i, String c) {

        switch (i) {
            case 1:
                b1.setEnabled(false);
                b1.setText(c);
                break;

            case 2:
                b2.setEnabled(false);
                b2.setText(c);
                break;

            case 3:
                b3.setEnabled(false);
                b3.setText(c);
                break;

            case 4:
                b4.setEnabled(false);
                b4.setText(c);
                break;

            case 5:
                b5.setEnabled(false);
                b5.setText(c);
                break;

            case 6:
                b6.setEnabled(false);
                b6.setText(c);
                break;

            case 7:
                b7.setEnabled(false);
                b7.setText(c);
                break;

            case 8:
                b8.setEnabled(false);
                b8.setText(c);
                break;

            case 9:
                b9.setEnabled(false);
                b9.setText(c);
                break;
        }

        if (c.equals("X")) {
            getComTurn(i);
        }
    }

    private void setManTurn(int i) {
        manNumbers.add(i);
        allNumbers.add(i);
        setButton(i, "X");
    }

    private void setComTurn(int i) {
        comNumbers.add(i);
        allNumbers.add(i);
        setButton(i, "O");
    }

    private void cheakComWon() {
        if (comNumbers.containsAll(Arrays.asList(1, 2, 3)) || comNumbers.containsAll(Arrays.asList(4, 5, 6)) || comNumbers.containsAll(Arrays.asList(7, 8, 9)) || comNumbers.containsAll(Arrays.asList(1, 4, 7)) || comNumbers.containsAll(Arrays.asList(2, 5, 8)) || comNumbers.containsAll(Arrays.asList(3, 9, 6)) || comNumbers.containsAll(Arrays.asList(1, 5, 9)) || comNumbers.containsAll(Arrays.asList(3, 5, 7))) {
            JOptionPane.showMessageDialog(null, "Computer won the match !", "lost", 1);
            System.out.println("Lost");
            System.exit(0);
        }
    }

    private void cheakManWon() {
        if (manNumbers.containsAll(Arrays.asList(1, 2, 3)) || manNumbers.containsAll(Arrays.asList(4, 5, 6)) || manNumbers.containsAll(Arrays.asList(7, 8, 9)) || manNumbers.containsAll(Arrays.asList(1, 4, 7)) || manNumbers.containsAll(Arrays.asList(2, 5, 8)) || manNumbers.containsAll(Arrays.asList(3, 9, 6)) || manNumbers.containsAll(Arrays.asList(1, 5, 9)) || manNumbers.containsAll(Arrays.asList(3, 5, 7))) {
            JOptionPane.showMessageDialog(null, "You won the match !", "Win", 1);
            System.out.println("Won");
            System.exit(0);
        }
    }

    private void getComTurn(int number) {

        cheakManWon();

        if (turn < 5) {
            if (comNumbers.containsAll(Arrays.asList(1, 2)) && !allNumbers.contains(3)) {       //1st row
                setComTurn(3);
            } else if (comNumbers.containsAll(Arrays.asList(1, 3)) && !allNumbers.contains(2)) {
                setComTurn(2);
            } else if (comNumbers.containsAll(Arrays.asList(2, 3)) && !allNumbers.contains(1)) {
                setComTurn(1);
            } else if (comNumbers.containsAll(Arrays.asList(4, 5)) && !allNumbers.contains(6)) { //2nd row
                setComTurn(6);
            } else if (comNumbers.containsAll(Arrays.asList(5, 6)) && !allNumbers.contains(4)) {
                setComTurn(4);
            } else if (comNumbers.containsAll(Arrays.asList(4, 6)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else if (comNumbers.containsAll(Arrays.asList(7, 8)) && !allNumbers.contains(9)) { //3rd row
                setComTurn(9);
            } else if (comNumbers.containsAll(Arrays.asList(7, 9)) && !allNumbers.contains(8)) {
                setComTurn(8);
            } else if (comNumbers.containsAll(Arrays.asList(9, 8)) && !allNumbers.contains(7)) {
                setComTurn(7);
            } else if (comNumbers.containsAll(Arrays.asList(1, 4)) && !allNumbers.contains(7)) { //1st colmn
                setComTurn(7);
            } else if (comNumbers.containsAll(Arrays.asList(4, 7)) && !allNumbers.contains(1)) {
                setComTurn(1);
            } else if (comNumbers.containsAll(Arrays.asList(1, 7)) && !allNumbers.contains(4)) {
                setComTurn(4);
            } else if (comNumbers.containsAll(Arrays.asList(2, 5)) && !allNumbers.contains(8)) { //2nd colmn
                setComTurn(8);
            } else if (comNumbers.containsAll(Arrays.asList(5, 8)) && !allNumbers.contains(2)) {
                setComTurn(2);
            } else if (comNumbers.containsAll(Arrays.asList(2, 8)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else if (comNumbers.containsAll(Arrays.asList(3, 9)) && !allNumbers.contains(6)) { //3rd colmn
                setComTurn(6);
            } else if (comNumbers.containsAll(Arrays.asList(3, 6)) && !allNumbers.contains(9)) {
                setComTurn(9);
            } else if (comNumbers.containsAll(Arrays.asList(6, 9)) && !allNumbers.contains(3)) {
                setComTurn(3);
            } else if (comNumbers.containsAll(Arrays.asList(1, 5)) && !allNumbers.contains(9)) { //forword cross
                setComTurn(9);
            } else if (comNumbers.containsAll(Arrays.asList(9, 5)) && !allNumbers.contains(1)) {
                setComTurn(1);
            } else if (comNumbers.containsAll(Arrays.asList(1, 9)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else if (comNumbers.containsAll(Arrays.asList(3, 5)) && !allNumbers.contains(7)) { //backword cross
                setComTurn(7);
            } else if (comNumbers.containsAll(Arrays.asList(7, 5)) && !allNumbers.contains(3)) {
                setComTurn(3);
            } else if (comNumbers.containsAll(Arrays.asList(3, 7)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else if (manNumbers.containsAll(Arrays.asList(1, 2)) && !allNumbers.contains(3)) {       //1st row
                setComTurn(3);
            } else if (manNumbers.containsAll(Arrays.asList(1, 3)) && !allNumbers.contains(2)) {
                setComTurn(2);
            } else if (manNumbers.containsAll(Arrays.asList(2, 3)) && !allNumbers.contains(1)) {
                setComTurn(1);
            } else if (manNumbers.containsAll(Arrays.asList(4, 5)) && !allNumbers.contains(6)) { //2nd row
                setComTurn(6);
            } else if (manNumbers.containsAll(Arrays.asList(5, 6)) && !allNumbers.contains(4)) {
                setComTurn(4);
            } else if (manNumbers.containsAll(Arrays.asList(4, 6)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else if (manNumbers.containsAll(Arrays.asList(7, 8)) && !allNumbers.contains(9)) { //3rd row
                setComTurn(9);
            } else if (manNumbers.containsAll(Arrays.asList(7, 9)) && !allNumbers.contains(8)) {
                setComTurn(8);
            } else if (manNumbers.containsAll(Arrays.asList(9, 8)) && !allNumbers.contains(7)) {
                setComTurn(7);
            } else if (manNumbers.containsAll(Arrays.asList(1, 4)) && !allNumbers.contains(7)) { //1st colmn
                setComTurn(7);
            } else if (manNumbers.containsAll(Arrays.asList(4, 7)) && !allNumbers.contains(1)) {
                setComTurn(1);
            } else if (manNumbers.containsAll(Arrays.asList(1, 7)) && !allNumbers.contains(4)) {
                setComTurn(4);
            } else if (manNumbers.containsAll(Arrays.asList(2, 5)) && !allNumbers.contains(8)) { //2nd colmn
                setComTurn(8);
            } else if (manNumbers.containsAll(Arrays.asList(5, 8)) && !allNumbers.contains(2)) {
                setComTurn(2);
            } else if (manNumbers.containsAll(Arrays.asList(2, 8)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else if (manNumbers.containsAll(Arrays.asList(3, 9)) && !allNumbers.contains(6)) { //3rd colmn
                setComTurn(6);
            } else if (manNumbers.containsAll(Arrays.asList(3, 6)) && !allNumbers.contains(9)) {
                setComTurn(9);
            } else if (manNumbers.containsAll(Arrays.asList(6, 9)) && !allNumbers.contains(3)) {
                setComTurn(3);
            } else if (manNumbers.containsAll(Arrays.asList(1, 5)) && !allNumbers.contains(9)) { //forword cross
                setComTurn(9);
            } else if (manNumbers.containsAll(Arrays.asList(9, 5)) && !allNumbers.contains(1)) {
                setComTurn(1);
            } else if (manNumbers.containsAll(Arrays.asList(1, 9)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else if (manNumbers.containsAll(Arrays.asList(3, 5)) && !allNumbers.contains(7)) { //backword cross
                setComTurn(7);
            } else if (manNumbers.containsAll(Arrays.asList(7, 5)) && !allNumbers.contains(3)) {
                setComTurn(3);
            } else if (manNumbers.containsAll(Arrays.asList(3, 7)) && !allNumbers.contains(5)) {
                setComTurn(5);
            } else {
                int i = new Random().nextInt(8) + 1;
                while (allNumbers.contains(i)) {
                    i = new Random().nextInt(8) + 1;
                }
                setComTurn(i);
            }

        }

        if (turn == 5) {
            JOptionPane.showMessageDialog(null, "Match Drow", "Drow", 1);
            System.out.println("Drow");
            System.exit(0);
        }

        cheakComWon();

        turn++;
    }

    void owner() {
        try {
            System.out.println("");
            System.out.println("  ##  ## ###### #####     ####   ####    ## ###### ##  ##   #### ");
            Thread.sleep(250);
            System.out.println("  ##  ##   ##   ##  ##   ##  ##  ## ##   ##   ##   ##  ##  ##  ##");
            Thread.sleep(250);
            System.out.println("  ######   ##   #####   ######## ##  ##  ##   ##   ###### ########");
            Thread.sleep(250);
            System.out.println("  ##  ##   ##   ##  ##  ##    ## ##   ## ##   ##   ##  ## ##    ## ");
            Thread.sleep(250);
            System.out.println("  ##  ## ###### ##   ## ##    ## ##    ####   ##   ##  ## ##    ##");
            System.out.println("");
            System.out.println("");
            System.out.println("Loading...");
        } catch (InterruptedException e) {

        }

    }

    public static void main(String[] args) {

        new TicTacToe();

    }
}
