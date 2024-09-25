package no.hvl.dat152.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.dao.AuthorDAO;
import no.hvl.dat152.model.Author;

import java.io.IOException;

public class AddAuthorAction implements ControllerAction{

    @Override
    public int execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String authorId = request.getParameter("authorId");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        int author = Integer.parseInt(authorId);

        Author newAuthor = new Author(author, firstname, lastname);

        // save in DB
        AuthorDAO dao = new AuthorDAO();
        dao.addAuthor(newAuthor);

        request.setAttribute("authors", dao.getAllAuthors());

        //response.sendRedirect("viewauthors");
        return ControllerAction.SUCCESS;
    }
}
