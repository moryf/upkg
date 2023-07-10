package com.njt.upkg.controllers;

import com.njt.upkg.domain.*;
import com.njt.upkg.dto.*;
import com.njt.upkg.repository.*;
import org.apache.maven.wagon.ResourceDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final BuyerRepository buyerRepository;
    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final ProjectExpenseRepository projectExpenseRepository;

    private final ProjectOperationRepository projectOperationRepository;
    private final ProjectMaterialRepository projectMaterialRepository;
    private final WorkerRepository workerRepository;
    private final MaterialRepository materialRepository;


    @Autowired
    public ProjectController(ProjectRepository projectService, BuyerRepository buyerRepository, UserRepository userRepository, PositionRepository positionRepository, ProjectExpenseRepository projectExpenseRepository, ProjectOperationRepository projectOperationRepository, ProjectMaterialRepository projectMaterialRepository, WorkerRepository workerRepository, MaterialRepository materialRepository) {
        this.projectRepository = projectService;
        this.buyerRepository = buyerRepository;
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.projectExpenseRepository = projectExpenseRepository;
        this.projectOperationRepository = projectOperationRepository;
        this.projectMaterialRepository = projectMaterialRepository;
        this.workerRepository = workerRepository;
        this.materialRepository = materialRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllProjects(){
        try {
            return ResponseEntity.ok(projectRepository.findAll());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findProjectByID(@PathVariable("id") Long id){
        try {
            Optional<Project> o = projectRepository.findById(id);
            if (o.isPresent()) return ResponseEntity.ok(o.get());
            else throw new ResourceDoesNotExistException("Projekat sa ovim id-em ne postoji");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public ResponseEntity<?> addProject(@RequestBody ProjectDTO projectDTO){
        System.out.println(projectDTO);
        try {
            System.out.println(projectDTO);
            Optional<User> u = userRepository.findById(projectDTO.getCreatedByID());
            if (!u.isPresent()) throw new ResourceDoesNotExistException("Korisnik sa ovim id-em ne postoji");
            Optional<Buyer> b = buyerRepository.findById(projectDTO.getBuyerID());
            if (!b.isPresent()) throw new ResourceDoesNotExistException("Kupac sa ovim id-em ne postoji");
            Project p = new Project();
            p.setBuyer(b.get());
            p.setName(projectDTO.getName());
            p.setDeadline(projectDTO.getDeadline());
            p.setStart(projectDTO.getStart());
            p.setState(projectDTO.getState());
            p.setCreatedBy(u.get());
            p.setValue(projectDTO.getValue());
            projectRepository.save(p);
            System.out.println(p);
            return ResponseEntity.ok(p);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") Long id, ProjectDTO projectDTO){
        try {
            Optional<Project> optionalProject = projectRepository.findById(id);
            if (!optionalProject.isPresent()) throw new ResourceDoesNotExistException("Projekat sa ovim id-edm ne postoji");
            Project p = optionalProject.get();
            Optional<User> u = userRepository.findById(projectDTO.getCreatedByID());
            if (!u.isPresent()) throw new ResourceDoesNotExistException("Korisnik sa ovim id-em ne postoji");
            Optional<Buyer> b = buyerRepository.findById(projectDTO.getBuyerID());
            if (!b.isPresent()) throw new ResourceDoesNotExistException("Kupac sa ovim id-em ne postoji");
            p.setBuyer(b.get());
            p.setName(projectDTO.getName());
            p.setDeadline(projectDTO.getDeadline());
            p.setStart(projectDTO.getStart());
            p.setState(projectDTO.getState());
            p.setCreatedBy(u.get());
            p.setValue(projectDTO.getValue());
            projectRepository.save(p);
            return ResponseEntity.ok(p);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
        try {
            projectRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e ){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}/positions")
    public ResponseEntity<?> getPositons(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(positionRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping(value = "/{id}/positions/add")
    public ResponseEntity<?> addPosition(@PathVariable("id") Long id, @RequestBody PositionDTO positionDTO){
        try {
            Project p = projectRepository.findById(id).get();
            Position position = new Position(p,positionDTO.getName(), positionDTO.isRedyToMount(), positionDTO.isMounted());
            positionRepository.save(position);
            return ResponseEntity.ok(position);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    @GetMapping(value = "/{id}/expenses")
    public ResponseEntity<?> getExpenses(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(projectExpenseRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @PostMapping(value = "/{id}/expenses/add")
    public ResponseEntity<?> addExpense(@PathVariable("id") Long id, @RequestBody ProjectExpenseDTO projectExpenseDTO){
        try {
            Project p = projectRepository.findById(id).get();
            ProjectExpense projectExpense= new ProjectExpense(p,positionRepository.findById(projectExpenseDTO.getPositionID()).orElse(null),
                    projectOperationRepository.findById(projectExpenseDTO.getOperationID()).orElse(null),
                    projectExpenseDTO.getValue());
            projectExpenseRepository.save(projectExpense);
            return ResponseEntity.ok(projectExpense);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}/operations")
    public ResponseEntity<?> getOperations(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(projectOperationRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @PostMapping(value = "/{id}/operations/add")
    public ResponseEntity<?> addOperation(@PathVariable("id") Long id, @RequestBody ProjectOperationDTO projectOperationDTO){
        try {
            Project p = projectRepository.findById(id).get();
            ProjectOperation projectOperation = new ProjectOperation(p,
                    positionRepository.findById(projectOperationDTO.getPositionID()).orElse(null),
                    workerRepository.findById(projectOperationDTO.getWorkerID()).orElse(null),
                    projectOperationDTO.getType(),
                    projectOperationDTO.getStart(),
                    projectOperationDTO.getEnded(),
                    projectOperationDTO.isActive());
            projectOperationRepository.save(projectOperation);
            return ResponseEntity.ok(projectOperation);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}/materials")
    public ResponseEntity<?> getMaterials(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(projectMaterialRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping(value = "/{id}/materials/add")
    public ResponseEntity<?> addMaterial(@PathVariable("id") Long id, @RequestBody ProjectMaterialDTO projectMaterialDTO){
        try {
            Project p = projectRepository.findById(id).get();
            ProjectMaterial projectMaterial = new ProjectMaterial(p,
                    positionRepository.findById(projectMaterialDTO.getPositionID()).orElse(null),
                    materialRepository.findById(projectMaterialDTO.getMaterialID()).orElseThrow(),
                    projectMaterialDTO.getAmount());
            projectMaterialRepository.save(projectMaterial);
            return ResponseEntity.ok(projectMaterial);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
