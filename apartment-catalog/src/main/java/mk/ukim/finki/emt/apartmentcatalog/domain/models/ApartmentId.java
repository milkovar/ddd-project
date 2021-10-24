package mk.ukim.finki.emt.apartmentcatalog.domain.models;

import mk.ukim.finki.emt.sharedkarnel.domain.base.DomainObjectId;

public class ApartmentId extends DomainObjectId {

    private ApartmentId() {
        super(ApartmentId.randomId(ApartmentId.class).getId());
    }

    protected ApartmentId(String uuid) {
        super(uuid);
    }
}
