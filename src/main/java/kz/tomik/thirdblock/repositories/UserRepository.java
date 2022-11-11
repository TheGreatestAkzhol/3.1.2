package kz.tomik.thirdblock.repositories;

import kz.tomik.thirdblock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
