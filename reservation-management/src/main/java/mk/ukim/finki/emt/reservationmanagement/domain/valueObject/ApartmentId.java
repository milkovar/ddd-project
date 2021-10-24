package mk.ukim.finki.emt.reservationmanagement.domain.valueObject;

import mk.ukim.finki.emt.sharedkarnel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ApartmentId extends DomainObjectId {

    private ApartmentId(){
        super(ApartmentId.randomId(ApartmentId.class).getId());
    }

    protected ApartmentId(String uuid) {
        super(uuid);
    }
}
