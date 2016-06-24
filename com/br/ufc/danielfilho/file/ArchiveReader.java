package com.br.ufc.danielfilho.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.br.ufc.danielfilho.exceptions.InvalidFileException;

public class ArchiveReader {
	private JFileChooser fileChooser;

	public ArchiveReader() {
		this.fileChooser = new JFileChooser();
	}
	
	public FileProperties showAndReadFileSync(){
		int returnVal = fileChooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			
			File file = fileChooser.getSelectedFile();
			
			return readFileSync(file);
		}else{
			JOptionPane.showMessageDialog(null, "Operation canceled!");
			return null;
		}
	}
	
	private FileProperties readFileSync(File file){
		try{
			FileProperties properties = new FileProperties();
			
			BufferedReader bRead = new BufferedReader(new FileReader(file));
		
			readFirstFileParameters(bRead, properties);
			
			properties.setMatA(readMatrixA(bRead, properties));
			
			properties.setVectB(readVectB(bRead, properties));
			
			return properties;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	private float[][] readMatrixA(BufferedReader bRead, FileProperties properties) throws InvalidFileException, IOException{
		//Reading Matrix A
		int n = (int)properties.getCountRows();
		float [][] matX = new float[n][n];
		
		String line;
		
		int numberOfLines = 0;
		for(int i = 0; i < matX.length; i++){
			if((line = bRead.readLine()) != null){
				matX[i] = stringToFloatArray(line, matX.length, i);
				numberOfLines++;
			}else{
				break;
			}
		}
		if(numberOfLines != n)
			throw new InvalidFileException(InvalidFileException.MAT_A_DIFF_N);
		
		return matX;
	}
	
	private float[] readVectB(BufferedReader bRead, FileProperties properties) throws InvalidFileException, IOException{
		int n = (int) properties.getCountRows();
		float[] vectB = new float[n];
		
		String line;
		int numberOfElements = 0;
		for(int i = 0; i < vectB.length; i++){
			if((line = bRead.readLine()) != null){
				String[] number = line.split(" ");
				if(number.length > 1)
					throw new InvalidFileException(InvalidFileException.VECT_B_ONE_COLUMN);
				
				vectB[i] = Float.parseFloat(line);
				
				numberOfElements++;
				
			}else{
				break;
			}
		}
		if(numberOfElements != n)
			throw new InvalidFileException(InvalidFileException.VECT_B_DIFF_N);
		
		return vectB;
	}
	
	private float[] stringToFloatArray(String row, int n, int indexDiagonal) throws InvalidFileException{
		if(row == null || row.length() == 0)
			return null;
		
		float[] numbers = new float[n];
		String[] vecString = row.split(" ");
		
		//Checking if number of main diagonal is equal to 0
		float numberDiagonal = Float.parseFloat(vecString[indexDiagonal]);
		if(numberDiagonal == 0)
			throw new InvalidFileException(InvalidFileException.INVALID_MAIN_DIAGONAL);
		
		for(int i = 0; i < numbers.length; i++){
			float num = Float.parseFloat(vecString[i]);
			numbers[i] = num;
		}
		return numbers;
	}
	
	private void readFirstFileParameters(BufferedReader bRead, FileProperties properties) throws InvalidFileException, IOException{
		//Getting N
		String line = bRead.readLine();
		properties.setCountRows(line);
		
		//Getting Count Proccesses 
		line = bRead.readLine();
		properties.setCountProcesses(line);
		
		//Getting Count Threads
		line = bRead.readLine();
		properties.setCountThreads(line);
		
		//Getting verification row
		line = bRead.readLine();
		properties.setVerification(line);
		
		//Getting max interations
		line = bRead.readLine();
		properties.setInterations(line);
	}
	
}
