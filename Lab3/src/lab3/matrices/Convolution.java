package lab3.matrices;

public class Convolution {

Matrix kernal;
	
	public Convolution(NamedMatrix kernel) {
		this.kernal = kernal;
	}

	public Object filter(Matrix outputImage) {
	
		
		return new Matrix(outputImage);
	}

}
