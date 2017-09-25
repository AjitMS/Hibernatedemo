package com.bridgeit.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bridgeit.sessionFactoryPackage.SessionFactoryBuilder;
import com.bridgeit.student.entity.Address;
import com.bridgeit.student.entity.Book;
import com.bridgeit.student.entity.Certification;
import com.bridgeit.student.entity.Student;

public class StudentManager {

	static Scanner t;

	public static void main(String[] args) {
		t = new Scanner(System.in);

		String carryOn = "yes";

		Student student = new Student();
		while (carryOn.equalsIgnoreCase("yes")) {

			System.out.println("\n\n\t\t***WELCOME TO STUDENT MANAGEMENT SYSTEM***\n\n"
					+ "Enter a Choice \n 1. Add Student \n 2. Delete Student\n 3. Show Student \n 4. Update Student \n 5. Show Student List");

			int choice = t.nextInt();
			switch (choice) {
			case 1:
				addStudent(student);
				break;
			case 2:
				deleteStudent(student);
				break;
			case 3:
				showStudent(student);
				break;
			case 4:
				updateStudent(student);
				break;
			case 5:
				showStudentList();
				break;
			default:
				System.out.println("Invalid");
				t.close();

			}
			System.out.println("1. Continue Program ? \n 2. Exit!\n");
			int n = t.nextInt();
			if (n == 1) {
				carryOn = "yes";
			}

			else if (n == 2) {
				carryOn = "no";
				System.out.println(":) Goodbye! :)");
				System.exit(1);
			}

			else {
				System.out.println("Dirty Value");
			}
		}
	}

	static SessionFactoryBuilder sessionFactoryBuilder = new SessionFactoryBuilder();
	static SessionFactory factory = sessionFactoryBuilder.getSessionFactory();
	static List<Student> studentList;

	@SuppressWarnings("unchecked")
	private static void showStudentList() {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		studentList = new ArrayList<>();
		studentList = session.createQuery("from Student").list();
		for (Student tempStudent : studentList)
			System.out.println(tempStudent);
		session.getTransaction().commit();
		session.close();
	}

	private static void addStudent(Student student) {

		System.out.println("Enter Student's First Name");
		student.setFirstName(t.next());
		System.out.println("Enter Student's Last Name");
		student.setLastName(t.next());
		System.out.println("Enter Student's Address");
		try {
			student.setAddress(getStudentAddress());
		} catch (Throwable E) {
			E.printStackTrace();
		}

		try {
			student.setCertification(getStudentCertification());
		} catch (Throwable E) {
			E.printStackTrace();
		}
		Book book1 = getStudentBook();
		student.getBookList().add(book1);
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		System.out.println("Student " + student.getFirstName() + " is added successfully into our records !");

	}

	private static Book getStudentBook() {
		Book book = new Book();
		System.out.println("Enter Book Name");
		book.setBookName(t.nextLine());
		System.out.println("Enter Book Author");
		book.setBookAuthor(t.nextLine());
		return book;
	}

	private static Address getStudentAddress() {
		Address address = new Address();
		System.out.println("Enter Street");
		address.setStreet(t.nextLine());
		System.out.println("Enter City");
		address.setCity(t.nextLine());
		System.out.println("Enter Landmark");
		address.setLandMark(t.nextLine());
		System.out.println("Enter State");
		address.setState(t.nextLine());
		System.out.println("Enter PinCode");
		address.setPinCode(t.nextLine());
		System.out.println("Enter Country");
		address.setCountry(t.nextLine());
		return address;
	}

	private static Certification getStudentCertification() {
		Certification certification = new Certification();
		System.out.println("Enter Certification Name");
		certification.setName(t.next());
		System.out.println("Enter Certification Date");
		certification.setDate(t.next());
		return certification;
	}

	private static void deleteStudent(Student student) {

		System.out.println("Enter Student's id");
		int id = t.nextInt();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		student = session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
		session.close();
		System.out.println("Student " + student.getFirstName() + " is deleted successfully from our records !");
	}

	private static void showStudent(Student student) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Enter ID to view");
		int id = t.nextInt();
		Student showStudent = session.get(Student.class, id);
		session.getTransaction().commit();
		session.close();
		System.out.print("Student details: \n" + showStudent);
	}

	@SuppressWarnings("resource")
	private static void updateStudent(Student student) {

		Session session = factory.getCurrentSession();
		System.out.println();
		System.out.println("Before Update: ");
		// showStudent(student);// show old student
		System.out.println("Enter ID to update student");
		int id = t.nextInt();
		session.beginTransaction();
		student = session.get(Student.class, id);
		System.out.println("Old Student details: " + student + ".");
		System.out.println("What details you'd like to change ?\n 1. First Name \n 2. Last Name \n 3.Address");
		int choice = t.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter New First Name: ");
			// session.beginTransaction();
			session = factory.getCurrentSession();
			student.setFirstName(t.nextLine());
			session.getTransaction().commit();
			session.close();
			break;
		case 2:
			System.out.println("Enter New Last Name: ");
			// session.beginTransaction();
			session = factory.getCurrentSession();
			student.setLastName(t.nextLine());
			session.getTransaction().commit();
			session.close();
			break;
		case 3:
			System.out.println("Enter New Address: ");
			// session.beginTransaction();
			session = factory.getCurrentSession();
			student.setAddress(getStudentAddress());
			session.getTransaction().commit();
			session.close();
			break;
		default:
			System.out.println("Invalid Choice. Try Again");
		}

		System.out.println("After Update: " + student);
		// showStudent(student);// show new student
	}

}
