package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
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
	
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader(this));
		
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator(this)));
		t = new JTextField(20);
		commands.add(t);
		commands.add("Save", new Writer());
		
		
		// runs once enter is pressed (need to fix function of actionPerformed()
		t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pixmap pixmap = canvas.getPixmap();
				
				new ThreadedCommand<>(canvas, new Evaluator(Frame.this)).execute(pixmap);;
				
		
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

