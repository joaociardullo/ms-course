package com.devjoao.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjoao.hrpayroll.entities.Payment;
import com.devjoao.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")//criar um metodo alternativo com Hystrix se caso o hr worker sair do ar 
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

	//Metodo alternativos se chama GetPay......
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, @PathVariable Integer days) {
		Payment payment = new Payment("joao", 400.0, days);
		return ResponseEntity.ok(payment);
	}

}
