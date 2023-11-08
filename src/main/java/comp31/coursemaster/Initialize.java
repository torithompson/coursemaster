package comp31.coursemaster;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.StudentRepo;

@Component
public class Initialize implements CommandLineRunner {
    StudentRepo studentRepo;

    public Initialize(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add your initialization code here
        studentRepo.save(null);
        
        
    }
}
