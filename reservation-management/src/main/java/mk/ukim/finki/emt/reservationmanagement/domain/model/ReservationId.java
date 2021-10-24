package mk.ukim.finki.emt.reservationmanagement.domain.model;

import mk.ukim.finki.emt.sharedkarnel.domain.base.DomainObjectId;

public class ReservationId extends DomainObjectId {

    private ReservationId(){
        super(ReservationId.randomId(ReservationId.class).getId());
    }

    protected ReservationId(String uuid) {
        super(uuid);
    }
}
