package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Cart;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Items;

public class CreateCartAndItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cart.class)
				.addAnnotatedClass(Items.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			/*
			 * Cart c2 = new Cart("sreetejcarttwo"); session.save(c2); Items i1 = new
			 * Items("iphone111 X"); Items i2 = new Items("Samsung proX");
			 * 
			 * i1.setCart(c2); i2.setCart(c2); session.save(i1); session.save(i2);
			 * System.out.println("***********************" + i2.getCart().getName());
			 * 
			 * Cart c3 = new Cart("sreetejcartthree"); Items i3 = new Items("iphone100 X");
			 * Items i4 = new Items("Samsung proXXX"); i3.setCart(c3); i4.setCart(c3);
			 * session.save(c3); session.save(i3); session.save(i4);
			 */
			//////////////////////
			Cart c3 = new Cart("sreetejcartthree");
			Cart c4 = new Cart("sreetejcartfour");
			Items i5 = new Items("android1");
			Items i6 = new Items("android2");
			i5.setCart(c3);
			i6.setCart(c3);
		

			 c4.setItems(new ArrayList<Items>() {
			
					 private static final long serialVersionUID = 1L;
					  
					  { add(i5); add(i6); } //This is to test inconsistency
					  });
					 
			 session.save(c3);
			session.save(c4);
			session.save(i5);
			session.save(i6);

			for (Items item : c4.getItems()) {
				System.out.println("cart items " + item.getName());
				
			}
			///////////////////////////////

			// commit transaction
			session.getTransaction().commit();
			// System.out.println("***********************"+i3.getCart().getName());

			System.out.println("Done!");
			session.close();
		}

		finally {

			factory.close();
		}

	}

}
