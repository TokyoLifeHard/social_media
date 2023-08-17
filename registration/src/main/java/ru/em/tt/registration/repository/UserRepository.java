package ru.em.tt.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.em.tt.registration.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
