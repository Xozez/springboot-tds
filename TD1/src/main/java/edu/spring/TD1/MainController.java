package edu.spring.TD1;

import edu.spring.TD1.models.Item;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@SessionAttributes("items")
public class MainController {

    @ModelAttribute("/")
    public List<Item> getItems(){
        return new ArrayList<>();
    }
    @GetMapping("/new")
    public RedirectView newItem(){
        // TODO
        return new RedirectView("/items/new.html");
    }

    @PostMapping("/addNew")
    public RedirectView addNew(@SessionAttribute("items") List<Item> items,@RequestParam String nom) {
        Item element = new Item(nom,0);
        items.add(element);
        return new RedirectView("/items/");
    }
    @PostMapping("/inc/{nom}")
    public RedirectView inc(@SessionAttribute("items") List<Item> items,@PathVariable("nom") String nom) {
        for (Item element : items) {
            if (element.getNom().equals(nom)) {
                element.setEvaluation(element.getEvaluation() + 1);
            }
        }
        return new RedirectView("/items/");
    }
    @PostMapping("/dec/{nom}")
    public RedirectView dec(@SessionAttribute("items") List<Item> items,@PathVariable("nom") String nom) {
        for (Item element : items) {
            if (element.getNom().equals(nom)) {
                element.setEvaluation(element.getEvaluation() - 1);
            }
        }
        return new RedirectView("/items/");
    }
}