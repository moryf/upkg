package com.njt.upkg.repository;

import com.njt.upkg.domain.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProjectMaterialRepositoryTest {
    @Autowired
    ProjectMaterialRepository projectMaterialRepository;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MaterialRepository materialRepository;

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

        Material material1 = new Material();
        material1.setName("Ploca");
        material1.setType(MaterialType.Sirov);
        material1.setInDepo(100);
        material1.setWeight(10.5f);
        material1.setArea(2.5f);
        material1.setZinked(false);
        material1.setPainted(true);
        material1.setMeasuringUnit(MeasuringUnit.Metar);
        material1.setPrice(150.0f);

        Material savedMaterial = materialRepository.save(material1);

        ProjectMaterial pm1 = new ProjectMaterial(savedProject,null,savedMaterial,1);
        ProjectMaterial pm2 = new ProjectMaterial(savedProject,null,savedMaterial,4);

        projectMaterialRepository.saveAll(List.of(pm1,pm2));
        List<ProjectMaterial> materials = projectMaterialRepository.findAllByProject_Id(project.getId());
        Assertions.assertEquals(2, materials.size());
        Assertions.assertEquals(1, materials.get(0).getAmount());
        Assertions.assertEquals(4, materials.get(1).getAmount());

    }
}
