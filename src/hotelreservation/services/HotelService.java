package hotelreservation.services;

import hotelreservation.models.Hotel;
import hotelreservation.models.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelService {
	private List<Hotel> hotels;

	public HotelService() {
		this.hotels = new ArrayList<>();
	}

	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}

	public Hotel findHotelByName(String name) {
		for (Hotel hotel : hotels) {
			if (hotel.getName().equalsIgnoreCase(name)) {
				return hotel;
			}
		}
		return null;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public List<Room> searchAvailableRooms(String hotelName, String roomType) {
		Hotel hotel = findHotelByName(hotelName);
		if (hotel != null) {
			return hotel.getAvailableRooms(roomType);
		}
		return new ArrayList<>();
	}
}
