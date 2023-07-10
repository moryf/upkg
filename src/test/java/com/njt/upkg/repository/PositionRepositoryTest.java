package com.njt.upkg.repository;

import com.njt.upkg.domain.*;
import com.njt.upkg.repository.PositionRepository;
import com.njt.upkg.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
public class PositionRepositoryTest {

    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @Test
    public void testFindAllByProjectId() {
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

        Position position1 = new Position(savedProject, "Position 1", true, false);
        Position position2 = new Position(savedProject, "Position 2", false, true);
        positionRepository.saveAll(List.of(position1, position2));
        List<Position> positions = positionRepository.findAllByProject_Id(project.getId());
        Assertions.assertEquals(2, positions.size());
        Assertions.assertEquals("Position 1", positions.get(0).getName());
        Assertions.assertEquals("Position 2", positions.get(1).getName());
    }
}
