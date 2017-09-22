package com.bridgeit.student;

import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		System.out.println("Enter Choice");
		int choice = t.nextInt();
		switch (choice) {
		case 1:
			addStudent();
			break;
		case 2:
			deleteStudent();
			break;
		case 3:
			showStudent();
			break;
		case 4:
			updateStudent();
			break;
		case 5:
			showStudentList();
			break;
		default:
			System.out.println("Invalid");
			t.close();

		}
	}

	private static void showStudentList() {
		// TODO Auto-generated method stub

	}

	private static void addStudent() {

	}

	private static void updateStudent() {
		// TODO Auto-generated method stub

	}

	private static void showStudent() {
		// TODO Auto-generated method stub

	}

	private static void deleteStudent() {
		// TODO Auto-generated method stub

	}

}
