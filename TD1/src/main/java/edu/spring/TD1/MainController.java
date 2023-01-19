package edu.spring.TD1;

import edu.spring.TD1.models.Element;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@SessionAttributes("items")
@RequestMapping("/")
public class MainController {

    @ModelAttribute("items")
    public List<Element> getItems(){
        return new ArrayList<>();
    }
    @GetMapping("items/new")
    public RedirectView newItem(){
        // TODO
        return new RedirectView("/items/new.html");
    }

    @PostMapping("items/addNew")
    public RedirectView addNew(@SessionAttribute("items") List<Element> items,@RequestParam String nom) {
        Element element = new Element(nom,0);
        items.add(element);
        return new RedirectView("/items/");
    }
    @PostMapping("items/inc/{nom}")
    public RedirectView inc(@SessionAttribute("items") List<Element> items,@PathVariable("nom") String nom) {
        for (Element element : items) {
            if (element.getNom().equals(nom)) {
                element.setEvaluation(element.getEvaluation() + 1);
            }
        }
        return new RedirectView("/items/");
    }
    @PostMapping("items/dec/{nom}")
    public RedirectView dec(@SessionAttribute("items") List<Element> items,@PathVariable("nom") String nom) {
        for (Element element : items) {
            if (element.getNom().equals(nom)) {
                element.setEvaluation(element.getEvaluation() - 1);
            }
        }
        return new RedirectView("/items/");
    }
}