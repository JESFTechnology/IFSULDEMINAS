package model;

public class MultiFunctionalPrinter implements Faxable,Printable,Scannable, Duplicable{
	
	@Override
	public void faxDocument(String content) {
		System.out.println("MP: Enviando documento por fax: \n" + content);
	}
	
	@Override
	public void printDocument(String content) {
		System.out.println("MP: Imprimindo documento: \n" + content);
	}

	@Override
	public void scanDocument(String content) {
		System.out.println("MP: Digitalizando documento: \n" + content);
	}
	
	@Override
	public void xeroxDocument(String content) {
		System.out.println("MP: Xerocando documento: \n" + content);
	}
}