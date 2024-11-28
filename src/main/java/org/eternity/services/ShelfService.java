package org.eternity.services;

import jakarta.transaction.Transactional;
import org.eternity.models.Shelf;
import org.eternity.repositories.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {
    @Autowired
    private ShelfRepository shelfRepository;

    @Transactional
    public Shelf saveShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    @Transactional
    public void deleteShelf(Shelf shelf) {
        shelfRepository.delete(shelf);
    }

    @Transactional
    public Shelf findShelfById(Long id) {
        return shelfRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Shelf> findAllShelf() {
        return shelfRepository.findAll();
    }

}
