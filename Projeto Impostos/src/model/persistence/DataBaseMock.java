package model.persistence;

import java.util.HashMap;
import java.util.Map;

public class DataBaseMock {
	private static Map<String, Double> ipis = new HashMap<>();
	private static final Double DEFAULT_IPI = 0.15;
	
	private static Map<String, Double> icmsies = new HashMap<>();
	private static final Double DEFAULT_ICMS = 0.01;
	
	private static Map<String, Double> issies = new HashMap<>();
	private static final Double DEFAULT_ISS = 0.05;
	
	static {
		// Setup dos IPIs
		ipis.put("auto", 0.18);
		ipis.put("food", 0.05);
		ipis.put("drink", 0.25);
		
		// Setup dos ICMSs
		icmsies.put("SP-MG", 0.03);
		icmsies.put("RJ-MG", 0.05);
		icmsies.put("ES-MG", 0.08);
		icmsies.put("MG-SP", 0.10);
		
		// Setup dos ISS
		issies.put("cg", 0.08);
		issies.put("machado", 0.05);
		issies.put("alfenas", 0.10);
	}
	
	public static Double selectIPI(String productType) {
		Double ipi = ipis.get(productType);
		
		if (ipi == null)
			return DEFAULT_IPI;
		
		return ipi;
	}
	
	public static Double selectICMS(String from, String to) {
		Double icms = icmsies.get(from +"-" + to);
		
		if (icms == null)
			return DEFAULT_ICMS;
		
		return icms;
	}
	
	public static Double selectISS(String city) {
		Double iss = issies.get(city);
		
		return iss == null ? DEFAULT_ISS : iss;
	}
}
