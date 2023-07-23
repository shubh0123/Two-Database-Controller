package com.database2.entity.faculty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	private String subject;
	
	
	private Long contact_no;


	public Faculty(String name, String subject, Long contact_no) {
		super();

		this.name = name;
		this.subject = subject;
		this.contact_no = contact_no;
	}


	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"id=" + id +
				", name='" + name + '\'' +
				", subject='" + subject + '\'' +
				", contact_no=" + contact_no +
				'}';
	}
}
