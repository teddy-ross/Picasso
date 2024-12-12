package picasso.view;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import picasso.model.Pixmap;

/**
 * The canvas on which to present the image.
 * 
 * @author Robert Duvall (rcd@cs.duke.edu)
 *
 */
@SuppressWarnings("serial")
public class Canvas extends JPanel {

    /** keep track of the frame that contains this container */
    private JFrame myContainer;

    /** the pixel map of the displayed image */
    private Pixmap myPixmap;

    /** zoom scale factor */
    private double scale = 1.0;

    /**
     * 
     * @param container
     */
    public Canvas(JFrame container) {
        this(container, null);
    }

    /**
     * 
     * @param container
     * @param pixName
     */
    public Canvas(JFrame container, String pixName) {
        setBorder(BorderFactory.createLoweredBevelBorder());
        myContainer = container;
        myPixmap = new Pixmap(pixName);
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                myPixmap.setSize(getSize());
            }
        });
        refresh();
    }

    public Pixmap getPixmap() {
        return myPixmap;
    }

    public void refresh() {
        if (!myPixmap.getSize().equals(getSize())) {
            setSize(myPixmap.getSize());
            myContainer.setTitle(myPixmap.getName());
            myContainer.pack();
        }
        repaint();
    }

    public void zoomIn() {
        scale *= 1.1; // Increase scale by 10%
        refresh();    // Reapply size and trigger repaint
    }
    public void zoomOut() {
        scale *= 0.9; // Increase scale by -10%
        refresh();    // Reapply size and trigger repaint
    }

    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        Graphics2D g2 = (Graphics2D) pen;
        g2.scale(scale, scale); // Apply scaling for zoom effect
        myPixmap.paint(g2);     // Paint the pixmap with the scaled graphics context
    }

    public void setSize(Dimension size) {
        setPreferredSize(size);
        setMinimumSize(size);
        super.setSize(size);
    }
}
