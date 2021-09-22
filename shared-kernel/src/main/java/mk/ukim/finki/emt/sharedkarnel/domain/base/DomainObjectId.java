package mk.ukim.finki.emt.sharedkarnel.domain.base;

import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Embeddable
@Setter
public class DomainObjectId implements Serializable {

    private String id;
}
