package org.eternity.models;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "packages")
public class Pack {
    public static final int TRANSIT = 0;
    public static final int DELIVERED = 1;
    public static final int PICKUP = 2;
    public static final int ON_SHELF = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "sender_name")
    private String sender_name;
    @Column(name = "sender_phone")
    private String sender_phone;
    @Column(name = "receiver_name")
    private String receiver_name;
    @Column(name = "receiver_phone")
    private String receiver_phone;
    @Column(name = "description")
    private String description;
    @Column(name = "status", nullable = false)
    private int status = TRANSIT;
    @Column(name = "tracking_number")
    private String tracking_number;
    @Column(name = "tracking_url")
    private String tracking_url;
    @Column(name = "send_date")
    private String send_date;
    @Column(name = "delivery_date")
    private String delivery_date;
    @Column(name = "pickup_date")
    private String pickup_date;
    @Column(name = "shelf_id")
    private Long shelf_id;
    @Column(name = "on_shelf_date")
    private String on_shelf_date;

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getTracking_url() {
        return tracking_url;
    }

    public void setTracking_url(String tracking_url) {
        this.tracking_url = tracking_url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(Long shelf_id) {
        this.shelf_id = shelf_id;
    }

    public String getSender_phone() {
        return sender_phone;
    }

    public void setSender_phone(String sender_phone) {
        this.sender_phone = sender_phone;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getSend_date() {
        return send_date;
    }

    public void setSend_date(String send_date) {
        this.send_date = send_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getOn_shelf_date() {
        return on_shelf_date;
    }

    public void setOn_shelf_date(String on_shelf_date) {
        this.on_shelf_date = on_shelf_date;
    }
}