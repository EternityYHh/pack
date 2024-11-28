package org.eternity.services;

import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import org.eternity.models.Pack;
import org.eternity.models.User;
import org.eternity.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackService {
    @Autowired
    private PackRepository packRepository;
    @Autowired
    private UserService userService;


    @Transactional
    public Pack save(Pack pack) {
        return packRepository.save(pack);
    }

    @Transactional
    public Pack save(Long senderID, Long receiverID, String description, String nowDate) {
        Pack pack = new Pack();
        User sender = userService.findById(senderID);
        User receiver = userService.findById(receiverID);
        pack.setSender_name(sender.getUsername());
        pack.setReceiver_name(receiver.getUsername());
        pack.setSender_phone(sender.getPhone());
        pack.setReceiver_phone(receiver.getPhone());
        pack.setDescription(description);
        pack.setSend_date(nowDate);
        pack.setStatus(Pack.TRANSIT);
        return packRepository.save(pack);
    }

    @Transactional
    public List<Pack> getAll() {
        return packRepository.findAll();
    }

    @Transactional
    public Pack getById(Long id) {
        return packRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        packRepository.deleteById(id);
    }

    @Transactional
    public Pack setStatus(Long id, int status) {
        Pack pack = packRepository.findById(id).orElse(null);
        if (pack != null) {
            pack.setStatus(status);
            return packRepository.save(pack);
        } else {
            System.out.println("No pack found with id: " + id);
        }
        return null;
    }

    @Transactional
    public Pack sendPack(Long id, String sendDate) {
        Pack pack = packRepository.findById(id).orElse(null);
        if (pack != null) {
            pack.setSend_date(sendDate);
            pack.setStatus(Pack.TRANSIT);
            System.out.println("[Info] from sendPack: pack with id "+id+" has been sent on "+sendDate);
            return packRepository.save(pack);
        } else {
            System.out.println("[Error] from sendPack: No pack found with id: " + id);
        }
        return null;
    }

    @Transactional
    public Pack arrivePack(Long id, String arriveDate) {
        Pack pack = packRepository.findById(id).orElse(null);
        if (pack != null) {
            pack.setDelivery_date(arriveDate);
            pack.setStatus(Pack.DELIVERED);
            System.out.println("[Info] from arrivePack: pack with id "+id+" has arrived on "+arriveDate);
            return packRepository.save(pack);
        } else {
            System.out.println("[Error] from arrivePack: No pack found with id: " + id);
        }
        return null;
    }

    @Transactional
    public Pack receivePack(Long id, String receiveDate) {
        Pack pack = packRepository.findById(id).orElse(null);
        if (pack != null) {
            pack.setPickup_date(receiveDate);
            pack.setStatus(Pack.PICKUP);
            System.out.println("[Info] from receivePack: pack with id "+id+" has been received on "+receiveDate);
            return packRepository.save(pack);
        } else {
            System.out.println("[Error] from receivePack: No pack found with id: " + id);
        }
        return null;
    }

    @Transactional
    public Pack putOnShelf(Long id, String nowDate, Long shelfId) {
        Pack pack = packRepository.findById(id).orElse(null);
        if (pack != null) {
            pack.setStatus(Pack.ON_SHELF);
            pack.setShelf_id(shelfId);
            pack.setOn_shelf_date(nowDate);
            System.out.println("[Info] from putOnShelf: pack with id "+id+" has been put on shelf " + nowDate);
            return packRepository.save(pack);
        } else {
            System.out.println("[Error] from putOnShelf: No pack found with id: " + id);
        }
        return null;
    }
}
