package org.eternity.controller;

import org.eternity.models.Pack;
import org.eternity.services.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pack")
public class PackController {
    @Autowired
    private PackService packService;

    @GetMapping("/packs")
    public List<Pack> getPacks() {
        return packService.getAll();
    }

    @PostMapping("/create")
    public Pack createPack(@RequestBody Pack pack) {
        return packService.save(pack);
    }

    @PostMapping("/createPack")
    public Pack createPack(@RequestParam("senderID") Long senderID, @RequestParam("receiverID") Long receiverID,
                           @RequestParam("description") String description, @RequestParam("nowDate") String nowDate ) {
        return packService.save(senderID, receiverID, description, nowDate);
    }

    @PostMapping("/get")
    public Pack getPack(@RequestParam("id") Long id) {
        return packService.getById(id);
    }

    @PostMapping("/delete")
    public void deletePack(@RequestParam("id") Long id) {
        packService.deleteById(id);
    }

    @PostMapping("/set")
    public Pack setPack(@RequestParam("id") Long id, @RequestParam("status") int status) {
        return packService.setStatus(id, status);
    }

    @PostMapping("/send")
    public Pack sendPack(@RequestParam("id") Long id, @RequestParam("sendDate") String sendDate) {
        return packService.sendPack(id, sendDate);
    }

    @PostMapping("/arrive")
    public Pack arrivePack(@RequestParam("id") Long id, @RequestParam("arriveDate") String arriveDate) {
        return packService.arrivePack(id, arriveDate);
    }

    @PostMapping("/receive")
    public Pack receivePack(@RequestParam("id") Long id, @RequestParam("receiveDate") String receiveDate) {
        return packService.receivePack(id, receiveDate);
    }

    @PostMapping("/put")
    public Pack putPack(@RequestParam("id") Long id, @RequestParam("nowDate") String nowDate, @RequestParam("shelfID")  Long shelfID) {
        return packService.putOnShelf(id, nowDate, shelfID);
    }
}