package mk.ukim.finki.emt.apartmentcatalog.domain.valueObjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkarnel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkarnel.domain.date.Date;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
@Getter
public class AvailableDates implements ValueObject {

    private final List<Date> dates;

    /**
     * Constructor for initializing a list of dates.
     */
    public AvailableDates() {
        this.dates = new ArrayList<>();
        setupAvailableDates();
    }

    /**
     * Removes all dates that have been reserved and returns object of {@link AvailableDates}
     * with list of dates that are available for reservation in future.
     *
     * @param reservedDates reserved dates.
     * @return {@link AvailableDates}.
     */
    public AvailableDates reserveAvailableDates(List<Date> reservedDates){
        AvailableDates availableDates = new AvailableDates();
        availableDates.getDates().removeAll(reservedDates);
        return availableDates;
    }

    /**
     * Fills the list with sequential dates starting from the current date to 2050.
     */
    private void setupAvailableDates() {
        List<LocalDate> localDates =
                LocalDate.now()
                        .datesUntil(LocalDate.of(2050, 1,5))
                        .collect(Collectors.toList());
        localDates
                .forEach(date -> dates.add(new Date(date)));
    }

}
