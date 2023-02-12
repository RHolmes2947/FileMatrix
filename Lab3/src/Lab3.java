/*
 * Student Name: Howard Rosenblum
 * Lab Professor: Professor Howard Rosenblum
 * Due Date: February 19, 2023
 * Description: Main of the image processing application
 */
package lab3;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import lab3.matrices.Convolution;
import lab3.matrices.FileMatrix;
import lab3.matrices.Matrix;
import lab3.matrices.NamedMatrix;

/**
 * This class provides the driver of the image processing 
 * application
 *
 * @author rosenbh
 *
 */
public class Lab3 {

	/**
	 * Fields
	 * Description: Kernels that can be used to do image 
	 * processing based on https://en.wikipedia.org/wiki/Kernel_(image_processing)
	 * 
	 * kernels Array of convolution kernels
	 */
	private NamedMatrix[] kernels = {
			new NamedMatrix("identity",new double[][]{
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
			}),

			new NamedMatrix("ridge",new double[][] {
				{-1, -1, -1},
				{-1,  8, -1},
				{-1, -1, -1}			
			}),

			new NamedMatrix("sharpen",new double[][] {
				{ 0, -1,  0},
				{-1,  5, -1},
				{ 0, -1,  0}			
			}),

			new NamedMatrix("unsharpen masking 5x5",new double[][] {
				{-1.0/256, -1.0/64,  -3.0/128, -1.0/64,  -1.0/256},
				{-1.0/64, -16.0/256, -3.0/64, -16.0/256, -1.0/64},
				{-3.0/128, -3.0/64, 119.0/64,  -3.0/64,  -6.0/256},
				{-1.0/64, -16.0/256, -3.0/64, -16.0/256, -1.0/64},
				{-1.0/256, -1.0/64,  -3.0/128, -1.0/64,  -1.0/256}
			}),			

			new NamedMatrix("laplace",new double[][] { // ridge + identity
				{-1, -1, -1},
				{-1,  9, -1},
				{-1, -1, -1}			
			})
	};

	/**
	 * Description: Method that opens a dialog box to load an image file
	 * @return The selected File. If the dialog box is canceled, a 
	 * non existent File is returned
	 */
	public File getImageFile()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		File file;
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			System.out.println("You chose to open this file: "+file.getAbsolutePath());
		} else {
			file = new File("noneExistent");
			System.out.println("No file chosen");
		}
		return file;
	}

	/**
	 * Description: Method that returns the selected kernel. 
	 * This method handled all invalid kernel selections 
	 * @return A NamedMatrix of the kernel
	 */
	public NamedMatrix getKernel()
	{
		/* To be done by student */

		// Display prompts and list of kernels
		
		// Get user input
		
		// Verify input is valid
		
		// Select kernel from input
		
		return null;
	}

	/**
	 * Description: Entry point for the application. Gets an 
	 * image file and selects kernel then applies filter to 
	 * the image and saves the file
	 * @param args Commandline parameters, not used
	 */
	public static void main(String[] args) {

		Lab3 lab3 = new Lab3();

		// Choose image file
		File imageFile = lab3.getImageFile();
		if(!imageFile.exists())
			return;

		// Choose kernel
		NamedMatrix kernel = lab3.getKernel();

		try {
			// Create filtered image using original image and kernal
			Matrix originalImage = new FileMatrix(imageFile);
			Convolution convolve = new Convolution(kernel);
			FileMatrix filteredImage = new FileMatrix(convolve.filter(originalImage));

			// Save filtered image in a file named:
			//    "image file name" "-" "kernel name" "." "image file extension"
			String fileName = imageFile.getAbsolutePath();
			int dot = fileName.indexOf('.');
			String output = fileName.substring(0,dot)+"-"+kernel.getName()+fileName.substring(dot);
			File outputFile = new File(output);
			if(filteredImage.save(outputFile))
				System.out.println("File: "+output+" succesfully written");
			else
				System.out.println("Could not write file: "+output);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find file: "+imageFile.getAbsolutePath());
		}

	}

}
