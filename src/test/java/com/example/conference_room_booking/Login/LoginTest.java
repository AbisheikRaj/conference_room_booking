package com.example.conference_room_booking.Login;

import com.example.conference_room_booking.model.loginpage.PMO;
import com.example.conference_room_booking.model.loginpage.RegisterUser;
import com.example.conference_room_booking.model.loginpage.SystemAdministrator;
import com.example.conference_room_booking.repository.loginrepository.LoginRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class LoginTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LoginRepository loginRepository;

    @Test
    @Order(1)
    @DisplayName("create a user in the database")
    void testCreateUser() {
        RegisterUser user = new RegisterUser();
        user.setEmailId("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setName("Ravi");
        user.setAnswer("Kumar");
        user.setRole("ROLE_USER");
        user.setEmployeeId("100020");
        user.setSecurityQuestion("where is your hometown");
        user.setMobileNumber("9865329865");
        user.setAccountEnabled(true);
        RegisterUser savedUser = loginRepository.save(user);

        assertNotNull(savedUser, "Details does not store in the database");
    }

    @Test
    @Order(2)
    @DisplayName("retrieve a user from the database")
    void forgotPasswordTest() {
        RegisterUser registeredUser = new RegisterUser();
        registeredUser.setEmailId("ravikumar@gmail.com");
        RegisterUser existUser = entityManager.find(RegisterUser.class, registeredUser.getEmailId());

        assertEquals(registeredUser.getEmailId(), existUser.getEmailId(), "Given Email ID is not present in the database");
    }

    @Test
    @Order(3)
    @DisplayName("retrieve a PMO from the database")
    void pmoTest() {
        PMO pmo = new PMO();
        pmo.setEmailId("aravindr@gmail.com");
        PMO pmoUser = entityManager.find(PMO.class, pmo.getEmailId());

        assertEquals(pmo.getEmailId(), pmoUser.getEmailId(), "Given Email ID is not present in the database");
    }

    @Test
    @Order(4)
    @DisplayName("retrieve a system administrator from the database")
    void saTest() {
        SystemAdministrator systemAdministrator = new SystemAdministrator();
        systemAdministrator.setEmailId("systemadmin@gmail.com");
        SystemAdministrator existUser = entityManager.find(SystemAdministrator.class, systemAdministrator.getEmailId());

        assertEquals(systemAdministrator.getEmailId(), existUser.getEmailId(), "Given Email ID is not present in the database");
    }
}