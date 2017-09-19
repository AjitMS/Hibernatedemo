package com.bridgeit.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgeit.hibernate.entity.Student;

public class QueryStudent {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		List<Student> studentList = session.createQuery("from Student").list();
		displayStudents(studentList);

		List<Student> studentList1 = session
				.createQuery("from Student s where s.email='ajitshikalgar786@gmail.com1' OR s.email='ajit@gmail.com'")
				.list();
		displayStudents(studentList1);

		/*
		 * List<Student> studentList2 =
		 * session.createQuery("from Student s where s.name LIKE s.email='%@gmail.com'")
		 * .list(); displayStudents(studentList2);
		 */
	}

	public static void displayStudents(List<Student> studentList) {

		System.out.println("List is: ");
		for (Student tempStudent : studentList) {
			System.out.println(tempStudent);
		}
	}

}
