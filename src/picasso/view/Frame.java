package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

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
 *@author Sylvia Agatako 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

    static JTextField t;
    static Action a;

    private List<String> expressionHistory = new ArrayList<>();
    private int historyPointer = -1;
    private JTabbedPane tabbedPane;// Create a tabbed pane for the canvas

    public Frame(Dimension size) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize tabbed pane
        tabbedPane = new JTabbedPane();

        // Add the first canvas
        addNewCanvas(size);

        // Create the command panel
        ButtonPanel commands = createCommandPanel(size);

        // Add tabbed pane and commands panel to the frame
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        getContentPane().add(commands, BorderLayout.NORTH);

        pack();
    }

    private ButtonPanel createCommandPanel(Dimension size) {
        ButtonPanel commands = new ButtonPanel(getCurrentCanvas());

        commands.add("Open", new Reader(this));
        commands.add("Evaluate", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputExpression = t.getText();
                if (!inputExpression.isEmpty()) {
                    expressionHistory.add(inputExpression);
                    historyPointer += 1;
                }
                Pixmap pixmap = getCurrentCanvas().getPixmap();
                new ThreadedCommand<>(getCurrentCanvas(), new Evaluator(Frame.this)).execute(pixmap);
            }
        });

        t = new JTextField(25);
        commands.add(t);
        commands.add("Save", new Writer());

        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputExpression = t.getText();

                if (!inputExpression.isEmpty()) {
                    expressionHistory.add(inputExpression);
                    historyPointer += 1;
                }
                Pixmap pixmap = getCurrentCanvas().getPixmap();

                new ThreadedCommand<>(getCurrentCanvas(), new Evaluator(Frame.this)).execute(pixmap);
            }
        });

        RandomExpressionGenerator generator = new RandomExpressionGenerator();
        commands.add("Random", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String randomExpression = generator.generateExpression("", 0);
                t.setText(randomExpression);
            }
        });

        t.addKeyListener(createKeyListener());
        commands.add("New Tab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewCanvas(size);
            }
        });

        return commands;
    }

    private KeyAdapter createKeyListener() {
        boolean isMac = System.getProperty("os.name").toLowerCase().contains("mac");

        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                boolean isModifierPressed = (isMac && e.isMetaDown()) || (!isMac && e.isControlDown());

                if (isModifierPressed && e.getKeyCode() == KeyEvent.VK_EQUALS) {
                    getCurrentCanvas().zoomIn(); // Zoom in
                    e.consume();
                } else if (isModifierPressed && e.getKeyCode() == KeyEvent.VK_MINUS) {
                    getCurrentCanvas().zoomOut(); // Zoom out
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

            @Override
            public void keyTyped(KeyEvent e) {
                boolean isModifierPressed = (isMac && e.isMetaDown()) || (!isMac && e.isControlDown());

                if (isModifierPressed && (e.getKeyChar() == '+' || e.getKeyChar() == '-')) {
                    e.consume();
                }
            }
        };
    }

    private void addNewCanvas(Dimension size) {
        Canvas newCanvas = new Canvas(this);
        newCanvas.setSize(size);
        tabbedPane.addTab("Canvas " + (tabbedPane.getTabCount() + 1), newCanvas);
        tabbedPane.setSelectedComponent(newCanvas);
        newCanvas.setFocusable(true);
        newCanvas.requestFocusInWindow();
    }

    private Canvas getCurrentCanvas() {
        return (Canvas) tabbedPane.getSelectedComponent();
    }

    public String getText() {
        return t.getText();
    }

    public JTextField getTextField() {
        return t;
    }
}

