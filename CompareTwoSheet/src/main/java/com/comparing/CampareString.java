package com.comparing;

public class CampareString {
public static void main(String[] args) {
	String cellValue1 = "Admin";
	String cellValue2 = "Admin";
	if (cellValue2.contains(cellValue1)) {
		System.out.println("Both cellValues are same");
	} else {
		System.out.println("Both cellValues are not same");
	}
}
}
