// author: Fidy Fiaferana

package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.coursemaster.services.TransactionService;

@Controller
public class TransactionController {
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/payment")
    public String getPayment(Model model, @RequestParam Integer id) {
        model.addAttribute("Payments", transactionService.findPaymentByStudentId(id));
        return "payment";
    }

    @PostMapping("/payment")
    public String processPayment(@RequestParam Integer amount,
            @RequestParam Integer paymentid, @RequestParam Integer id) {
        transactionService.updatePayment(paymentid, amount);
        return "redirect:/payment?id=" + id;
    }
}
