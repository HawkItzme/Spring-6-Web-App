package syed.spring.app.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import syed.spring.app.spring6webapp.services.AuthorService;
import syed.spring.app.spring6webapp.services.BookService;

@Controller
public class AuthorsController {
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    private final AuthorService authorService;

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
