package s3.cntrl.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String expertise;

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<SessionFormation> sessions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public List<SessionFormation> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionFormation> sessions) {
        this.sessions = sessions;
    }

}
