package comp31.coursemaster.services;

import java.util.List;
import org.springframework.stereotype.Service;
import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.repos.AssignmentRepo;

// Trevor Withers & Tori Thompson
@Service
public class AssignmentService {
    AssignmentRepo assignmentRepo;

    public AssignmentService(AssignmentRepo assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    // public void createAssignment() {

    // }

    // public void deleteAssignment() {

    // }

    // public void updateAssignment() {

    // }

    public List<Assignment> findAssignments(Integer id) {
        return assignmentRepo.findAssignmentByCourseId(id);
    }
}
