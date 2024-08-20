package hotelreservation.models;

import java.util.Date;

public class Reservation {
	private Room room;
	private Date reservationDate;
	private String status;

	public Reservation(Room room, Date reservationDate, String status) {
		this.room = room;
		this.reservationDate = reservationDate;
		this.status = status;
	}

	public Room getRoom() {
		return room;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public String getStatus() {
		return status;
	}
}
