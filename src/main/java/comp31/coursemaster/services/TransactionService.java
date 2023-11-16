package comp31.coursemaster.services;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.repos.PaymentRepo;

@Service
public class TransactionService {

    PaymentRepo paymentRepo;

    public TransactionService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public void processPayment() {

    }

    public void viewPaymentHistory() {

    }

    public void generatePaymentReport() {
        
    }

    public Iterable<Payment> findPayments() {
        return paymentRepo.findAll();
    }
}
