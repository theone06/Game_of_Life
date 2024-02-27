package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameOfLife extends JFrame {
    //components
    JLabel GenerationLabel;
    JLabel AliveLabel;
    JButton restartButton;
    JToggleButton pauseButton;
    JPanel buttonPanel;
    CellPanel cellPanel;

   //variables
    Random rand = new Random();
    int size = 100;
    int seed = rand.nextInt();

    //constructor
    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Of Life");
        setName("GameOfLife");
        setSize(550, 500);
        initComponents();
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

    }

    private void initComponents()   {
       add(Box.createRigidArea(new Dimension(5,0)));
        GenerationLabel = new JLabel("Generation #" + 0);
        GenerationLabel.setName("GenerationLabel");
        GenerationLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(GenerationLabel);

        add(Box.createRigidArea(new Dimension(5,0)));
        AliveLabel = new JLabel("Alive: " + 0);
        AliveLabel.setName("AliveLabel");
        AliveLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(AliveLabel);

        cellPanel = new CellPanel(size, seed);
        cellPanel.setName("cellPanel");
        add(cellPanel);
        cellPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        buttonPanel = new JPanel();
        buttonPanel.setName("Button Panel");
        add(buttonPanel);

        pauseButton = new JToggleButton();
        pauseButton.setName("PlayToggleButton");
        pauseButton.setText("Pause");
        buttonPanel.add(pauseButton);
        pauseButton.addItemListener(item -> {
            if (pauseButton.isSelected()) {
                pauseButton.setText("Resume");
                cellPanel.tm.stop();
            } else {
                pauseButton.setText("Pause");
                cellPanel.tm.restart();
            }
        });

        restartButton = new JButton("Restart");
        restartButton.setName("ResetButton");
        buttonPanel.add(restartButton);
        restartButton.addActionListener(act -> {
            cellPanel.tm.stop();
            cellPanel.game.generateUniverse(size, rand.nextInt());
            cellPanel.counter = 0;
            AliveLabel.setText("Alive: " + 0);
            cellPanel.tm.start();
        });
    }


    public class CellPanel extends JPanel implements ActionListener {
        Timer tm = new Timer(1000, this);
        public int size = 0;
        public int seed;
        private int boxSize = 5;
        private int counter = 0;

        Universe game = new Universe();
        NextGeneration ng = new NextGeneration();

        CellPanel(int size, int seed) {
            this.size = size;
            this.seed = seed;
            game.generateUniverse(this.size, this.seed);
            tm.start();
        }
        public void paint(Graphics g)
        {
            int x = 0;
            int y = 0;
            super.paintComponent(g);

             g.setColor(Color.BLACK);
             game.displayUniverse();

            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    x = col * boxSize;
                    y = row * boxSize;
                    g.drawRect(x, y, boxSize, boxSize);
                    if (game.isAlive(row, col)) {
                        g.fillRect(x, y, boxSize, boxSize);
                    }
                }
            }
            GenerationLabel.setText("Generation #" + counter);
            AliveLabel.setText("Alive: " + game.numberAlive());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tm) {
                ng.updateUniverse(game, ng.nextGeneration(game));
                game.displayUniverse();
                repaint();
                counter++;


            }
        }
     }
}

