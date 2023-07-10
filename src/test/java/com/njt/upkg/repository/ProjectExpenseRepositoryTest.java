package com.njt.upkg.repository;

import com.njt.upkg.domain.*;
import com.njt.upkg.repository.PositionRepository;
import com.njt.upkg.repository.ProjectExpenseRepository;
import com.njt.upkg.repository.ProjectOperationRepository;
import com.njt.upkg.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProjectExpenseRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuyerRepository buyerRepository;


    @Autowired
    private ProjectExpenseRepository projectExpenseRepository;


    @Test
    public void testFindAllByProjectId() {
        Buyer buyer = new Buyer();
        buyer.setName("John Doe");
        buyer.setEmail("john@doe.com");
        buyer.setNumber("+381111222");
        Buyer savedBuyer = buyerRepository.save(buyer);

        User user = new User("john", "john", Role.Admin);

        User savedUser = userRepository.save(user);

        Project project = new Project();

        project.setName("Project 1");
        project.setBuyer(savedBuyer);
        project.setCreatedBy(savedUser);
        project.setStart(new Date());
        project.setDeadline(new Date(new Date().getTime() + 1000));

        Project savedProject = projectRepository.save(project);

        ProjectExpense expense1 = new ProjectExpense(project, null, null, 500);
        projectExpenseRepository.save(expense1);

        ProjectExpense expense2 = new ProjectExpense(project, null, null, 800);
        projectExpenseRepository.save(expense2);

        List<ProjectExpense> expensesForProject1 = projectExpenseRepository.findAllByProject_Id(savedProject.getId());

        Assertions.assertEquals(2, expensesForProject1.size());

        Assertions.assertTrue(expensesForProject1.stream().allMatch(e -> e.getProject().getId().equals(savedProject.getId())));
    }

}

