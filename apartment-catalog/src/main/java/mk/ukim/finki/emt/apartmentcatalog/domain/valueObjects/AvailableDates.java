package mk.ukim.finki.emt.apartmentcatalog.domain.valueObjects;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkarnel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkarnel.domain.date.CostumeDate;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
@Getter
public class AvailableDates implements ValueObject {

    private final List<Date> dates;

    /**
     * Constructor for initializing a list of dates.
     */
    public AvailableDates(Date from, Date to) {
        dates = listAllDates(from, to);
    }

    /**
     * Removes all dates that have been reserved and returns list of {@link Date}
     * that are available for reservation in future.
     *
     * @param from starting date of the reservation.
     * @param to ending date of the reservation.
     * @return {@link AvailableDates}.
     */
    public AvailableDates reserveAvailableDates(Date from, Date to){
        AvailableDates availableDates = new AvailableDates(from, to);
        availableDates
                .getDates()
                .removeAll(listAllDates(from, to));
        return availableDates;
    }

    /**
     * Returns list of all dates for given start and end date.
     *
     * @param startDate start date.
     * @param endDate end date.
     * @return list of {@link CostumeDate}.
     */
    private List<Date> listAllDates(Date startDate, Date endDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDate.ofInstant(startDate.toInstant(), zoneId)
                .datesUntil(LocalDate.ofInstant(endDate.toInstant(), zoneId))
                .map(ld -> Date.from(ld.atStartOfDay(zoneId).toInstant()))
                .collect(Collectors.toList());
    }

}
