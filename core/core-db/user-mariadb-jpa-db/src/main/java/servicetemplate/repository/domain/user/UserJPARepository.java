package servicetemplate.repository.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import servicetemplate.repository.domain.user.entity.UserEntity;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByName(String name);
}
