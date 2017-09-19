package com.bridgeit.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgeit.hibernate.entity.Student;

public class AddStudent {

	public static void main(String[] args) {

		Student student = new Student("ajit shikalgar1", "ajitshikalgar786@gmail.com1");
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		// adding student object
		session.save(student);

		// retrieving same student object
		Student newStudent = session.get(Student.class, student.getId());
		System.out.println("Got student as: " + newStudent);
		session.getTransaction().commit();

	}

}
