package lab3.matrices;

import java.awt.image.Kernel;

public class Convolution {

Matrix kernel;
	
	public Convolution(Matrix kernel) {
		this.kernel = kernel;
	}

	public Matrix filter(Matrix image) {
	int rows = image.rows  - kernel.rows +1;
	int columns = image.columns - kernel.columns +1;
	int outputImage[][] = new int [rows][columns];
	for (int r = 0; r <rows; r++) {
		for (int c =0; c < rows; c++) {
			
			
			
			
		}
	}
		
	
		
			
			
		return new Matrix(outputImage);
	}

}
