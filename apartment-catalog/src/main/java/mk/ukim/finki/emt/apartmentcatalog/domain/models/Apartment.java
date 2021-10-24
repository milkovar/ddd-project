package mk.ukim.finki.emt.apartmentcatalog.domain.models;

import mk.ukim.finki.emt.apartmentcatalog.domain.valueObjects.Address;
import mk.ukim.finki.emt.apartmentcatalog.domain.valueObjects.AvailableDates;
import mk.ukim.finki.emt.sharedkarnel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkarnel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkarnel.domain.financial.Money;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "apartment")
public class Apartment extends AbstractEntity<ApartmentId> {

    private String apartmentName;
    private Address address;
    private Date startDate;
    private Date endDate;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;

    public Apartment(){
        super(DomainObjectId.randomId(ApartmentId.class));
    }

    public List<Date> getAvailableDates(){
        AvailableDates availableDates = new AvailableDates(startDate, endDate);
        return availableDates.getDates();
    }
}
