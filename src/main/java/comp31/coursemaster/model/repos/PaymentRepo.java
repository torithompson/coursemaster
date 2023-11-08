package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Integer> {
    public List<Payment> findall();
}
