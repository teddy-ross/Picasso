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
 *
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
		
		
		// runs once enter is pressed (need to fix function of actionPerformed()
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputExpression = t.getText();
				
				if (!inputExpression.isEmpty()) {
					expressionHistory.add(inputExpression);
					historyPointer += 1;
					
				}
				Pixmap pixmap = canvas.getPixmap();
				
				new ThreadedCommand<>(canvas, new Evaluator(Frame.this)).execute(pixmap);;
				
		
			}
		});
		
		//Add key listener to allow user to cycle through the expression history in the current session with Up and Down arrow keys
        t.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    // Move up 
                    if (historyPointer > 0) {
                        historyPointer--;
                        t.setText(expressionHistory.get(historyPointer));
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    // Move down 
                    if (historyPointer < expressionHistory.size() - 1) {
                        historyPointer++;
                        t.setText(expressionHistory.get(historyPointer));
                    } else if (historyPointer == expressionHistory.size() - 1) {
                        historyPointer = expressionHistory.size();  // Reset to the empty state
                        t.setText("");
                    }
                }
            }
        });
		
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

