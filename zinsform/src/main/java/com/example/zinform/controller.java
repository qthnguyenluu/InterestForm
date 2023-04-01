package com.example.zinform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controller {

    @Autowired
    public ZinsService rechnenservice;


    @PostMapping("/")
    public String handlePost(interestForm interestForm, Model model, Boolean tab) {
        List<ZinsJahre> ergebnisse = rechnenservice.zinsenBerechnen(interestForm);
        Double endekapital = rechnenservice.endgeld;
        model.addAttribute("endekapital", endekapital);
        model.addAttribute("ergebnisse", ergebnisse);
        model.addAttribute("tabelle", tab);
        model.addAttribute("result",true);

        return "zinsform";

    }

    @GetMapping("/")
    public String index(interestForm zinsform) {
        return "zinsform";
    }
}
