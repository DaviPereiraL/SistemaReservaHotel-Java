package hotelreservation.services;

import hotelreservation.models.Reservation;
import hotelreservation.models.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationService {
	private List<Reservation> reservations;

	public ReservationService() {
		this.reservations = new ArrayList<>();
	}

	public Reservation createReservation(Room room, Date reservationDate, String status) {
		Reservation reservation = new Reservation(room, reservationDate, status);
		reservations.add(reservation);
		room.setAvailable(false);
		return reservation;
	}

	public Reservation getReservationByRoom(Room room) {
		for (Reservation reservation : reservations) {
			if (reservation.getRoom().getNumber() == room.getNumber()) {
				return reservation;
			}
		}
		return null;
	}
}
