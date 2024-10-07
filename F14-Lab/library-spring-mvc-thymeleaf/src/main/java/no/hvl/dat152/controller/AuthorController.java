/**
 * 
 */
package no.hvl.dat152.controller;


import no.hvl.dat152.model.Author;
import no.hvl.dat152.model.Book;
import no.hvl.dat152.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.List;


import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService AuthorService;


    @RequestMapping(value = "/addauthor", method = RequestMethod.GET)
    public String create() {
        return "addauthor";
    }

    @RequestMapping(value="/addauthor", method= RequestMethod.POST)
    public String create(@RequestParam String firstname, @RequestParam String lastname){

        Author author = new Author(firstname, lastname);
        AuthorService.saveAuthor(author);

        return "redirect:/";
    }
}
