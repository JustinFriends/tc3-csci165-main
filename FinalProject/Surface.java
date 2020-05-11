import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class  Surface extends JPanel implements ActionListener{

	private final int DELAY = 1000;
	final static int NUM_OF_ROWS = 350;
	final static int NUM_OF_COLS = 250;
	final static int NUM_OF_ENEMY_SETS = 60;
	final static int NUM_OF_MUSHROOMS = 20;
	final static int NUM_OF_STARS = 20;
	
    private Timer timer;
    
    ArrayList<Creature> creatureList = new ArrayList<Creature>();
    ArrayList<Item> itemList = new ArrayList<Item>();

    public Surface() {

        initTimer();
        
    	
    	creatureList.add(new Mario(NUM_OF_ROWS, NUM_OF_COLS));
    	creatureList.add(new Luigi(NUM_OF_ROWS, NUM_OF_COLS));
    	creatureList.add(new Toad(NUM_OF_ROWS, NUM_OF_COLS));
    	creatureList.add(new Peach(NUM_OF_ROWS, NUM_OF_COLS));
    	
    	for (int i = 0; i < NUM_OF_ENEMY_SETS; i++) {
    		creatureList.add(new Goomba(NUM_OF_ROWS, NUM_OF_COLS));
        	creatureList.add(new KoopaTroopa(NUM_OF_ROWS, NUM_OF_COLS));
        	creatureList.add(new PiranhaPlant(NUM_OF_ROWS, NUM_OF_COLS));
    	}
    	
    	for (int i = 0; i < NUM_OF_MUSHROOMS; i++) {
    		itemList.add(new Mushroom(NUM_OF_ROWS, NUM_OF_COLS));
    	}
    	
    	for (int i = 0; i < NUM_OF_STARS; i++) {
    		itemList.add(new Star(NUM_OF_ROWS, NUM_OF_COLS));
    	}
    	
    	assignLocationsCreatures(NUM_OF_ROWS, NUM_OF_COLS, creatureList);
    	assignLocationsItems(NUM_OF_ROWS, NUM_OF_COLS, itemList);
    	
    	//creatureList.get(0).setPositionX(100);
    	//creatureList.get(0).setPositionY(0);
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public Timer getTimer() {
        
        return timer;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        /*g2d.setPaint(Color.red);

        int w = getWidth();
        int h = getHeight();

        Random r = new Random();

        for (int i = 0; i < 2000; i++) {

            int x = Math.abs(r.nextInt()) % w;
            int y = Math.abs(r.nextInt()) % h;
            g2d.drawLine(x, y, x, y);
        } */
		
		for (Creature creature : creatureList) {
			if (creature.getAliveFlag() == true){
				//creature.move();
				//creature.attack(new Goomba());
				creature.observe(creature.neighborhoodCheck(creatureList), creature.itemWorldCheck(itemList));
				g2d.setColor(new Color(creature.getColor()[0], creature.getColor()[1], creature.getColor()[2]));
				g2d.fillRect(creature.getPositionX(), creature.getPositionY(), 5, 5);
				if (creature.getEquippedItem() instanceof Star) {
					g2d.fillOval(creature.getPositionX(), creature.getPositionY(), 3, 3);
				}
				System.out.println(creature.toString());
			}
		}
		
		for (Item item : itemList) {
			if (item.getAliveFlag() == true) {
				if (item.getPickedUpFlag() == false) {
					if (item instanceof Star) {
						g2d.setColor(new Color(item.getColor()[0], item.getColor()[1], item.getColor()[2]));
						g2d.fillOval(item.getPositionX(), item.getPositionY(), 5, 5);
					}
					else if (item instanceof Mushroom) {
						g2d.setColor(new Color(item.getColor()[0], item.getColor()[1], item.getColor()[2]));
						g2d.fillOval(item.getPositionX(), item.getPositionY(), 5, 5);
					}
					
				}  //Checks if item is picked up or not.
				
			}  //Checks if item is alive, or 'valid'.
		}
        
    }

	    @Override
	    public void paintComponent(Graphics g) {

	        super.paintComponent(g);
	        doDrawing(g);
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        repaint();
	    }
	    
	    //Assigns locations, x and y, to creatures in the passed array based on the numbers of rows and columns of the arena.
		public void assignLocationsCreatures(int maxNumRows, int maxNumCols, ArrayList<Creature> creatureList) {
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
		
		//Assigns locations, x and y, to items in the passed array based on the numbers of rows and columns of the arena.
				public void assignLocationsItems(int maxNumRows, int maxNumCols, ArrayList<Item> itemList) {
					Random random = new Random();
					
					for (Item item : itemList) {
						item.setPositionX(random.nextInt(maxNumRows));
						item.setPositionY(random.nextInt(maxNumCols));
						/*for (int i = 0; i < creatureList.size(); i++) {
							 while(creature.getPositionX() == creatureList.get(i).getPositionX() && creature.getPositionY() == creatureList.get(i).getPositionY()) {
								 creature.setPositionX(random.nextInt(maxNumRows));
								 creature.setPositionY(random.nextInt(maxNumCols));
							 }//Ending while loop.
						}//Ending for loop. */
					} //Ending for each loop.
					
				}
	    
}
