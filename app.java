import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class app extends JPanel implements ActionListener
{
    String deckTitle = "Deck 1";
    String cardText = "Card 1";

    protected JButton b1, b2, b3, b4;

    public app()
    {
        JLabel title = new JLabel();
        title.setVerticalTextPosition(AbstractButton.TOP);
        title.setHorizontalTextPosition(AbstractButton.CENTER);
        title.setPreferredSize(new Dimension(50, 50));
        title.setText(deckTitle);


        b1 = new JButton("<");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setPreferredSize(new Dimension(50, 50));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setActionCommand("left_button");


        b2 = new JButton(cardText);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setPreferredSize(new Dimension(500, 180));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setActionCommand("middle_button");


        b3 = new JButton(">");
        //////////////////////////////////////////////////
        ////////////////////////////////////////////////////
        b3.setPreferredSize(new Dimension(50, 50));
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.WHITE);
        b3.setActionCommand("right_button");


        b4 = new JButton("Shuffle");
        b4.setVerticalTextPosition(AbstractButton.TOP);
        b4.setHorizontalTextPosition(AbstractButton.CENTER);
        b4.setPreferredSize(new Dimension(300, 50));
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.WHITE);
        b4.setActionCommand("shuffle_button");


        //Event listeners for buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        add(title);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }

    //This is where the flashcards call their functions
    public void actionPerformed(ActionEvent e)
    {
        if ("left_button".equals(e.getActionCommand()))
        {
            System.out.println("Left button pressed");
            cardText = "Card 1";
            b2.setText(cardText);
        }
        else if ("right_button".equals(e.getActionCommand()))
        {
            System.out.println("Right button pressed");
            cardText = "Card 2";
            b2.setText(cardText);
        }
        else
        {
            System.out.println("Middle button pressed");
            cardText = "Flipside";
            b2.setText(cardText);
        }
    }


    private static void createGUI()
    {
        //Window setup
        JFrame frame = new JFrame("Flash Cards | Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("images/app_icon.png");
        frame.setIconImage(img.getImage());
        frame.setPreferredSize(new Dimension(775, 375));
        

        //Create content pane
        app newContentPane = new app();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        //Display window
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createGUI();
            }
        });
    }
}

//harry
