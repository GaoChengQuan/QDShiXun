package com.situ.student.pojo;

public class Banji {
	private int id;
	private String name;

	public Banji() {
		super();
	}

	public Banji(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Banji(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + "]";
	}

}
