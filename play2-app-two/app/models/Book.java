package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Book  extends Model{
	
	@Id
	public String bid;
	@Required
	public String name;
	
	/*
	public setName(String name){
		this.name = name;
	}
	
	public setBid(String bid){
		this.bid = bid;
	}
	
	public getName(){
		return this.name;
	}
	
	public getBid(){
		return  this.bid ;
	}
	*/
	public static Finder<String,Book> find = new Finder(String.class, Book.class);
	
	public static List<Book> all() {
		List<Book> books = find.all();
		if(books==null){
			books = new ArrayList<Book>();
		}
  		return books;
	}
	
	public static void create(Book book) {
		book.save();
	}
	
	public static void deleteBook(String id) {
		find.ref(id).delete();
	}
	
}