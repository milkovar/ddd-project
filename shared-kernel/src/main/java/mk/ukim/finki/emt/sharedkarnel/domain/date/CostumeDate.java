package mk.ukim.finki.emt.sharedkarnel.domain.date;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkarnel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class CostumeDate implements ValueObject {

    private final String date;

    public CostumeDate() {
        this.date = "";
    }

    public CostumeDate(@NonNull LocalDate localDate) {
        this.date = localDate.toString();
    }
}
