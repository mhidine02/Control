package s3.cntrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s3.cntrl.model.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
