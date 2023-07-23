package com.database1.entity.students;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	
	private String mother_name;
	
	private String father_name;
	
	@Column(length=10)
	private Long contact_no;

	public Students(Long id,String name, String mother_name, String father_name, Long contact_no) {
		super();
		this.Id=id;
		this.name = name;
		this.mother_name = mother_name;
		this.father_name = father_name;
		this.contact_no = contact_no;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Students{" +
				"Id=" + Id +
				", name='" + name + '\'' +
				", mother_name='" + mother_name + '\'' +
				", father_name='" + father_name + '\'' +
				", contact_no=" + contact_no +
				'}';
	}
}
