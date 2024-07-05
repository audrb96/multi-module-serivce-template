package servicetemplate.repository.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import servicetemplate.repository.domain.user.entity.UserEntity;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
}
