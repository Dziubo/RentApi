package com.example.demo.assignment;

import com.example.demo.inventory.asset.AssetRepository;
import com.example.demo.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, UserRepository userRepository, AssetRepository assetRepository) {
        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
        this.assetRepository = assetRepository;
    }
    public AssignmentDto createAssignment(@RequestBody AssignmentDto assignmentDto){
        assignmentRepository
                .findByAsset_IdAndEndOfAssignmentIsNull(
                    assignmentDto.getAssetId()).ifPresent(x->
                        {throw new InvalidAssignmentException("przedmiot" +x.getAsset().getName() + " został już wypożyczony");});
        Assignment assignment = new Assignment();
        userRepository.findUserById(assignmentDto.getUserId()).
                    ifPresentOrElse(assignment::setUser ,
                        ()->{throw new InvalidAssignmentException("użytkownik o podanym id nie istnieje");});
        assetRepository.findById(assignmentDto.getAssetId())
                .ifPresentOrElse(assignment::setAsset ,
                    ()->{throw new InvalidAssignmentException("Przedmiot o podanym id nie istnieje");});
        assignment.setStartOfAssignment(LocalDateTime.now());
        return AssignmentMapper.toDto(assignmentRepository.save(assignment));
    }
    @Transactional
    public LocalDateTime finishAssignment(Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow(NoSuchElementException::new);
        if(assignment.getEndOfAssignment() != null)
            throw new AssignmentAlreadyEnds();
        else
            assignment.setEndOfAssignment(LocalDateTime.now());
        return assignment.getEndOfAssignment();
    }
}
