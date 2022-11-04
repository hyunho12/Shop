package com.admin.user;

import com.admin.Repository.RoleRepository;
import com.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository repo;

    @Test
    public void CreateRole(){
        Role roleAdmin = new Role("Admin","manage everything");
        Role saveRole = repo.save(roleAdmin);

        assertThat(saveRole.getId()).isGreaterThan(0);
    }

    @Test
    public void CreateRestRole(){
        Role roleSalesperson = new Role("Salesperson","manage product price" + "customers," +
                " shipping, orders and sales report");
        Role roleEditor = new Role("Editor","manage categories, brands,"+"products,articles and menus");
        Role roleShipper = new Role("Shipper","view products, view orders"+"and update order status");
        Role roleAssistant = new Role("Assistant","manage questions and reviews");

        repo.saveAll(List.of(roleSalesperson,roleEditor,roleShipper,roleAssistant));
    }

}
