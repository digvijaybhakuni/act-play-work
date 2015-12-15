package controllers;

import play.*;
import play.data.*;
import play.libs.*;
import play.mvc.*;

import models.*;

import views.html.*;

public class Application extends Controller {

    static Form<Book> bookForm = Form.form(Book.class);

    public static Result index() {
        //return ok(index.render("Your new application is ready."));
        Book b = new Book();
		b.name = "Test";
		Book.create(b);
        return redirect(routes.Application.books());
    }
    
    public static Result test() {
        //return ok(index.render("Your new application is ready."));
        return ok(test.render("We like to Play"));
    }
    
    public static Result helloWorld() {
        return ok("Hello world");
    }

    public static Result books() {
        return ok(index.render(Book.all(), bookForm));
    }
    
    public static Result deleteBook(String bid) {
        Book.deleteBook(bid);
        return redirect(routes.Application.books());
    }
    
    public static Result newBook() {
        Form<Book> filledForm = bookForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(views.html.index.render(Book.all(), filledForm));
        } else {
            Book.create(filledForm.get());
            return redirect(routes.Application.books());  
        }
    }
    
    
    public static Result rwsAllBooks(){
        return ok(Json.toJson(Book.all()));
    }
    
}