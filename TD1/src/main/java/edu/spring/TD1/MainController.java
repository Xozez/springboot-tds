package edu.spring.TD1;

import edu.spring.TD1.models.Item;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@SessionAttributes("items")
public class MainController {

    @ModelAttribute("/")
    public List<Item> getItems(){
        return new ArrayList<>();
    }
    @GetMapping("/")
    public RedirectView newItem(){
        // TODO
        return new RedirectView("/items/new.html");
    }

    @PostMapping("/addNew")
    public RedirectView addNew(@SessionAttribute("items") List<Item> items,@RequestParam String nom, RedirectAttributes attrs) {
        Item element = new Item(nom,0);
        items.add(element);
        attrs.addFlashAttribute("msg", nom + " a été décrémenté" );
        return new RedirectView("/");
    }
    @PostMapping("/inc/{nom}")
    public RedirectView inc(@SessionAttribute("items") List<Item> items,@PathVariable("nom") String nom, RedirectAttributes attrs){
        for (Item element : items) {
            if (element.getNom().equals(nom)) {
                element.setEvaluation(element.getEvaluation() + 1);
            }
        }
        attrs.addFlashAttribute("msg", nom + " a été incrémenté" );
        return new RedirectView("/");
    }
    @PostMapping("/dec/{nom}")
    public RedirectView dec(@SessionAttribute("items") List<Item> items, @PathVariable("nom") String nom, RedirectAttributes attrs) {
        for (Item element : items) {
            if (element.getNom().equals(nom)) {
                element.setEvaluation(element.getEvaluation() - 1);
            }
        }
        attrs.addFlashAttribute("msg", nom + " a été décrémenté" );
        return new RedirectView("/");
    }
}