package comp31.coursemaster.services;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.repos.AssignmentRepo;
import comp31.coursemaster.model.repos.StudentRepo;

// Trevor Withers & Tori Thompson
@Service
public class AssignmentService {
    AssignmentRepo assignmentRepo;
    StudentRepo studentRepo;

    public AssignmentService(AssignmentRepo assignmentRepo, StudentRepo studentRepo) {
        this.assignmentRepo = assignmentRepo;
        this.studentRepo = studentRepo;
    }

    public void createAssignment(Assignment assignment) {
        assignmentRepo.save(assignment);
    }

    public List<Assignment> findAssignments(String courseName) {
        return assignmentRepo.findAssignmentByCourseName(courseName);
    }

    public void uploadAssignment(MultipartFile file, Integer id) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path uploadDir = Paths.get("src").resolve("main").resolve("java").resolve("comp31").resolve("coursemaster")
                    .resolve("uploads");
            Path filePath = uploadDir.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);
            Assignment assignment = assignmentRepo.findAssignmentById(id);
            assignment.setPath(filePath.toString());
            assignmentRepo.save(assignment);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
