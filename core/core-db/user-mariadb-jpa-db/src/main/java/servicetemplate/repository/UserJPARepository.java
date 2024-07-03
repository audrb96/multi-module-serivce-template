package servicetemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servicetemplate.repository.entity.UserEntity;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
}
