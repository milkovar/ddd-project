package mk.ukim.finki.emt.reservationmanagement.domain.valueObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.sharedkarnel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkarnel.domain.financial.Money;

public class Apartment implements ValueObject {

    private final ApartmentId id;
    private final String name;
    private final Money price;

    @JsonCreator
    public Apartment(ApartmentId id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
