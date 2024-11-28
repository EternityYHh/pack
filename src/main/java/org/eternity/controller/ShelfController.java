package org.eternity.controller;

import org.eternity.models.Shelf;
import org.eternity.services.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    private ShelfService shelfService;

    @PostMapping("/get")
    public Shelf get(@RequestParam("id") Long id) {
        return shelfService.findShelfById(id);
    }

    @GetMapping("/shelves")
    public List<Shelf> getAll() {
        return shelfService.findAllShelf();
    }

}
