package com.hqtrivia.dang.repo.user;

import com.hqtrivia.dang.model.user.UserSignUpRequest;
import com.hqtrivia.dang.model.user.UserResponseSuccess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
class UserRepoImpl implements UserRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserSignUpRequest userSignUpRequest) {
        String query = "INSERT INTO users (username, password, email, phone_number, status, role, created_at, updated_at) VALUES (:username, :password, :email, :phone_number, :status, :role, now(), now())";
        entityManager.createNativeQuery(query)
                .setParameter("username", userSignUpRequest.getUsername())
                .setParameter("password", passwordEncoder.encode(userSignUpRequest.getPassword()))
                .setParameter("email", userSignUpRequest.getEmail())
                .setParameter("phone_number", userSignUpRequest.getPhone_number())
                .setParameter("status", "active")
                .setParameter("role", "user")
                .executeUpdate();
    }

    public boolean existUser(UserSignUpRequest userSignUpRequest) {
        String query = "SELECT * FROM users WHERE username = :username OR email = :email OR phone_number = :phone_number";
        return !entityManager.createNativeQuery(query)
                .setParameter("username", userSignUpRequest.getUsername())
                .setParameter("email", userSignUpRequest.getEmail())
                .setParameter("phone_number", userSignUpRequest.getPhone_number())
                .getResultList().isEmpty();
    }

    public boolean existUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = :email";
        return !entityManager.createNativeQuery(query)
                .setParameter("email", email)
                .getResultList().isEmpty();
    }

    public boolean existUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = :username";
        return !entityManager.createNativeQuery(query)
                .setParameter("username", username)
                .getResultList().isEmpty();
    }

    public boolean existUserByPhoneNumber(String phone_number) {
        String query = "SELECT * FROM users WHERE phone_number = :phone_number";
        return !entityManager.createNativeQuery(query)
                .setParameter("phone_number", phone_number)
                .getResultList().isEmpty();
    }

    @SuppressWarnings("unchecked")
    public UserResponseSuccess findUserByEmail(String email) {
        String query = "SELECT id, username, email, role, created_at, updated_at FROM users WHERE email = :email";
        List<Object[]> objResult = entityManager.createNativeQuery(query).setParameter("email", email).getResultList();

        UserResponseSuccess userResSignUpSuccess = new UserResponseSuccess();

        for (Object[] obj : objResult) {
            userResSignUpSuccess.setId((Long) obj[0]);
            userResSignUpSuccess.setUsername((String) obj[1]);
            userResSignUpSuccess.setEmail((String) obj[2]);
            userResSignUpSuccess.setRole((String) obj[3]);
            userResSignUpSuccess.setCreated_at(((Timestamp) obj[4]).toLocalDateTime());
            userResSignUpSuccess.setUpdated_at(((Timestamp) obj[5]).toLocalDateTime());
            break;
        }
        return userResSignUpSuccess;
    }
}
