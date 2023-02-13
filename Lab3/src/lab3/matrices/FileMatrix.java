package lab3.matrices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class FileMatrix {


	public FileMatrix(Scanner input) {
		Scanner in = new Scanner(System.in);
	}

	public FileMatrix(File file) throws FileNotFoundException {
		this(new Scanner(file));
	
	}


	public FileMatrix (Matrix matrix) {
	this(new Scanner(matrix));
	}
	
	
	public boolean save(File outputFile) throws FileNotFoundException {
		// Just have to make a method to save a matrix file to a text file now
		
		  Reader file = new FileReader(file);
		  BufferedReader reader = new BufferedReader(file);
		return false;
		
	}

}
