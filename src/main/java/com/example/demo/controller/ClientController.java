package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/add-client")
    public String showAddForm(Client client,
                              Model model){

        model.addAttribute("country", countryService.getCountryList());
        return "add-client";
    }

    @PostMapping("/client-list")
    public String addClient(@Valid Client client,
                            BindingResult result,
                            Model model,
                            Authentication authentication) {

        if (result.hasErrors())
            return "add-client";

        try {
            clientService.saveClient(client, authentication);
            model.addAttribute("clients", clientService.getClientListForAuthenticatedUser(authentication));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("clients", new ArrayList<>());
        }

        return "client-list";
    }

    @GetMapping("/edit-client/id={id}")
    public String showUpdateForm(@PathVariable("id") long id,
                                 Model model) {

        Client client = clientService.findClient(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));

        model.addAttribute("client",client);
        model.addAttribute("country", countryService.getCountryList());

        return "/edit-client";

    }

    @PostMapping("/updated-client-{id}")
    public String updateClient(@PathVariable("id") long id,
                               @Valid Client client,
                               BindingResult result,
                               Model model,
                               Authentication authentication) {

        if (result.hasErrors())
            return "edit-client";

        try {
            client.setId(id);
            clientService.updateClient(client);
            model.addAttribute("clients", clientService.getClientListForAuthenticatedUser(authentication));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("clients", new ArrayList<>());
        }

        return "redirect:/client-list";

    }


    @GetMapping("/client-list")
    public String getClientList(Model model,
                                Authentication authentication) {

        try {
            model.addAttribute("clients", clientService.getClientListForAuthenticatedUser(authentication));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("clients", new ArrayList<>());
        }
        return "client-list";
    }
}