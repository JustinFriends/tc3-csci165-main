import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PointsEx extends JFrame {

	    public PointsEx() {

	        initUI();
	    }

	    private void initUI() {

	        final Surface surface = new Surface();
	        add(surface);

	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                Timer timer = surface.getTimer();
	                timer.stop();
	            }
	        });

	        setTitle("A day in the Mushroom Kingdom");
	        setSize(Surface.NUM_OF_ROWS + 22, Surface.NUM_OF_COLS + 45);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    
	}
