package lab3.matrices;

import java.io.File;
import java.io.FileNotFoundException;
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
	
	
	public boolean save(File outputFile) {
		// Just have to make a method to save a matrix file to a text file now
		return false;
	}

}
