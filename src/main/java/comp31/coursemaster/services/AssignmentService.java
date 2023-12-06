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
import jakarta.transaction.Transactional;

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

    @Transactional
    public String uploadAssignment(MultipartFile file, Integer assignId) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path uploadDir = Paths.get("uploads");
            Path filePath = uploadDir.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);
            Assignment assignment = assignmentRepo.findAssignmentById(assignId);
            assignment.setFilePath(filePath.toString());
            assignmentRepo.save(assignment);
            return "uploadSuccess";
        } catch (IOException e) {
            e.printStackTrace();
            return "uploadFailed";
        }

    }

	public List<Assignment> findAll() {
		return assignmentRepo.findAll();
	}

    public Assignment findAssignmentById(Integer id) {
        return assignmentRepo.findAssignmentById(id);
    }

    public List<Assignment> findAssignmentsByCourse(Integer courseId) {
        return assignmentRepo.findAssignmentByCourseId(courseId);
    }

    public List<Assignment> findSubmittedAssignments() {
        return assignmentRepo.findByFilePathIsNotNull();
    }
}
