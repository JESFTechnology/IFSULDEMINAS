package view;

import model.Duplicable;
import model.Fax;
import model.Faxable;
import model.MultiFunctionalPrinter;
import model.Printable;
import model.Scannable;
import model.Scanner;
import model.StandardPrinter;

public class Main {
	
	public static void main(String[] args) {
		String content = "Atividade concluida";
		Faxable device;
		Printable device2;
		Scannable device3;
		Duplicable device4;
		
		// device = new MultiFunctionalPrinter();
		// Experimente os outros tipo de IODevice
		device = new Fax();
		device2 = new StandardPrinter();
		device3 = new MultiFunctionalPrinter();
		device4 = new Scanner();
		//device = new StandardPrinter();
		
		fax(device, content);
		print(device2,content);
		scann(device3,content);
		xerox(device4,content);
	}
	
	private static void fax(Faxable device, String content) {
		device.faxDocument(content);
	}
	
	private static void print(Printable device, String content) {
		device.printDocument(content);
	}
	
	private static void scann(Scannable device, String content) {
		device.scanDocument(content);
	}
	
	private static void xerox(Duplicable device, String content) {
		device.xeroxDocument(content);
	}
}