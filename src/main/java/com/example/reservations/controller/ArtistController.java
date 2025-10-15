package com.example.reservations.controller;

import com.example.reservations.entity.Artist;
import com.example.reservations.repository.AgencyRepository;
import com.example.reservations.repository.ArtistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistRepository artistRepository;
    private final AgencyRepository agencyRepository;

    public ArtistController(ArtistRepository artistRepository, AgencyRepository agencyRepository) {
        this.artistRepository = artistRepository;
        this.agencyRepository = agencyRepository;
    }

    @GetMapping
    public String listArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artists/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("artist", new Artist());
        model.addAttribute("agencies", agencyRepository.findAll());
        return "artists/form";
    }

    @PostMapping
    public String saveArtist(@ModelAttribute Artist artist) {
        artistRepository.save(artist);
        return "redirect:/artists";
    }

    @GetMapping("/{id}/agency")
    @ResponseBody
    public String getArtistAgency(@PathVariable Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow();
        return artist.getAgency().getName();
    }
}