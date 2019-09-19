/**
 * The mission of Control are create element of the board game by algorithms, calculating, and testing 
 */
import java.io.*;
import java.util.Scanner;
public class Control {

	private String[][] board;
	final private int NUM_ROW = 9;
	final private int NUM_COL = 9;
	
	/**
	 * The Control constuctor init the board
	 * @throws FileNotFoundException 
	 */
	Control() throws FileNotFoundException{ 
		board = new String[NUM_ROW][NUM_COL];
		accessData();
	}
	
	public void accessData() throws FileNotFoundException {
		File data = new File("1.txt");
		 Scanner in = new Scanner(data);
	     for (int row= 0; row <NUM_COL;row++)
		{
			
			for (int col = 0; col<NUM_ROW; col++)
			{
				board[col][row] = in.next();
			
		}
		}
	}
	
	private int[] getSectionStartPoint(int section) {
		int[] temp =new int[2]; 
		switch(section) {
		case 1: 
			temp[0] = 0;
			temp[1] = 0;
			break;
		case 2:
			temp[0] = 3;
			temp[1] = 0;
			break;
		case 3:
			temp[0] = 6;
			temp[1] = 0;
			break;
		case 4:
			temp[0] = 0;
			temp[1] = 3;
			break;
		case 5:
			temp[0] = 3;
			temp[1] = 3;
			break;
		case 6:
			temp[0] = 6;
			temp[1] = 3;
			break;
		case 7:
			temp[0] = 0;
			temp[1] = 6;
			break;
		case 8:
			temp[0] = 3;
			temp[1] = 6;
			break;
		case 9:
			temp[0] = 6;
			temp[1] = 6;
			break;
		}
		return temp;	
	}
	

	private boolean testSection(int numOfSection, int value) {
		boolean test = false;
		int[] temp = getSectionStartPoint(numOfSection);
		int rowRange = temp[1]+3;
		int colRange = temp[0]+3;
		for (int row= temp[1]; row <rowRange;row++)
		{
			for (int col = temp[0]; col<colRange; col++){
				if(board[col][row]==Integer.toString(value)) {
					test = true;
					break;
				}
			}
		}
		return test;
	}
	private boolean testRow(int numOfRow, int value) {
		boolean test = false;
		for (int x=0 ; x < NUM_COL;x++)
		{
			if(board[x][numOfRow] == Integer.toString(value)) {
				test = true;
				break;
			}
		}
		return test;
	}
	
	private boolean testCol(int numOfCol, int value){
		boolean test = false;
		for (int x=0 ; x < NUM_ROW;x++)
		{
			if(board[numOfCol][x] == Integer.toString(value)) {
				test = true;
				break;
			}
		}
		return test;
	}
	

	
	
	public boolean sectionTest(int numOfSection, int value) {
		return testSection(numOfSection,value);
	}
	public boolean rowTest(int numOfRow, int value)
	{
		return testRow(numOfRow,value);
	}
	public boolean colTest(int numOfCol, int value)
	{
		return testCol(numOfCol,value);
	}
	
	
	public void printOutput() {
		
		for (int col= 0; col <NUM_COL;col++)
		{
			int temp = 0;
			for (int row = 0; row<NUM_ROW; row++)
			{
				if (temp == NUM_ROW-1)
				{
				System.out.print(board[row][col]);
				 System.out.println();
				}
				else {
					System.out.print(board[row][col]+ " ");
					temp+=1;
				}
			}
		}
	}
}
