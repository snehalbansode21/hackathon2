package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Books 
{
	private Integer id;
	private String name,author,subject;
	private double price;
	private int isbn;
	private List<Copies> copyList = new ArrayList<>();
	public Books() {
		// TODO Auto-generated constructor stub
	}
	public Books(String name, String author, String subject, double price, int isbn) {
		super();
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 30)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(length = 30)
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Copies> getCopyList() {
		return copyList;
	}
	public void setCopyList(List<Copies> copyList) {
		this.copyList = copyList;
	}
	public void addCopies(Copies c)
	{
		copyList.add(c);
		c.setBook(this);
	}
	public void removecopies(Copies c)
	{
		copyList.remove(c);
		c.setBook(null);
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ ", isbn=" + isbn + "]";
	}
	
}
