package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.DTOs.PaymentRequest;
import com.travel.TravelApplication.Model.Payment;
import com.travel.TravelApplication.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return service.findAll();
    }

    @GetMapping("/getById/{id}")
    public Payment get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/pay")
    public Payment pay(@RequestBody PaymentRequest paymentRequest) {
        return service.makePayment(paymentRequest.getBookingId(), paymentRequest.getAmount(), paymentRequest.getPaymentMode());
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id); return "Deleted";
    }
}
