package com.example.demo.assignment;

import com.example.demo.assignment.dto.AssignmentCreateDto;
import com.example.demo.assignment.dto.AssignmentDto;
import com.example.demo.assignment.exceptions.InvalidAssignmentException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<AssignmentDto> saveAssigment(@RequestBody @Valid AssignmentCreateDto dto) {
        AssignmentDto savedAssignment;
            savedAssignment = assignmentService.createAssignment(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(savedAssignment.getId()).toUri();
        return ResponseEntity.created(uri).body(savedAssignment);
    }

    @PostMapping("/{id}/end")
    public ResponseEntity<LocalDateTime> finishAssignment(@PathVariable Long id) {
        LocalDateTime endDate = assignmentService.finishAssignment(id);
        return ResponseEntity.ok(endDate);
    }
}
