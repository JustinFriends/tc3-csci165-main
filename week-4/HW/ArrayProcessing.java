//Justin Friends
//CSCI 165 Java
//Homework due on 2/17/2020

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ArrayProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Problem 1.
		int[] numberList = new int[1000];
		
		fillArray(numberList);
		
		//Check for array properly filling.
		//for(int x = 0; x < 1000; x++) { 
		//System.out.println(numberList[x]);
		//}
		
		//Max num check.
		//System.out.println("The max number is: " + findMax(numberList));
		//Min num check.
		//System.out.println("The min number is: " + findMin(numberList));
		
		int[] percentChange = percentChange(numberList);
		
		//int ans = (8997 - 4096) * 100 / 8997;
		//System.out.println(percentChange[0]);
		
		
		//Problem 2.
		int[][] numberMatrix = new int[50][20];
		
		fillArray2(numberMatrix);
		
		//Check for array properly filling.
		/*for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 20; y++) {
				System.out.print(numberMatrix[x][y] + "   ");
			}
			System.out.println();
		}
		*/
		
		//Max num check.
		//System.out.println("The max number is: " + findMax2(numberMatrix));
		//Min num check.
		//System.out.println("The min number is: " + findMin2(numberMatrix));
		
		//Max row check.
		//System.out.println(findMaxOfRow(numberMatrix, 0));
		//Min row check.
		//System.out.println(findMinOfRow(numberMatrix, 0));
		
		//Max column check.
		//System.out.println(findMaxOfColumn(numberMatrix, 1));
		//Min column check.
		//System.out.println(findMinOfColumn(numberMatrix, 1));
		
		
		//Problem 3.
		int[][] numberMatrix2 = new int[50][20];
		
		fillArray3(numberMatrix2);
		
		//Check for array properly filling.
		/*for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 20; y++) {
				System.out.print(numberMatrix2[x][y] + "   ");
			}
			System.out.println();
		}
		*/
		
		//System.out.println((20 / 9) + (20 % 9));
		
		printRow(numberMatrix2, 1, 4);	//I can only get this to work for 20 % num_cols == 0, otherwise I get index out of bounds
										//error and I'm not sure how to fix it.
		smallestChange(numberMatrix2);
		
	}
	
	//Question #1.
	public static void fillArray(int[] array) {
		try {
			File fileNumbers = new File("number_list.txt");
			Scanner numberScanner = new Scanner(fileNumbers);
			
			while(numberScanner.hasNextInt()) {
				for(int x = 0; x < 1000; x++) {
					int input = numberScanner.nextInt();
					//System.out.println(input + "\n");
					array[x] = input;
					//System.out.println("Array: " + array[x]);
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
	
	public static int findMax(int[] array) {
		int max = array[0];
		
		for(int x = 0; x < 1000; x++) {
			if (max < array[x]) {
				max = array[x];
			}
		}
		
		return max;
	}
	
	public static int findMin(int[] array) {
		int min = array[0];
		
		for(int x = 0; x < 1000; x++) {
			if (min > array[x]) {
				min = array[x];
			}
		}
		
		return min;
	}
	
	public static int[] percentChange(int[] array) {
		int[] change = new int[1000];
		
		for(int x = 0; x < 1000 - 1; x++) {
			change[x] = (array[x] - array[x+1]) * 100 / (array[x]);
		}
		
		return change;
	}
	
	//Question #2.
	public static void fillArray2(int[][] matrix) {
		try {
			File fileNumbers = new File("number_list.txt");
			Scanner numberScanner = new Scanner(fileNumbers);
			
			while(numberScanner.hasNextInt()) {
				for(int x = 0; x < 50; x++) {
					for(int y = 0; y < 20; y++) {
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
	
	public static int findMax2(int[][] matrix) {
		int max = matrix[0][0];
		
		for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 20; y++) {
				if (max < matrix[x][y]) {
					max = matrix[x][y];
				}
			}
		}
		
		return max;
	}
	
	public static int findMin2(int[][] matrix) {
		int min = matrix[0][0];
		
		for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 20; y++) {
				if (min > matrix[x][y]) {
					min = matrix[x][y];
				}
			}
		}
		
		return min;
	}
	
	public static int findMaxOfRow(int[][] matrix, int row) {
		int max = matrix[0][0];
		
		for(int y = 0; y < 20; y++) {
			if(max < matrix[row][y]) {
				max = matrix[row][y];
			}
		}
		
		return max;
	}
	
	public static int findMinOfRow(int[][] matrix, int row) {
		int min = matrix[0][0];
		
		for(int y = 0; y < 20; y++) {
			if(min > matrix[row][y]) {
				min = matrix[row][y];
			}
		}
		
		return min;
	}
	
	public static int findMaxOfColumn(int[][] matrix, int column) {
		int max = matrix[0][0];
		
		for(int x = 0; x < 50; x++) {
			if(max < matrix[x][column]) {
				max = matrix[x][column];
			}
		}
		
		return max;
	}
	
	public static int findMinOfColumn(int[][] matrix, int column) {
		int min = matrix[0][0];
		
		for(int x = 0; x < 50; x++) {
			if(min > matrix[x][column]) {
				min = matrix[x][column];
			}
		}
		
		return min;
	}
	
	//Question #3.
	public static void fillArray3(int[][] matrix) {
		try {
			File fileNumbers = new File("number_list.txt");
			Scanner numberScanner = new Scanner(fileNumbers);
			
			while(numberScanner.hasNextInt()) {
				for(int y = 0; y < 20; y++) {
					for(int x = 0; x < 50; x++) {
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
	
	public static void printRow(int[][] matrix, int row, int num_cols) {
		int[][] printMatrix = new int[20 / num_cols][num_cols];
		int[] rowArray = new int [20];
		int counter = 0;
		
		for(int i = 0; i < 20; i++) {
			rowArray[i] = matrix[row][i];
		}
		
		for(int x = 0; x < (20 / num_cols) + (20 % num_cols); x++) {
			for(int y = 0; y < num_cols; y++) {
				printMatrix[x][y] = rowArray[counter];
				System.out.print(printMatrix[x][y] + "   ");
				counter++;
			}
			System.out.println();
		}
		
	}
	
	public static int smallestChange(int[][] matrix) {
		int smallestChangeRow = 0;
		int[] smallestChangeArray = new int[50];
		
		for(int x = 0; x < 50; x++) {
			int totalChange = 0;
			for(int y = 0; y < 20 - 1; y++) {
				int change = Math.abs(matrix[x][y]- matrix[x][y+1]);
				totalChange = totalChange + change;
			}
			
			smallestChangeArray[x]= totalChange; 
		}
			
		//for(int z = 0; z < 50; z++) {
		//	System.out.println(smallestChangeArray[z]);
		//}
		
		int min = smallestChangeArray[0];
		for(int p = 0; p < 50; p++) {
			if (min > smallestChangeArray[p]) {
				min = smallestChangeArray[p];
				smallestChangeRow = p;
			}
		}

		return smallestChangeRow;
	}
	
}
