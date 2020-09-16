package com.luv2code.hibernate.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	
	//comments included
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cart_id;
	
	@Column(name = "name")
    private String name;
	
	//@OneToMany(mappedBy = "cart", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		     // CascadeType.REFRESH })
	@OneToMany
	@JoinColumn(name = "cart_id")
	private List<Items> items;
	
	 public  Cart() {

	    }

	    public Cart(String name) {
	        this.name = name;
	         
	    }

		public int getCart_id() {
			return cart_id;
		}

		public void setCart_id(int cart_id) {
			this.cart_id = cart_id;
		}

		public String getName() {
			return name;	
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Items> getItems() {
			return items;
		}

		public void setItems(List<Items> items) {
			this.items = items;
		}
	    

}
