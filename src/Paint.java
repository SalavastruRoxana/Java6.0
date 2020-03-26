import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Paint extends JFrame implements MouseMotionListener, ActionListener {
    private int x, y; //coord mouse
    private int width = 1,height = 1; //dimensiunea by default pe care o sa o schimb prin butoane

    public Paint()
    {
        setTitle("Paint");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //INCHIDEM CU BUTONELUL, SPER
        // pun butoane
        /*
        JButton button1 = new JButton("click here");
        JPanel panel = new JPanel();
        panel.add(button1);
        this.getContentPane().add(panel);
         */
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,4));

        JButton dim1 = new JButton("dimension 1");
        dim1.setBackground(Color.red);
        JButton dim2 = new JButton("dimension 2");
        dim2.setBackground(Color.blue);
        JButton dim3 = new JButton("dimension 3");
        dim3.setBackground(Color.pink);
        JButton dim4 = new JButton("dimension 4");
        dim4.setBackground(Color.yellow);

        panel.add(dim1);
        panel.add(dim2);
        panel.add(dim3);
        panel.add(dim4);

        dim1.addActionListener(this);
        dim2.addActionListener(this);
        dim3.addActionListener(this);
        dim4.addActionListener(this);

        JLabel instructiuni = new JLabel("Folosim mouseul pt a pozitiona figuri", JLabel.RIGHT);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(instructiuni,BorderLayout.SOUTH);
        container.add(panel, BorderLayout.NORTH);

        //acum mouseul
        container.addMouseMotionListener(this); //s-ar putea ca asta sa nu functioneze pentru ca asculta si cand trag de cursor on click
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX()-10;//nu stiu de ce sunt decalate
        y = e.getY()-10;//nu stiu de ce sunt decalate
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        /*x = e.getX();
        y = e.getY();
        repaint();*/
    }

    public void paint(Graphics g)
    {
        g.fillRect(x,y,width,height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
