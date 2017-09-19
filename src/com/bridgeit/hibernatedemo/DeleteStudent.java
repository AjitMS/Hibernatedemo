package com.bridgeit.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgeit.hibernate.entity.Student;

public class DeleteStudent {

	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Student myStudent = session.get(Student.class, 3);
		session.delete(myStudent);
		// session.createQuery("delete from Student where id=2").executeUpdate();
		session.getTransaction().commit();

	}
}
