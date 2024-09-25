/**
 *
 */
package no.hvl.dat152.action;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.dao.AuthorDAO;
import no.hvl.dat152.model.Author;

/**
 *
 */
public class AddAuthorFormAction implements ControllerAction {

    @Override
    public int execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // auto create numeric authorId (this is just a toy example)
        String authorId = generateNumericId();
        request.setAttribute("authorId", authorId);

        // collect authors
        AuthorDAO dao = new AuthorDAO();
        List<Author> authors = dao.getAllAuthors();
        request.setAttribute("authors", authors);

        return ControllerAction.SUCCESS;
    }

    private String generateNumericId() {
        Random random = new Random();
        int id = random.nextInt(1000000); // Generates a random number between 0 and 999999
        return String.format("%06d", id); // Formats the number to ensure it has 6 digits
    }
}
