package com.travel.TravelApplication.Controller;

import com.travel.TravelApplication.DTOs.PaymentRequest;
import com.travel.TravelApplication.Model.Payment;
import com.travel.TravelApplication.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;
    public PaymentController(PaymentService service) { this.service = service; }

    @GetMapping
    public List<Payment> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Payment get(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Payment pay(@RequestBody PaymentRequest req) {
        return service.makePayment(req.getBookingId(), req.getAmount(), req.getPaymentMode());
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) { service.delete(id); return "Deleted"; }
}
