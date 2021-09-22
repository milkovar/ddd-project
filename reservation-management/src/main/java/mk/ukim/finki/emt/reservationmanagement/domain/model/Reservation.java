package mk.ukim.finki.emt.reservationmanagement.domain.model;


import mk.ukim.finki.emt.reservationmanagement.domain.valueObject.ApartmentId;
import mk.ukim.finki.emt.reservationmanagement.domain.valueObject.Guest;
import mk.ukim.finki.emt.sharedkarnel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkarnel.domain.date.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity<ReservationId> {

    @AttributeOverride(name = "date", column = @Column(name = "start_date"))
    private Date startDate;
    @AttributeOverride(name = "date", column = @Column(name = "end_date"))
    private Date endDate;
    @AttributeOverride(name = "id", column = @Column(name = "apartmentId"))
    private ApartmentId apartmentId;
    private Guest guest;

}
