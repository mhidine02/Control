package s3.cntrl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s3.cntrl.model.Formateur;
import s3.cntrl.model.SessionFormation;
import s3.cntrl.repository.SessionFormationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SessionFormationService {

    @Autowired
    private SessionFormationRepository sessionFormationRepository;

    // Récupère toutes les sessions
    public List<SessionFormation> findAll() {
        return sessionFormationRepository.findAll();
    }

    // Recherche une session par ID
    public SessionFormation findById(Long id) {
        return sessionFormationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Session non trouvée avec l'ID : " + id));
    }

    // Ajoute une nouvelle session
    public SessionFormation addSession(SessionFormation sessionFormation) {
        return sessionFormationRepository.save(sessionFormation);
    }

    // Met à jour une session existante
    public SessionFormation updateSession(Long id, SessionFormation sessionFormationDetails) {
        SessionFormation sessionFormation = findById(id);  // Lève une exception si la session n'existe pas

        sessionFormation.setDate(sessionFormationDetails.getDate());
        // Ajouter d'autres champs si nécessaire
        return sessionFormationRepository.save(sessionFormation);
    }
    public void save(SessionFormation sessionFormation) {
        sessionFormationRepository.save(sessionFormation);
    }
    // Supprime une session par ID


    // Récupère toutes les sessions d'un formateur spécifique (si Formateur est une relation dans SessionFormation)
    public List<SessionFormation> findByFormateurId(Long formateurId) {
        return sessionFormationRepository.findByFormateurId(formateurId);
    }
    public void deleteById(Long id) {
        sessionFormationRepository.deleteById(id);
    }


}
