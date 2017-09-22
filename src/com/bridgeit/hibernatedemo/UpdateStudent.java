package com.bridgeit.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgeit.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		// one way
		/*
		 * Student student = session.get(Student.class, 4);
		 * student.setEmail("HarveyisFired@byPearson111.com");
		 * System.out.println("Student is: " + student);
		 */
		session.getTransaction().commit();

		// another way
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("update Student set name='hahaha DonAjit is here'").executeUpdate();
		session.getTransaction().commit();
		session.close();

	}

}
