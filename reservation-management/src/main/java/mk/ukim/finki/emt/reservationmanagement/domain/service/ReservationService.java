package mk.ukim.finki.emt.reservationmanagement.domain.service;

import mk.ukim.finki.emt.reservationmanagement.domain.exceptions.DateNotAvailableException;
import mk.ukim.finki.emt.reservationmanagement.domain.exceptions.ReservationDoesNotExistException;
import mk.ukim.finki.emt.reservationmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.reservationmanagement.domain.model.ReservationId;
import mk.ukim.finki.emt.reservationmanagement.domain.service.forms.ReservationForm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    ReservationId makeReservation(ReservationForm reservationForm);
    List<Reservation> findAll();
    Optional<Reservation> findById() throws ReservationDoesNotExistException;
    void changeStartDate(Date date) throws DateNotAvailableException;
    void changeEndDate(Date date) throws DateNotAvailableException;
}
