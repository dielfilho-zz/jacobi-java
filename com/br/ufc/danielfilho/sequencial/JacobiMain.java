package com.br.ufc.danielfilho.sequencial;

import com.br.ufc.danielfilho.file.ArchiveReader;
import com.br.ufc.danielfilho.file.FileProperties;
import com.br.ufc.danielfilho.jacobi.Jacobi;

public class JacobiMain {
	
	public static void main(String[] args) {
		ArchiveReader reader = new ArchiveReader();
		FileProperties properties = reader.showAndReadFileSync();
		if(properties != null)
			new Jacobi(properties).startCalc();
	}
	
}
