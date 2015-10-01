package com.kapx.java8.reflection;
class SomeRequest {
	private String message;

	SomeRequest(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

public class ObjectSizeCalculatorTest {
	public static void main(String[] args) throws Exception {
		final String command = "delete * ManagedElement.userLabel==KAOS,SectorEquipmentFunction.configuredOutputPower==20000";
		System.out.println("Size: " + ObjectSizeCalculator.sizeOf(command));

		final String message = "cmedit delete * EUtranCellFDD.(EUtranCellFDDId==LTETA0002FDD_Cell_1, cellId==1) EUtranCellFDD -c=TC";
		final SomeRequest request = new SomeRequest(message);
		System.out.println("Size: " + ObjectSizeCalculator.sizeOf(request));
	}

}
