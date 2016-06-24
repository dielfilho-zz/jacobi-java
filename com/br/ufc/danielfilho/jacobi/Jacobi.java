package com.br.ufc.danielfilho.jacobi;

import com.br.ufc.danielfilho.file.FileProperties;

public class Jacobi {

	private float [][] matA;
	private float [] vetX;
	private float [] vetB;

	private float tolerance;

	private float [] xPrev;

	private float [] vetDelta;

	private boolean flagWhile;
	
	private int interations;
	
	public Jacobi(FileProperties properties) {
		this.matA = properties.getMatA();
		this.vetB = properties.getVectB();
		this.vetX = new float[(int)properties.getCountRows()];
		this.xPrev = new float[(int)properties.getCountRows()];
		this.vetDelta = new float[(int)properties.getCountRows()];
		this.tolerance = properties.getTolerance();
		this.interations = properties.getInterations();
	}

	public void startCalc(){
		showResult(calc());
	}

	private float[] calc(){
		
		flagWhile = true;
		int countInteration = 0;
		while(flagWhile && countInteration < interations){
			for(int i = 0; i < vetB.length; i++){
				
				float rowCalc = 0;
				
				for(int j = 0; j < vetB.length; j++){
					if(i != j){
						rowCalc += (matA[i][j] * xPrev[j]) / matA[i][i];
					}
					vetX[i] = (vetB[i] / matA[i][i]) - rowCalc;
				}
			}
			
			for(int i = 0; i < vetB.length; i++){
				vetDelta[i] = vetX[i] - xPrev[i];
			}
			
			float maxElement = getBiggestElement(vetDelta);
			
			if( maxElement <= tolerance ){
				flagWhile = false;
			}else{
				copyVect(xPrev, vetX);
				interations++;
				//TODO WHEN INTERATIONS PASSED BY MAX
			}
		}
		return vetX;
	}
	
	private void showResult(float[] result){
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i]+" ");
		}
	}
	
	private void copyVect(float[] vetBase, float[] vetToCopy){
		if(vetToCopy.length != vetBase.length)
			return;
		for(int i = 0; i < vetToCopy.length; i++){
			vetBase[i] = vetToCopy[i];
		}
	}
	
	private float getBiggestElement(float[] vet){
		if(vet.length == 0)
			return -1;
		
		float max = vet[0];
		
		for(int i = 1; i < vet.length; i++){
			if(vet[i] > max)
				max = vet[i]; 
		}
		return max;
	}
	

}
