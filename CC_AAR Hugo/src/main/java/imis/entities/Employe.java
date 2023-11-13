package imis.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employe extends Personne {

    @OneToMany(mappedBy = "employe")
    private List<ServiceInterne> serviceInternes;

    @ManyToMany(mappedBy = "employes")
    private List<Echange> echanges;

    public List<ServiceInterne> getServiceInternes() {
        return serviceInternes;
    }

    public void setServiceInternes(List<ServiceInterne> serviceInternes) {
        this.serviceInternes = serviceInternes;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }
}
