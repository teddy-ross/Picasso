package picasso.view.commands;

import javax.swing.JFileChooser;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.Frame;

/**
 * Open the chosen image file and display in the Pixmap target.
 * 
 * @author Robert C Duvall
 * 
 */
public class Reader extends FileCommand<Pixmap> {
	private Frame container; 
	

	/**
	 * Creates a Reader object, which prompts users for files to open
	 */
	public Reader(Frame container) {
		super(JFileChooser.OPEN_DIALOG); 
		this.container = container;
		setFileFilter(new FileNameExtensionFilter("Supported Files (Images, Expressions)", "jpg", "png", "bmp", "gif","exp"));
    }
	

	/**
	 * Displays the image file on the given target.
	 */
	public void execute(Pixmap target) {
		String fileName = getFileName();
		if (fileName != null) {
			if (fileName.endsWith(".exp")) {
                readExpFile(fileName, target);
            } else {
                target.read(fileName); // Existing image-reading functionality
            }
		}
	}
		//System.out.println("Selected file: " + fileName);

    /**
     * Reads the contents of a .exp file and stores it in the Pixmap as an expression.
     * 
     */
    private void readExpFile(String fileName, Pixmap target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder expressionBuilder = new StringBuilder();
            String line;
            boolean lineOne = true;
            
            while ((line = reader.readLine()) != null) {
            	// Since most of the exp files start with a comment, we want to skip the first line. 
            	if (lineOne && line.trim().startsWith("//")) {
                    lineOne = false; 
                    continue; // Skip line
                }
                expressionBuilder.append(line);
            }
            String expression = expressionBuilder.toString();
         //   System.out.println("This is the expression: " + expression);
            target.setExpression(expression); 
            container.getTextField().setText(expression); // Displays the string expression in the textbox
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

