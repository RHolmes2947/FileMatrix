package lab3.matrices;

import java.awt.image.Kernel;

public class Convolution {

	// instance variable
	Matrix kernel;

	// making a kernel matrix to be used in calculation
	public Convolution(Matrix kernel) {
		this.kernel = kernel;
	}

// method to do the actual convolution calculation
	public Matrix filter(Matrix image) {
		int rows = image.rows - kernel.rows + 1;
		int columns = image.columns - kernel.columns + 1;
		double[][] outputImage = new double[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < rows; c++) {
				Matrix sub = image.subMatrix(rows, columns, r, c);
				for (int row = r; rows < r + kernel.rows; row++) {
					for (int column = c; column < c + kernel.columns; column++) {
						outputImage[r][c] = kernel.sum();
					}
				}
			}
		}

		return new Matrix(outputImage);
	}

}
