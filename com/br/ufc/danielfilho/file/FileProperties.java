package com.br.ufc.danielfilho.file;

import com.br.ufc.danielfilho.exceptions.InvalidFileException;


public class FileProperties {
	
	public static final float MIN_COUNT_ROWS = 3;
	public static final float MAX_COUNT_ROWS = 10000;
	
	public static final float MIN_COUNT_PROCESS = 1;
	public static final float MAX_COUNT_PROCESS = 100;
	
	public static final float MIN_COUNT_THREADS = 1;
	public static final float MAX_COUNT_THREADS = 100;
	
	public static final float MIN_COUNT_INTERATIONS = 1;
	public static final float MAX_COUNT_INTERATIONS = 10000;
	
	public static final float MIN_ROW_VERIFICATION = 1;
	public static final float MAX_ROW_VERIFICATION = MAX_COUNT_ROWS;
	
	
	private float tolerance = (float) 0.001;
	
	private float countRows;
	private float countProccesses;
	private float countThreads;
	private float verification;
	private float interations;
	
	private float[][] matA;
	private float[] vectB;
	
	
	public FileProperties(float countRows, float countProccesses, float countThreads,
			float verification, float interations) {
		this.countRows = countRows;
		this.countProccesses = countProccesses;
		this.countThreads = countThreads;
		this.verification = verification;
		this.interations = interations;
	}

	public FileProperties() {
		super();
	}

	public float getCountRows() {
		return countRows;
	}

	public void setCountRows(String countRowsS) throws InvalidFileException {
		if(countRowsS == null)
			throw new InvalidFileException(InvalidFileException.INVALID_N);
		
		float param = Float.parseFloat(countRowsS);
		if(param < MIN_COUNT_ROWS || param > MAX_COUNT_ROWS) 
			throw new InvalidFileException(InvalidFileException.INVALID_N);
		else{
			this.countRows = param;	
		}
	}

	public float getCountProcesses() {
		return countProccesses;
	}

	public void setCountProcesses(String countProcessesS) throws InvalidFileException {
		if(countProcessesS == null)
			throw new InvalidFileException(InvalidFileException.INVALID_COUNT_PROCCESSES);
		
		float param = Float.parseFloat(countProcessesS);
		if(param < MIN_COUNT_PROCESS || param > MAX_COUNT_PROCESS)
			throw new InvalidFileException(InvalidFileException.INVALID_COUNT_PROCCESSES);
		else{
			this.countProccesses = param;
		}
	}

	public float getCountThreads() {
		return countThreads;
	}

	public void setCountThreads(String countThreadsS) throws InvalidFileException {
		if(countThreadsS == null)
			throw new InvalidFileException(InvalidFileException.INVALID_COUNT_THREADS);
		
		float param = Float.parseFloat(countThreadsS);
		if(param < MIN_COUNT_THREADS || param > MAX_COUNT_THREADS)
			throw new InvalidFileException(InvalidFileException.INVALID_COUNT_THREADS);
		else{
			this.countThreads = param;
		}
	}

	public float getVerification() {
		return verification;
	}

	public void setVerification(String verificationS) throws InvalidFileException {
		if(verificationS == null)
			throw new InvalidFileException(InvalidFileException.INVALID_VERIFICATION_ROW);
		
		float param = Float.parseFloat(verificationS);
		if(param < MIN_ROW_VERIFICATION || param > MAX_ROW_VERIFICATION)
			throw new InvalidFileException(InvalidFileException.INVALID_VERIFICATION_ROW);
		
		this.verification = param;
	}

	public int getInterations() {
		return (int)interations;
	}

	public void setInterations(String interationsS) throws InvalidFileException {
		if(interationsS == null)
			throw new InvalidFileException(InvalidFileException.INVALID_INTERATION);
		
		float param = Float.parseFloat(interationsS);
		if(param < MIN_COUNT_INTERATIONS || param > MAX_COUNT_INTERATIONS)
			throw new InvalidFileException(InvalidFileException.INVALID_INTERATION);
		else{
			this.interations = param;
		}
	}

	public float[][] getMatA() {
		return matA;
	}

	public void setMatA(float[][] matA) {
		this.matA = matA;
	}

	public float[] getVectB() {
		return vectB;
	}

	public void setVectB(float[] vectB) {
		this.vectB = vectB;
	}

	public float getTolerance() {
		return tolerance;
	}

	public void setTolerance(float tolerance) {
		this.tolerance = tolerance;
	}

	public void setInterations(float interations) {
		this.interations = interations;
	}
	
	
	
}
