package com.luv2code.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.EmpDetails;
import com.luv2code.hibernate.demo.entity.Employees;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
public class EmpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employees.class)
										.addAnnotatedClass( EmpDetails.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					
					// create the objects
					/*
					Instructor tempInstructor = 
							new Instructor("Chad", "Darby", "darby@luv2code.com");
					
					InstructorDetail tempInstructorDetail =
							new InstructorDetail(
									"http://www.luv2code.com/youtube",
									"Luv 2 code!!!");		
					*/
					
					Employees e1 = new Employees("praveen","IT",100000L,"2017-12-16");
 					EmpDetails eDetails = new EmpDetails("xyz","male",10L,"yyy123",e1);
					

					
					
					
					// associate the objects
					//tempInstructor.setInstructorDetail(tempInstructorDetail);
					
					// start a transaction
					session.beginTransaction();
					
					// save the instructor
					//
					// Note: this will ALSO save the details object
					// because of CascadeType.ALL
					//
					System.out.println("Saving instructor: " + e1);
					session.save(e1);	
					session.save(eDetails);	
						//

					
					//EmpDetails eDetails = new EmpDetails();	
					
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%"+eDetails.getEmployee().getDepartment());
					e1.setEmpDetails(eDetails);
					
					// commit transaction
					session.getTransaction().commit();
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+e1.getEmpDetails().getYearsOfService());

					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}


	}

}
