package s3.cntrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s3.cntrl.model.SessionFormation;

import java.util.List;

public interface SessionFormationRepository extends JpaRepository<SessionFormation, Long> {


    List<SessionFormation> findByFormateurId(Long formateurId);
}
