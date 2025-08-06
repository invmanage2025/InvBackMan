package Inv.Manage.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import Inv.Manage.App.dto.PurchaseCreateDto;
import Inv.Manage.App.dto.PurchaseDto;
import Inv.Manage.App.dto.PurchaseUpdateDto;
import Inv.Manage.App.service.PurchaseService;
import Inv.Manage.App.utility.InvMessage;
import Inv.Manage.App.utility.InvUtility;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurchaseDto addPurchaseRecord(@RequestBody PurchaseCreateDto createDto ) {
    	//System.out.println(createDto);
    	return purchaseService.createPurchase(createDto);
    }
    
    //is Invoice Exists
    @GetMapping("/isInvoiceExist/{invoiceNo}")
    public ResponseEntity<String> isInvoiceExists(@PathVariable String invoiceNo) {
    	
    	boolean isExist = purchaseService.isInvoiceExist(invoiceNo);
    	
    	if(isExist) {
    		return ResponseEntity.ok("Invoice exists.");
    	}else {
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
    }
    
    //fetch all purchase records
    @GetMapping("/")
    public List<PurchaseDto> fetchAllRecords() {
    	List<PurchaseDto> allRecords = purchaseService.fetchAllPurchaseRecords();
    	return allRecords;
    }
    //Update Purchase Record
    @PutMapping("/")
    public ResponseEntity<PurchaseDto> updatePurchaseRecord(@RequestBody PurchaseUpdateDto updateDto ) {
    	
    	PurchaseDto purchaseDto = purchaseService.updatePurchase(updateDto);
    	
    	if(purchaseDto != null) {
    		InvMessage.Type highestType = InvUtility.getHighestType(purchaseDto.getMessageList());
    		
    		if(highestType != null) {
    			if(InvMessage.Type.ERROR.equals(highestType)) {
    				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(purchaseDto);
    			}
    			else if(InvMessage.Type.WARNING.equals(highestType)) {
    				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(purchaseDto);
    			}
    			else if(InvMessage.Type.INFO.equals(highestType)) {
    				return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(purchaseDto);
    			}
    		}
    		
    		return ResponseEntity.status(HttpStatus.OK).body(purchaseDto);
    	}
    	
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    	
    
}
