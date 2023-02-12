package lab3.matrices;

/**
 * This class does all of the operations and returns the new matricies to 
 * be printed in main
 * Student Name: Rian Olson 
 * Student Number: 04107391
 * Course: CST8132 Object Oriented Programming 
 * Program: CET-CS-Level 2 
 * Professor: Fedor Ilitchev
 * due date: Feb 5, 2023
 *
 */
import java.lang.reflect.Array;
import java.util.Arrays;

public class Matrix {
	double[][] array;
	int rows;
	int columns;

	public Matrix(int rows, int cols) {
		this.array = new double[rows][cols];
		this.rows = rows;
		this.columns = cols;
	}

	public Matrix(double[][] array) {
		this.array = array;
		this.rows = array.length;
		this.columns = array[0].length;

		this.array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.array[i][j] = array[i][j];
			}
		}
	}

	public Matrix add(Matrix matrix) {
		double[][] array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = this.array[i][j] + matrix.array[i][j];

			}
		}

		return new Matrix(array);
	}

	public Matrix sub(Matrix matrix) {
		double[][] array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = this.array[i][j] - matrix.array[i][j];

			}
		}
		return new Matrix(array);

	}

	public Matrix mult(Matrix matrix) {
		double[][] array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = this.array[i][j] * matrix.array[i][j];

			}
		}
		return new Matrix(array);

	}

	public double sum() {
		double sum = 0d;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sum += this.array[i][j];
			}
		}
		return sum;
	}

	public Matrix subMatrix(int i, int j, int length, int width) {
		double[][] array = new double[length][width];
		for (int row = i; row < i + length; row++) {
			for (int column = j; column < j + width; column++) {
				array[row - i][column - j] = this.array[row][column];
			}
		}
		return new Matrix(array);

	}

	public String toString() {
		StringBuffer result = new StringBuffer();

		for (double[] row : array) {
			result.append(Arrays.toString(row));
			result.append('\n');
		}

		return result.toString();
	}

}
