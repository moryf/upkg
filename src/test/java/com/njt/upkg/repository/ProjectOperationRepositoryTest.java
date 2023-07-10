package com.njt.upkg.repository;

import com.njt.upkg.domain.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ProjectOperationRepositoryTest {
    @Autowired
    ProjectOperationRepository projectOperationRepository;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void findAllByProject_IdTest(){
        Buyer buyer = new Buyer();
        buyer.setName("John Doe");
        buyer.setEmail("john@doe.com");
        buyer.setNumber("+381111222");
        Buyer savedBuyer = buyerRepository.save(buyer);

        User user = new User("john","john", Role.Admin);

        User savedUser = userRepository.save(user);

        Project project = new Project();

        project.setName("Project 1");
        project.setBuyer(savedBuyer);
        project.setCreatedBy(savedUser);
        project.setStart(new Date());
        project.setDeadline(new Date(new Date().getTime()+1000));


        Project savedProject = projectRepository.save(project);

        ProjectOperation po1 = new ProjectOperation(savedProject,null,null,OperationType.Farbanje,new Date(),new Date(),true);
        ProjectOperation po2 = new ProjectOperation(savedProject,null,null,OperationType.Kovanje,new Date(),new Date(),true);

        projectOperationRepository.saveAll(List.of(po1,po2));
        List<ProjectOperation> operations = projectOperationRepository.findAllByProject_Id(project.getId());
        Assertions.assertEquals(2, operations.size());
        Assertions.assertEquals(OperationType.Farbanje, operations.get(0).getType());
        Assertions.assertEquals(OperationType.Kovanje, operations.get(1).getType());

    }
}
