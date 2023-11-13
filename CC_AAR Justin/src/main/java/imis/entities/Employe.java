package imis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("EMPLOYE")
public class Employe extends Personne {
    @OneToMany(mappedBy = "employe")
    private List<ServiceInterne> serviceInternes;

    public List<ServiceInterne> getServiceInternes() {
        return serviceInternes;
    }

    public void setServiceInternes(List<ServiceInterne> serviceInternes) {
        this.serviceInternes = serviceInternes;
    }
}
