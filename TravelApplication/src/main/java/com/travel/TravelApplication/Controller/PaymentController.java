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
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return paymentService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Payment get(@PathVariable Long id) {
        return paymentService.findById(id);
    }

    @PostMapping("/pay")
    public Payment pay(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.makePayment(paymentRequest.getBookingId(), paymentRequest.getAmount(), paymentRequest.getPaymentMode());
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        paymentService.delete(id); return "Deleted";
    }
}
