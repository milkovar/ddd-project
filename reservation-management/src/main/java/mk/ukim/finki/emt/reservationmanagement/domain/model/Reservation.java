package mk.ukim.finki.emt.reservationmanagement.domain.model;


import mk.ukim.finki.emt.reservationmanagement.domain.valueObject.ApartmentId;
import mk.ukim.finki.emt.reservationmanagement.domain.valueObject.Guest;
import mk.ukim.finki.emt.sharedkarnel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkarnel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkarnel.domain.base.UserId;
import mk.ukim.finki.emt.sharedkarnel.domain.date.CostumeDate;
import mk.ukim.finki.emt.sharedkarnel.domain.financial.Money;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity<ReservationId> {

    @AttributeOverride(name = "date", column = @Column(name = "start_date"))
    private Date startDate;
    @AttributeOverride(name = "date", column = @Column(name = "end_date"))
    private Date endDate;
    @AttributeOverride(name = "id", column = @Column(name = "apartmentId"))
    private ApartmentId apartmentId;
    @AttributeOverride(name = "id", column = @Column(name = "guestId"))
    private UserId guestId;

    private Money priceForOneNight;

    public Reservation(){
        super(DomainObjectId.randomId(ReservationId.class));
    }

    public Money total() {
        long numDays = DAYS.between(LocalDate.ofInstant(startDate.toInstant(), ZoneId.systemDefault()),
                LocalDate.ofInstant(endDate.toInstant(), ZoneId.systemDefault()));
        return priceForOneNight.multiply((int) numDays);
    }

}
