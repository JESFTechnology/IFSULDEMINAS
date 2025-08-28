package view.console;

import model.Calc;

public class CalcConsole {
	
	private Calc calc;
	
	public CalcConsole(Calc calc) {
		if(calc == null)
			throw new IllegalArgumentException(
					"É necessário uma instância válida de Calc");
		this.calc = calc;
	}
	
	public void history() {
		System.out.println(" -- Exibindo histórico -- ");
		for(int i = 0; i < calc.getHistoryLenght(); i++) {
			System.out.println(i+" | "+calc.getHistoryAtIndex(i));
		}
	}
}
