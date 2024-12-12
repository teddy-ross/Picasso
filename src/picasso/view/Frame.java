package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.text.*;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 *@author Sanjog Basnet
 *@author Edward Ross
 *@author Sarina Cusumano
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

    static JTextField t;
    static Action a;

    private List<String> expressionHistory = new ArrayList<>();
    private int historyPointer = -1;

    public Frame(Dimension size) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create GUI components
        Canvas canvas = new Canvas(this);
        canvas.setSize(size);

        // add commands to test here
        ButtonPanel commands = new ButtonPanel(canvas);
        commands.add("Open", new Reader(this));

        commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator(this)));
        t = new JTextField(25);
        commands.add(t);
        commands.add("Save", new Writer());
        
        // Detect the operating system for zoom in and zoom out (control versus command)
        boolean isMac = System.getProperty("os.name").toLowerCase().contains("mac");
     
        // enter functionality
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputExpression = t.getText();

                if (!inputExpression.isEmpty()) {
                    expressionHistory.add(inputExpression);
                    historyPointer += 1;
                }
                Pixmap pixmap = canvas.getPixmap();

                new ThreadedCommand<>(canvas, new Evaluator(Frame.this)).execute(pixmap);
            }
        });
        
        //our two extensions, zoom in and out, and arrow keys for history
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                boolean isModifierPressed = (isMac && e.isMetaDown()) || (!isMac && e.isControlDown());

                if (isModifierPressed && e.getKeyCode() == KeyEvent.VK_EQUALS) {
                    canvas.zoomIn(); // Zoom in
                    e.consume();
                } else if (isModifierPressed && e.getKeyCode() == KeyEvent.VK_MINUS) {
                    canvas.zoomOut(); // Zoom out
                    e.consume();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    // Navigate expression history
                    if (historyPointer > 0) {
                        historyPointer--;
                        t.setText(expressionHistory.get(historyPointer));
                        e.consume();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    // Navigate expression history
                    if (historyPointer < expressionHistory.size() - 1) {
                        historyPointer++;
                        t.setText(expressionHistory.get(historyPointer));
                        e.consume();
                    } else if (historyPointer == expressionHistory.size() - 1) {
                        historyPointer = expressionHistory.size();
                        t.setText("");
                        e.consume();
                    }
                }
            }
            //fixes some silly plus and minus bugs
            @Override
            public void keyTyped(KeyEvent e) {
                boolean isModifierPressed = (isMac && e.isMetaDown()) || (!isMac && e.isControlDown());

                // Block typing of '+' or '-' when the modifier key is pressed (for zoom shortcuts)
                if (isModifierPressed && (e.getKeyChar() == '+' || e.getKeyChar() == '-')) {
                    e.consume();
                }
            }
        });

        canvas.setFocusable(true); // Ensure the canvas can receive key events
        canvas.requestFocusInWindow();

        // add our container to Frame and show it
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(commands, BorderLayout.NORTH);
        pack();
    }

    /**
     *
     * @param j JTextField
     * @return
     */
    public String getText() {
        return t.getText();
    }

    public JTextField getTextField() {
        return t;
    }
}
