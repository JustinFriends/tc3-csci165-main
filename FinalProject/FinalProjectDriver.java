import java.util.ArrayList;
import java.util.Random;
import java.awt.EventQueue;
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

public class FinalProjectDriver {
	
	//final static int NUM_OF_ROWS = 100;
	//final static int NUM_OF_COLS = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                PointsEx ex = new PointsEx();
                ex.setVisible(true);
            }
        });
		
	}
	
	//Assigns locations, x and y, to creatures in the passed array based on the numbers of rows and columns of the arena.
	public static void assignLocations(int maxNumRows, int maxNumCols, ArrayList<Creature> creatureList) {
		Random random = new Random();
		
		for (Creature creature : creatureList) {
			creature.setPositionX(random.nextInt(maxNumRows));
			creature.setPositionY(random.nextInt(maxNumCols));
			/*for (int i = 0; i < creatureList.size(); i++) {
				 while(creature.getPositionX() == creatureList.get(i).getPositionX() && creature.getPositionY() == creatureList.get(i).getPositionY()) {
					 creature.setPositionX(random.nextInt(maxNumRows));
					 creature.setPositionY(random.nextInt(maxNumCols));
				 }//Ending while loop.
			}//Ending for loop. */
		} //Ending for each loop.
		
	} 
	
	/*public static class Surface extends JPanel {

	    private void doDrawing(Graphics g) {

	        Graphics2D g2d = (Graphics2D) g;
	        //g2d.drawString("Java 2D", 50, 50);
	        
	        for(int x = 0; x < NUM_OF_ROWS; x++){
	        	for(int y = 0; y < NUM_OF_COLS; y++) {
	        		g2d.setColor(new Color(211, 211, 211));
	        		g2d.drawRect(x, y, 25, 25);
	        	}
	        }
	        
	        //g2d.drawRect()
	        
	    }

	    @Override
	    public void paintComponent(Graphics g) {

	        super.paintComponent(g);
	        doDrawing(g);
	    }
	} */
	
	/*public static class BasicEx extends JFrame {

	    public BasicEx() {

	        initUI();
	    }

	    private void initUI() {

	        add(new Surface());

	        setTitle("A day in the Mushroom Kingdom");
	        setSize(NUM_OF_ROWS, NUM_OF_COLS);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	   
	} */
	


}
