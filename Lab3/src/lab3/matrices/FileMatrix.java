package lab3.matrices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class FileMatrix extends Matrix {

//importing scanner for other constructors to use
	public FileMatrix(Scanner input) {
		super(input.nextInt(), input.nextInt());
	}

// creating a file matrix from a file
	public FileMatrix(File file) throws FileNotFoundException {
		this(new Scanner(file));

	}

// creating a fileMatrix from an existing file
	public FileMatrix(Matrix matrix) {
		super(matrix.columns, matrix.rows);
	}

// method to save a matrix to a text file
	public boolean save(File outputFile) throws FileNotFoundException {
		int[][] matrix = null;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					bw.write(matrix[i][j] + ",");
				}
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
		}
		return outputFile != null;

	}

}
