package com.hassan.springboot.di.bill.springboot_bill;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.hassan.springboot.di.bill.springboot_bill.models.Item;
import com.hassan.springboot.di.bill.springboot_bill.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("iPhone", 1000);
        Product p2 = new Product("Google Pixel", 800);
        return Arrays.asList(new Item(p1,2), new Item(p2,4));
    }

    @Bean
    @Primary
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor", 800);
        Product p2 = new Product("Chair", 50);
        Product p3 = new Product("Printer", 300);
        Product p4 = new Product("Desk", 100);
        return Arrays.asList(new Item(p1,5), new Item(p2,10),new Item(p3,2),new Item(p4,10));
    }
}
