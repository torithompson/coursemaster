package comp31.coursemaster.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class TransactionController {
    @GetMapping("/payment")
    public String getPayment() {
        return "payment";
    }
}
