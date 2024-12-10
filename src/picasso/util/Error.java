package picasso.util;

import javax.swing.*;

import picasso.view.Frame;

//import java.awt.event.*;

public class Error{
	
	private Frame container;
	
	public Error(String s) {
		this.setContainer(container);
		JOptionPane.showMessageDialog(container, s);
	}

	public Frame getContainer() {
		return container;
	}
	public void setContainer(Frame container) {
		this.container = container;
	}
}
