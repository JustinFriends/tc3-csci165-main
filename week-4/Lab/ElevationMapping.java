//Justin Friends
//CSCI 165 Java
//Lab Week 4 Elevation Mapping

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.io.File;
import java.io.FileNotFoundException;

class ElevationMapping extends JPanel {

	private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();
    private String fileName;
	
    public ElevationMapping(String file) {
        initUI(file);
        
        fileName = file;
    }

    private void initUI(String file) {    	
        window.add(this);
        window.setTitle(file);
        window.setSize(500, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;
        
        int pos1 = 0, pos2 = 0, pos3 = 0;
               
        pos1 = fileName.indexOf("_");
        pos2 = fileName.indexOf("x");
        pos3 = fileName.indexOf(".");
        
        //String locationName = fileName.substring(0, pos1);
        final int NUM_OF_COLS = Integer.parseInt(fileName.substring(pos1 + 1, pos2));
        final int NUM_OF_ROWS = Integer.parseInt(fileName.substring(pos2 + 1, pos3));
        
        int[][] mapMatrix = new int[NUM_OF_ROWS][NUM_OF_COLS];
        int[] smallestRow = new int[NUM_OF_COLS];
        
        fillArray(mapMatrix, fileName, NUM_OF_ROWS, NUM_OF_COLS);
        
        int max = findMax(mapMatrix, NUM_OF_ROWS, NUM_OF_COLS);
        int min = findMin(mapMatrix, NUM_OF_ROWS, NUM_OF_COLS);
        
        for(int x = 0; x < NUM_OF_ROWS; x++){
        	for(int y = 0; y < NUM_OF_COLS; y++) {
        		int color = calculateColor(min, max, mapMatrix[x][y]);
        		g2d.setColor(new Color(color, color, color));
        		g2d.fillRect(y, x, 1, 1);
     
        	}
        } // loop for generating terrain map.
        	
        	for(int j = 0; j < NUM_OF_ROWS; j++) {
	        	int currentRow = j, currentCol, totalChange = 0;
	        		        	
		        for(int i = 0; i < NUM_OF_COLS - 1; i++) {
		        	currentCol = i;
		        	int[] smallestChange = new int[] {99999, 99999, 99999};
		        	if((currentRow + 1) > (NUM_OF_ROWS - 1)) {
		        		smallestChange[1] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow][currentCol + 1]);
			        	smallestChange[2] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow - 1][currentCol + 1]);			        		
		        	}
		        	else if((currentRow - 1) < 0){
		        		smallestChange[0] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow + 1][currentCol + 1]);
			        	smallestChange[1] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow][currentCol + 1]);			        		
		        	}
		        	else {
			        	smallestChange[0] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow + 1][currentCol + 1]);  
			        	smallestChange[1] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow][currentCol + 1]);
			        	smallestChange[2] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow - 1][currentCol + 1]);
		        	}
		        	
		        	int smallest = smallestChange[1];
			        	
		        	for(int p = 0; p < 3; p++) {
		    			if (smallest > smallestChange[p]) {
		    				smallest = smallestChange[p];
		    			}
		    		}	
			        
		        	if(smallestChange[0] == smallestChange[2]) {
		        		Random random = new Random();
		        		int ranNum = random.nextInt(3);
		        		if(ranNum == 1) {
		        			g2d.setColor(new Color(32, 178, 170));
			        		g2d.fillRect(currentCol + 1, currentRow + 1, 1, 1);
			        		currentRow++;
			        		totalChange = totalChange + smallest;
		        		}
		        		else {
		        			g2d.setColor(new Color(32, 178, 170));
			        		g2d.fillRect(currentCol + 1, currentRow - 1, 1, 1);
			        		currentRow--;
			        		totalChange = totalChange + smallest;
		        		}
		        	}
		        	else if(smallest == smallestChange[0]) {		        		
		           		g2d.setColor(new Color(32, 178, 170));
		        		g2d.fillRect(currentCol + 1, currentRow + 1, 1, 1);
		        		currentRow++;
		        		totalChange = totalChange + smallest;
		        	}			        	
		        	else if(smallest == smallestChange[1]) {		        		
		           		g2d.setColor(new Color(32, 178, 170));
		        		g2d.fillRect(currentCol + 1, currentRow, 1, 1);
		        		totalChange = totalChange + smallest;
		        	}			        	
		        	else if(smallest == smallestChange[2]) {		        		
		           		g2d.setColor(new Color(32, 178, 170));
		        		g2d.fillRect(currentCol + 1, currentRow - 1, 1, 1);
		        		currentRow--;
		        		totalChange = totalChange + smallest;
		        	}			        	
		        }// inner loop for drawing paths.
			        smallestRow[j] = totalChange;
        	}// outer loop for drawing paths.
        
        	int bestPath = smallestRowChecker(smallestRow, NUM_OF_ROWS);
        	
        	int currentRow = bestPath, currentCol, totalChange = 0;
        	
	        for(int i = 0; i < NUM_OF_COLS - 1; i++) {
	        	currentCol = i;
	        	int[] smallestChange = new int[] {99999, 99999, 99999};
	        	if((currentRow + 1) > (NUM_OF_ROWS - 1)) {
	        		smallestChange[1] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow][currentCol + 1]);
		        	smallestChange[2] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow - 1][currentCol + 1]);			        		
	        	}
	        	else if((currentRow - 1) < 0){
	        		smallestChange[0] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow + 1][currentCol + 1]);
		        	smallestChange[1] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow][currentCol + 1]);			        		
	        	}
	        	else {
		        	smallestChange[0] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow + 1][currentCol + 1]);  
		        	smallestChange[1] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow][currentCol + 1]);
		        	smallestChange[2] = Math.abs(mapMatrix[currentRow][currentCol] - mapMatrix[currentRow - 1][currentCol + 1]);
	        	}
	        	
	        	int smallest = smallestChange[1];
		        	
	        	for(int p = 0; p < 3; p++) {
	    			if (smallest > smallestChange[p]) {
	    				smallest = smallestChange[p];
	    			}
	    		}	
		        
	        	if(smallestChange[0] == smallestChange[2]) {
	        		Random random = new Random();
	        		int ranNum = random.nextInt(3);
	        		if(ranNum == 1) {
	        			g2d.setColor(new Color(30,144,255));
		        		g2d.fillRect(currentCol + 1, currentRow + 1, 1, 1);
		        		currentRow++;
		        		totalChange = totalChange + smallest;
	        		}
	        		else {
	        			g2d.setColor(new Color(30,144,255));
		        		g2d.fillRect(currentCol + 1, currentRow - 1, 1, 1);
		        		currentRow--;
		        		totalChange = totalChange + smallest;
	        		}
	        	}
	        	else if(smallest == smallestChange[0]) {		        		
	           		g2d.setColor(new Color(30,144,255));
	        		g2d.fillRect(currentCol + 1, currentRow + 1, 1, 1);
	        		currentRow++;
	        		totalChange = totalChange + smallest;
	        	}			        	
	        	else if(smallest == smallestChange[1]) {		        		
	           		g2d.setColor(new Color(30,144,255));
	        		g2d.fillRect(currentCol + 1, currentRow, 1, 1);
	        		totalChange = totalChange + smallest;
	        	}			        	
	        	else if(smallest == smallestChange[2]) {		        		
	           		g2d.setColor(new Color(30,144,255));
	        		g2d.fillRect(currentCol + 1, currentRow - 1, 1, 1);
	        		currentRow--;
	        		totalChange = totalChange + smallest;
	        	}			        	
	        }

        /*g2d.setColor(Color.RED);
        Random random = new Random();
        for(int i = 0; i < 2000; i++){
            x = Math.abs(random.nextInt()) % width;
            y = Math.abs(random.nextInt()) % height;
            g2d.drawLine(x, y, x + 2, y + 2);
        }
        */
    }
    public static void main(String[] args) {
        
        String file = args[0];
        //System.out.println(args[0]);
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                ElevationMapping ex = new ElevationMapping(file);
                ex.setVisible(true);
            }            
        });
        
    } // end main
    
    public static void fillArray(int[][] matrix, String file, int rows, int cols) {
		try {
			File fileNumbers = new File(file);
			Scanner numberScanner = new Scanner(fileNumbers);
			
			while(numberScanner.hasNextInt()) {
				for(int x = 0; x < rows; x++) {
					for(int y = 0; y < cols; y++) {
					int input = numberScanner.nextInt();
					//System.out.println(input + "\n");
					matrix[x][y] = input;
					//System.out.println("Matrix at " +  x + " and " +  y + " is: " + matrix[x][y]);
					}
				}
			}
			
			numberScanner.close();
		}
		catch (NumberFormatException nfe) {
            System.out.println("You didn't enter a number.");
		}
		catch (FileNotFoundException fnf){
            System.out.println("File was not found.");
        }
		
	}
    
    public static int findMax(int[][] matrix, int rows, int cols) {
		int max = matrix[0][0];
		
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				if (max < matrix[x][y]) {
					max = matrix[x][y];
				}
			}
		}
		
		return max;
	}
    
    public static int findMin(int[][] matrix, int rows, int cols) {
		int min = matrix[0][0];
		
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				if (min > matrix[x][y]) {
					min = matrix[x][y];
				}
			}
		}
		
		return min;
	}
    
    public static int calculateColor(int min, int max, int value) {
    	int color = 0;
    	
    	color = ((value - min) * 255) / (max - min);
    	
    	return color;
    }
    
    public static void calculatePath(int row) {
    	
    }
    
    public static int smallestRowChecker(int[] smallestRow, int NUM_OF_COLS) {
    	int smallestChangeRow = 0;
    	
    	int min = smallestRow[0];
		for(int q = 0; q < NUM_OF_COLS; q++) {
			if (min > smallestRow[q]) {
				min = smallestRow[q];
				smallestChangeRow = q;
			}
		}
    	
    	return smallestChangeRow;
    }
    
	//public static void drawPaths() {
		
	//}
    
} // end class
