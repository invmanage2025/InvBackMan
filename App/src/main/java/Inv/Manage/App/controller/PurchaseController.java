package Inv.Manage.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Inv.Manage.App.dto.PurchaseCreateDto;
import Inv.Manage.App.service.PurchaseService;

@RestController
@RequestMapping("/purchase/")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DemoDTO getDemoOutput() {
        System.out.println("Test");

        purchaseService.getAllPurchase();

        DemoDTO resp = new DemoDTO();

        resp.setName("Hello");
        resp.setId(123);
        System.out.println(resp.toString());
        return resp;

    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addPurchaseRecord(@RequestBody PurchaseCreateDto createDto ) {
    	System.out.println(createDto);
    	purchaseService.createPurchase(createDto);
    }
}
