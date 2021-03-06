package edu.uark.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeClassification {
	NOT_DEFINED(-1),
	GENERAL_MANAGER(2),
	SHIFT_MANAGER(3),
	CASHIER(4);
	
	public int getValue() {
		return value;
	}

	public static EmployeeClassification map(int key) {
		if (valueMap == null) {
			valueMap = new HashMap<Integer, EmployeeClassification>();

			for (EmployeeClassification status : EmployeeClassification.values()) {
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : EmployeeClassification.NOT_DEFINED);
	}
	
	private int value;

	private static Map<Integer, EmployeeClassification> valueMap = null;

	private EmployeeClassification(int value) {
		this.value = value;
	}
}
