package com.myFuzzyProject;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class QualidadedoOvo {
	public static void main(String[] args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		float casca, idade;
		
		String filename = "qualidadeOvo.fcl"; 
		FIS fis = FIS.load(filename, true); 

		if (fis == null) { 
			System.err.println("Erro ao carregar arquivo: '" + filename + "'");
			System.exit(1);
		}

		
		FunctionBlock fb = fis.getFunctionBlock(null);

		
		System.out.println("Como está o estado da casca do ovo? (0-sem danos, 10-muito danificado)? ");
		casca = teclado.nextFloat();
		System.out.println("Qual a idade do ovo em semanas (0-menos de uma semana)? ");
		idade = teclado.nextFloat();
		fb.setVariable("casca", casca);  
		fb.setVariable("idade", idade);  

		
		fb.evaluate();

		
		fb.getVariable("qualidade").defuzzify();

		
		System.out.println(fb);
		System.out.println("Qualidade: " + fb.getVariable("qualidade").getValue());

	}

}
