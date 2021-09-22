package mk.ukim.finki.emt.sharedkarnel.domain.date;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkarnel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Date implements ValueObject {

    private final String date;

    public Date() {
        this.date = "";
    }

    public Date(@NonNull LocalDate localDate) {
        this.date = localDate.toString();
    }

}
