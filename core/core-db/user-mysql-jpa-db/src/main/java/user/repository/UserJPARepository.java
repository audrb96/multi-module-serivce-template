package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.repository.entity.UserEntity;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
}
