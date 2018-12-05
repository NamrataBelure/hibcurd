package com.scp.java.Hibernate.hibcurd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppUtil {
	private static SessionFactory sessionFactory = null;
	
	
	public static SessionFactory getSessionFactory(){
			if(sessionFactory == null){
				Configuration configuration = new Configuration();
				sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();	
			}
			return sessionFactory;
		}
		public static void closeResources(Session session, Transaction tr) {
			
			if(session!=null){
				session.flush();
				if(tr!=null){
						tr.commit();
				}
				session.close();
			}
		}
	
	
}
