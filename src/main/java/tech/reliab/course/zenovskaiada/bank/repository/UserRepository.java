package tech.reliab.course.zenovskaiada.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.zenovskaiada.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    void deleteById(int id);
}
