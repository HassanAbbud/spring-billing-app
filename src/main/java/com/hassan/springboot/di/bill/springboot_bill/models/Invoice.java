package com.hassan.springboot.di.bill.springboot_bill.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description.office}")
    private String description;
    @Autowired
    private List<Item> items;

    @PostConstruct
    public void init(){
        System.out.println("Generating Invoice component");
        client.setName(client.getName().concat(" Andres"));
        description = description.concat(" of our client " + client.getName());
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public int getTotal(){
        // int total = 0;
        // for(Item item : items){
        //     total = total + item.getAmount();
        // }
        // return total;
        return items.stream()
        .map(item -> item.getAmount())
        .reduce(0, (sum, amount) -> sum + amount);
    }
}
