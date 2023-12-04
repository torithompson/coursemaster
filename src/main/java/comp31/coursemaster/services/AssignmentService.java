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

    public List<Assignment> findAssignments(Integer id) {
        return assignmentRepo.findAssignmentByCourseId(id);
    }

    public void uploadAssignment(MultipartFile file, Integer assignId) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path uploadDir = Paths.get("src").resolve("main").resolve("java").resolve("comp31").resolve("coursemaster")
                    .resolve("uploads");
            Path filePath = uploadDir.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);
            Assignment assignment = assignmentRepo.findAssignmentById(assignId);
            assignment.setFilePath(filePath.toString());
            assignmentRepo.save(assignment);

            Assignment assignment2 = assignmentRepo.findAssignmentById(assignId);
            System.out.println(assignment2.getFilePath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	public List<Assignment> findAll() {
		return assignmentRepo.findAll();
	}

    public Assignment findAssignmentById(Integer id) {
        return assignmentRepo.findAssignmentById(id);
    }
}
