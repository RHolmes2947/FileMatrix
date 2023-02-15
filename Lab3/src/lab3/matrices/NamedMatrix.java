package lab3.matrices;

public class NamedMatrix extends Matrix {

	// instance variable
	String Name;

	// Constructor to create a matrix and to input a 2d array
	public NamedMatrix(String name, double[][] array) {
		super(array);
		this.Name = name;
	}

	// getter for name
	public String getName() {
		return Name;
	}

}
