package com.example.reservations.controller;

import com.example.reservations.entity.Agency;
import com.example.reservations.repository.AgencyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agencies")
public class AgencyController {

    private final AgencyRepository agencyRepository;

    public AgencyController(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }


    @GetMapping
    public String listAgencies(Model model) {
        model.addAttribute("agencies", agencyRepository.findAll());
        return "agencies/list";
    }

    @GetMapping("/{id}/artists")
    public String showAgencyArtists(@PathVariable Long id, Model model) {
        Agency agency = agencyRepository.findById(id).orElseThrow();
        model.addAttribute("agency", agency);
        model.addAttribute("artists", agency.getArtists());
        return "agencies/artists";
    }
}