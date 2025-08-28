package view;

import java.util.Scanner;

import model.Calc;
import view.console.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Calc calcutator = new Calc();
		String menu = "";
		boolean loop = true;
		do{
			System.out.println("-------- Menu --------");
			System.out.println("1 | Soma           |");
			System.out.println("2 | Subtração      |");
			System.out.println("3 | Divisão        |");
			System.out.println("4 | Multiplicação  |");
			System.out.println("5 | Resto / divisão|");
			System.out.println("6 | Dec para bin   |");
			System.out.println("7 | Dec para hex   |");
			System.out.println("8 | Porcentagem    |");
			System.out.println("N | Sair           |");
			menu = keyboard.next();
			float value1;
			float value2;
			switch(menu) {
				case "1":
					System.out.println("-------- Soma --------");
					System.out.println("Insira o primeiro valor. Após inserir aperte Enter:");
					value1 = keyboard.nextFloat();
					System.out.println("Insira o segundo valor. Após inserir aperte Enter:");
					value2 = keyboard.nextFloat();
					System.out.println("Resultado: "+calcutator.sum(value1, value2));
					break;
				case "2":
					System.out.println("------ Subtração -----");
					System.out.println("Insira o primeiro valor. Após inserir aperte Enter:");
					value1 = keyboard.nextFloat();
					System.out.println("Insira o segundo valor. Após inserir aperte Enter:");
					value2 = keyboard.nextFloat();
					System.out.println("Resultado: "+calcutator.sub(value1, value2));
					break;
				case "3":
					System.out.println("------- Divisão ------");
					System.out.println("Insira o primeiro valor. Após inserir aperte Enter:");
					value1 = keyboard.nextFloat();
					System.out.println("Insira o segundo valor. Após inserir aperte Enter:");
					value2 = keyboard.nextFloat();
					System.out.println("Resultado: "+calcutator.div(value1, value2));
					break;
				case "4":
					System.out.println("---- Multiplicação ---");
					System.out.println("Insira o primeiro valor. Após inserir aperte Enter:");
					value1 = keyboard.nextFloat();
					System.out.println("Insira o segundo valor. Após inserir aperte Enter:");
					value2 = keyboard.nextFloat();
					System.out.println("Resultado: "+calcutator.mult(value1, value2));
					break;
				case "5":
					System.out.println("-- Resto da Divisão --");
					System.out.println("Insira o primeiro valor. Após inserir aperte Enter:");
					value1 = keyboard.nextFloat();
					System.out.println("Insira o segundo valor. Após inserir aperte Enter:");
					value2 = keyboard.nextFloat();
					System.out.println("Resultado: "+calcutator.div_rem(value1, value2));
					break;
				case "6":
					System.out.println("---- Dec para bin ----");
					System.out.println("Insira o valor. Após inserir aperte Enter:");
					value1 = keyboard.nextInt();
					System.out.println("Resultado: "+calcutator.decToBin((int)value1));
					break;
				case "7":
					System.out.println("---- Dec para hex ----");
					System.out.println("Insira o valor. Após inserir aperte Enter:");
					value1 = keyboard.nextInt();
					System.out.println("Resultado: "+calcutator.decToHex((int)value1));
					break;
				case "8":
					System.out.println("---- Valor - Porcentagem ----");
					System.out.println("Insira o primeiro valor. Após inserir aperte Enter:");
					value1 = keyboard.nextFloat();
					System.out.println("Insira a porcentagem desejada. Após inserir aperte Enter:");
					value2 = keyboard.nextFloat();
					System.out.println();
					System.out.println("Escolha o que você deseja fazer:");
					System.out.println("1: Somar "+value1+" + "+value2+"%");
					System.out.println("2: Subtrair "+value1+" - "+value2+"%");
					System.out.println("3: Valor "+value2+"% de "+value1+"%");
					menu = keyboard.next();
					switch (menu) {
					case "1":
						System.out.println("Resultado: "+calcutator.percentSumvalue(value1, value2));
						break;
					case "2":	
						System.out.println("Resultado: "+calcutator.percentSubvalue(value1, value2));
						break;
					case "3":
						System.out.println("Resultado: "+calcutator.percentOfvalue(value1, value2));
						break;
					default:
						//throw new IllegalArgumentException("Unexpected value: " + menu);
						System.out.println("Valor não aceito pelo menu.");
						break;
					}
					break;
				case "N":
					loop = false;
					break;
				default:
					//throw new IllegalArgumentException("Unexpected value: " + menu);
					System.out.println("Valor não aceito pelo menu.");
					break;
			}
		}while(loop);
		CalcConsole calcConsole = new CalcConsole(calcutator);
		calcConsole.history();
		System.out.println();
		System.out.println("Fim do programa.");
	}

}
