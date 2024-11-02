package s3.cntrl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s3.cntrl.model.Formateur;
import s3.cntrl.repository.FormateurRepository;

import java.util.List;

@Service
public class FormateurService {
    @Autowired
    private FormateurRepository formateurRepository;



    public Formateur findById(Long id) {
        return formateurRepository.findById(id).orElse(null);
    }

    public void save(Formateur formateur) {
        formateurRepository.save(formateur);
    }

    public void deleteById(Long id) {
        formateurRepository.deleteById(id);
    }
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

}
