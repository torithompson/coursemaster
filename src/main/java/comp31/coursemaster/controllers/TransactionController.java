package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.coursemaster.services.TransactionService;

@Controller
public class TransactionController {
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/payment")
    public String getPayment(Model model) {
        model.addAttribute("Payments", transactionService.findPayments());
        return "payment";
    }
}
