package org.ijarvis.EpointTest.SpringRest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author ijarvis
 *	rest Controller
 */
@RestController
public class CustomerRestController {
	private Logger logger=Logger.getLogger(CustomerRestController.class);
	@GetMapping("/resource")
	public List getCustomers() {
		ArrayList<String> strarr=new ArrayList<>();
		strarr.add("a");
		strarr.add("b");
		strarr.add("c");
		strarr.add("d");
		logger.debug("................");
		return strarr;
	}
	@GetMapping("/resource/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {
		ArrayList<String> strarr=new ArrayList<>();
		strarr.add("a");
		strarr.add("b");
		strarr.add("c");
		strarr.add("d");
		return new ResponseEntity(strarr, HttpStatus.OK);
	}
	@GetMapping("/resource1")
	public ResponseEntity getCustomerbyid(@RequestParam("name") String name) {
		ArrayList<String> strarr=new ArrayList<>();
		logger.debug("getCustomerbyid........"+name);
		strarr.add("a");
		return new ResponseEntity(strarr, HttpStatus.OK);
	}
	@PostMapping("/resource")
	public ResponseEntity createCustomer(@RequestBody ArrayList<String> args) {
		logger.debug("data is:"+args);
		return new ResponseEntity("1111", HttpStatus.OK);
	}

}
