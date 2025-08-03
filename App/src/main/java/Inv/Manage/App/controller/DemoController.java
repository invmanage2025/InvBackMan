package Inv.Manage.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Inv.Manage.App.service.PurchaseService;

/*
@Component - Bean Entry

@Controller - Bean Entry + URL Mapping Handling
@RestController - Bean Entry + URL Mapping Handling + Output Object --> JSON Convert

@Service - Bean Entry + DAO Inject
@Repository - Bean Entry + DAO Layer
*/


@RestController
@RequestMapping("/purchase/")
public class DemoController {
	
	@Autowired
	PurchaseService serviceLayer;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DemoDTO getDemoOutput() {
		System.out.println("Test");
		
		serviceLayer.getAllPurchase();
		
		DemoDTO resp = new DemoDTO();
		
		resp.setName("Hello");
		resp.setId(123);
		System.out.println(resp.toString());
		return resp;
		
	}
	
}
