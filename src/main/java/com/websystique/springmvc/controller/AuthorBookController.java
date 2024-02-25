package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.service.AuthorService;
import com.websystique.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/authorsBooks")
@SessionAttributes("roles")
public class AuthorBookController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;


    /**
     * This method will list all existing authors and books.
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAuthors(ModelMap model) {

        List<Book> books = bookService.findAllBooks();
        List<Author> authors = authorService.findAllAuthors();
        model.addAttribute("books", books);
        model.addAttribute("authors", authors);
        model.addAttribute("loggedinuser", getPrincipal());
        return "booksauthorslist";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    /**
     * This method will provide the medium to add a new book.
     */
    @RequestMapping(value = {"newbook"}, method = RequestMethod.GET)
    public String newOffice(ModelMap model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "newbook";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newbook"}, method = RequestMethod.POST)
    public String newBook(@Valid Book book, BindingResult result,
                          ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }
        bookService.saveBook(book);

        model.addAttribute("success", "Book " + book.getName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    /**
     * This method will provide the medium to add a new author.
     */
    @RequestMapping(value = {"newauthor"}, method = RequestMethod.GET)
    public String newAuthor(ModelMap model) {
        Author author = new Author();
        model.addAttribute("author", author);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "newauthor";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newauthor"}, method = RequestMethod.POST)
    public String newOffice(@Valid Author author, BindingResult result,
                            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }
        Set<Book> bookSet = new HashSet<>();
        author.setBooks(bookSet);
        authorService.saveAuthor(author);
        model.addAttribute("success", "Author " + author.getName() + " " + author.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    @RequestMapping(value = {"delete-author-{id}"}, method = RequestMethod.GET)
    public String deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthorById(id);
        return "redirect:/authorsBooks/list";
    }

    @RequestMapping(value = {"delete-book-{id}"}, method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBookById(id);
        return "redirect:/authorsBooks/list";
    }

    @RequestMapping(value = {"edit-book-{id}"}, method = RequestMethod.GET)
    public String editBook(@PathVariable int id, ModelMap model) {
        Book book = bookService.findById(id);

        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "newbook";
    }

    @RequestMapping(value = {"edit-author-{id}"}, method = RequestMethod.GET)
    public String editAuthor(@PathVariable int id, ModelMap model) {
        Author author = authorService.findById(id);

        model.addAttribute("author", author);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "newauthor";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating book in database. It also validates the user input
     */
    @RequestMapping(value = {"edit-book-{id}"}, method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result,
                             ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "newbook";
        }

        bookService.updateBook(book);

        model.addAttribute("success", "Book " + book.getName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating author in database. It also validates the user input
     */
    @RequestMapping(value = {"edit-author-{id}"}, method = RequestMethod.POST)
    public String updateBook(@Valid Author author, BindingResult result,
                             ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "newauthor";
        }

        authorService.updateAuthor(author);

        model.addAttribute("success", "Author " + author.getName() + " " + author.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }


    @RequestMapping(value = {"/add-book-{id}"}, method = RequestMethod.GET)
    public String addBook(@PathVariable String id, ModelMap model) {
        Author author = authorService.findById(Integer.parseInt(id));
        List<Book> books = bookService.findAllBooks();
        List<Book> result = new ArrayList<>();
        books.forEach(book -> {
            if (!author.getBooks().contains(book)) {
                result.add(book);
            }
        });
        model.addAttribute("author", author);
        model.addAttribute("books", result);
        return "addbook";
    }

    @RequestMapping(value = {"/add-book-{id}"}, method = RequestMethod.POST)
    public String assignBook(@PathVariable String id, ModelMap model, @RequestParam Integer bookId) {
        Author author = authorService.findById(Integer.parseInt(id));
        author.getBooks().add(bookService.findById(bookId));
        authorService.updateAuthorBooks(author);
        model.addAttribute("success", "Author " + author.getName() + " " + author.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/remove-book-{id}"}, method = RequestMethod.GET)
    public String removeBook(@PathVariable String id, ModelMap model) {
        Author author = authorService.findById(Integer.parseInt(id));
        List<Book> books = bookService.findAllBooks();
        List<Book> result = new ArrayList<>();
        books.forEach(book -> {
            if (author.getBooks().contains(book)) {
                result.add(book);
            }
        });
        model.addAttribute("author", author);
        model.addAttribute("books", result);
        return "addbook";
    }

    @RequestMapping(value = {"/remove-book-{id}"}, method = RequestMethod.POST)
    public String removeBook(@PathVariable String id, ModelMap model, @RequestParam Integer bookId) {
        Author author = authorService.findById(Integer.parseInt(id));
        author.getBooks().remove(bookService.findById(bookId));
        authorService.updateAuthorBooks(author);
        model.addAttribute("success", "Author " + author.getName() + " " + author.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }


//    @RequestMapping(value = {"searchform"}, method = RequestMethod.GET)
//    public String search(ModelMap model) {
////        Author author = new Author();
////        model.addAttribute("author", author);
////        model.addAttribute("edit", false);
//        model.addAttribute("loggedinuser", getPrincipal());
//        return "searchform";
//    }


    @RequestMapping(value = {"list"}, method = RequestMethod.POST)
    public String findBooks(ModelMap model, @RequestParam String key, @RequestParam String searchPattern) {
        if (searchPattern.equals("author")) {
        List <Author> authors = authorService.findAllAuthors();
        List <Author> result = new ArrayList<>();
        Set <Book> books = new HashSet<>();
        authors.forEach(author -> {
            if (author.getName().startsWith(key) || author.getLastName().startsWith(key)) {
                result.add(author);
                books.addAll(author.getBooks());
            }
        });
        model.addAttribute("books", books);
        model.addAttribute("authors", result);
        } else {
            List <Book> books = bookService.findAllBooks();
            List <Book> bookResult = new ArrayList<>();
            List <Author> authors = authorService.findAllAuthors();
            List <Author> authorResult = new ArrayList<>();
            books.forEach(book -> {
                if (book.getName().startsWith(key) || book.getCategory().startsWith(key)) {
                    bookResult.add(book);
                    authors.forEach(author -> {
                        if (author.getBooks().contains(book)) {
                            authorResult.add(author);
                        }
                    });
                }
            });
            model.addAttribute("books", bookResult);
            model.addAttribute("authors", authorResult);
        }
        model.addAttribute("loggedinuser", getPrincipal());
        return "searchresult";
    }
}
