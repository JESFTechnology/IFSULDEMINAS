package view;

import model.Calc;
import view.console.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc calcutator = new Calc();
		calcutator.sum(7, 2);
		calcutator.sub(5, 3);
		calcutator.mult(10, 2);
		calcutator.div(50, 5);
		CalcConsole calcConsole = new CalcConsole(calcutator);
		calcConsole.history();
	}

}
