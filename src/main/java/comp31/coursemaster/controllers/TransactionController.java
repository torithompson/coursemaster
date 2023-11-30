package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.coursemaster.services.TransactionService;

@Controller
@RequestMapping
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

    @PostMapping("/payment")
    public String processPayment(@RequestParam(name = "amount") Integer amount, @RequestParam(name = "studentid") Integer studentid) {
        transactionService.updatePayment(studentid, amount);
        return "redirect:/payment";
    }
}
