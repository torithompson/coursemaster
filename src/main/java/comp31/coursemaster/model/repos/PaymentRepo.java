//Author: Fidy Fiaferana

package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.Payment;

@Repository
public interface PaymentRepo extends CrudRepository<Payment, Integer> {

    public List<Payment> findAll();

    public List<Payment> findAllPaymentsByStudentId(int id);

    public Payment findById(int id);

    public Payment findPaymentByStudentId(int id);
}
