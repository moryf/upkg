package com.njt.upkg.controllers;

import com.njt.upkg.domain.*;
import com.njt.upkg.dto.*;
import com.njt.upkg.repository.*;
import org.apache.maven.wagon.ResourceDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Rest kontroler sa radom sa projektom, CRUD operacije nad samim projektima kao i njihovim komponentama
 * Kao {@link ProjectOperation},{@link ProjectMaterial},{@link ProjectExpense} i {@link Position}
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {
    /**
     * Repozitorijum projekata
     */
    private final ProjectRepository projectRepository;
    /**
     * Repozitorijum kupaca
     */
    private final BuyerRepository buyerRepository;
    /**
     * Repozitorijum korisnika
     */
    private final UserRepository userRepository;
    /**
     * Repozitorijum pozicija
     */
    private final PositionRepository positionRepository;
    /**
     * Repozitorijum troskova
     */
    private final ProjectExpenseRepository projectExpenseRepository;
    /**
     * Repozitorijum operacija
     */

    private final ProjectOperationRepository projectOperationRepository;
    /**
     * Repozitorijum utroska materijala
     */
    private final ProjectMaterialRepository projectMaterialRepository;
    /**
     * Repozitorijum radnika
     */
    private final WorkerRepository workerRepository;
    /**
     * Repozitorijum materijala
     */
    private final MaterialRepository materialRepository;

    /**
     *
     * {@link Autowired} konstruktor koji inicijalizuje sve repozitorijume u kontroleru
     * @param projectRepository repozitorijum projekata
     * @param buyerRepository repozitorijum kupaca
     * @param userRepository repozitorijum korisnika
     * @param positionRepository repozitorijum pozicija
     * @param projectExpenseRepository repozitorijum troskova
     * @param projectOperationRepository repozitorijum operacija
     * @param projectMaterialRepository rapozitorijum utroska materijala
     * @param workerRepository repozitorijum radnika
     * @param materialRepository repozitorijum materijala
     */
    @Autowired
    public ProjectController(ProjectRepository projectRepository, BuyerRepository buyerRepository, UserRepository userRepository, PositionRepository positionRepository, ProjectExpenseRepository projectExpenseRepository, ProjectOperationRepository projectOperationRepository, ProjectMaterialRepository projectMaterialRepository, WorkerRepository workerRepository, MaterialRepository materialRepository) {
        this.projectRepository = projectRepository;
        this.buyerRepository = buyerRepository;
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.projectExpenseRepository = projectExpenseRepository;
        this.projectOperationRepository = projectOperationRepository;
        this.projectMaterialRepository = projectMaterialRepository;
        this.workerRepository = workerRepository;
        this.materialRepository = materialRepository;
    }

    /**
     * Ruta koja vraca sve projekte iz baze
     * @return ResponseEntity sa svim projektima iz baze
     */
    @GetMapping
    public ResponseEntity<?> getAllProjects(){
        try {
            System.out.println(projectRepository.findAll());
            return ResponseEntity.ok(projectRepository.findAll());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /**
     * Ruta koja vraca projekat po idu
     * @param id id projekta
     * @return ResponseEntity sa projektom po idu ako postoji
     */
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

    /**
     * Ruta koja dodaje novi projekat u bazu
     * @param projectDTO Projekat koji se dodaje u bazu kao {@link ProjectDTO}
     * @return ResponseEntity sa projektom koji je dodat, ako je dodavanje uspesno
     */
    @CrossOrigin
    @PostMapping(value = "/add")
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
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /**
     * rutaza azuriranje projekta u bazi
     * @param id id projekta koji se azurira
     * @param projectDTO novi parametri objekta kao {@link ProjectDTO}
     * @return Azurirani projekat ako je azuriranje uspesno
     */
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

    /**
     * Ruta za brisanje projekta
     * @param id projekta koji se brise
     * @return ResponseEntity sa podatkom o uspesnosti operacije
     */
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

    @PutMapping(value = "/{id}/state")
    public ResponseEntity<?> changeState(@PathVariable("id") Long id, @RequestBody ProjectState state){
        try {
            Optional<Project> optionalProject = projectRepository.findById(id);
            if (!optionalProject.isPresent()) throw new ResourceDoesNotExistException("Projekat sa ovim id-edm ne postoji");
            Project p = optionalProject.get();
            p.setState(state);
            projectRepository.save(p);
            return ResponseEntity.ok(p);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /**
     * Ruta koja vraca sve pozicije za dati projekat
     * @param id id projekta za koji se traze pozicije
     * @return ResponseEntity sa pozicijama projekta ako postoje u bazi
     */
    @GetMapping(value = "/{id}/positions")
    public ResponseEntity<?> getPositons(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(positionRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /**
     * Ruta za dodavanje pozicije na projekat
     * @param id id projekta na koji sedodaje pozicija
     * @param positionDTO Atrubuti pozicije koja se dodaje kao {@link PositionDTO}
     * @return ResponseEntity sa dodatom pozicijom, ako je uspesno
     */
    @PostMapping(value = "/{id}/positions/add")
    public ResponseEntity<?> addPosition(@PathVariable("id") Long id, @RequestBody PositionDTO positionDTO){
        System.out.println(positionDTO);
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

    /**
     * Ruta koja vraca sve troskove za dati projekat
     * @param id id projekta za koji se traze troskovi
     * @return ResponseEntity sa troskovima projekta ako postoje u bazi
     */
    @GetMapping(value = "/{id}/expenses")
    public ResponseEntity<?> getExpenses(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(projectExpenseRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    /**
     * Ruta za dodavanje troska na projekat
     * @param id id projekta na koji se dodaje trosak
     * @param projectExpenseDTO Atrubuti troska koja se dodaje kao {@link ProjectExpenseDTO}
     * @return ResponseEntity sa dodatim troskom, ako je uspesno
     */
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
    /**
     * Ruta koja vraca sve operacije za dati projekat
     * @param id id projekta za koji se traze operacije
     * @return ResponseEntity sa operacijama projekta ako postoje u bazi
     */
    @GetMapping(value = "/{id}/operations")
    public ResponseEntity<?> getOperations(@PathVariable("id") Long id){

        try {
            return ResponseEntity.ok(projectOperationRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    /**
     * Ruta za dodavanje operacije na projekat
     * @param id id projekta na koji se dodaje operacija
     * @param projectOperationDTO Atrubuti operaccije koja se dodaje kao {@link ProjectOperationDTO}
     * @return ResponseEntity sa dodatom operacijom, ako je uspesno
     */
    @PostMapping(value = "/{id}/operations/add")
    public ResponseEntity<?> addOperation(@PathVariable("id") Long id, @RequestBody ProjectOperationDTO projectOperationDTO){
        System.out.println(projectOperationDTO);
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
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    /**
     * Ruta koja vraca sve materijale utrosene za dati projekat
     * @param id id projekta za koji se traze utroseni materijali
     * @return ResponseEntity sa utroscima materijala projekta ako postoje u bazi
     */
    @GetMapping(value = "/{id}/materials")
    public ResponseEntity<?> getMaterials(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(projectMaterialRepository.findAllByProject_Id(id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    /**
     * Ruta za dodavanje utroska materijala na projekat
     * @param id id projekta na koji se dodaje utrosak materijala
     * @param projectMaterialDTO Atrubuti utroska materijala koja se dodaje kao {@link ProjectMaterialDTO}
     * @return ResponseEntity sa dodatim utroskom materijala, ako je uspesno
     */
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
