package mk.ukim.finki.emt.apartmentcatalog.domain.valueObjects;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkarnel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address implements ValueObject {

    private final String country;
    private final String city;
    private final int zipCode;
    private final String street;
    private final int number;

    protected Address () {
        country = "";
        city = "";
        zipCode = 0;
        street = "";
        number = 0;
    }

}
