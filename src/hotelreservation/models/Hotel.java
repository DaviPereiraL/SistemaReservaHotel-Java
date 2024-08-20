package hotelreservation.models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private String name;
	private List<Room> rooms;

	public Hotel(String name) {
		this.name = name;
		this.rooms = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public List<Room> getAvailableRooms(String roomType) {
		List<Room> availableRooms = new ArrayList<>();
		for (Room room : rooms) {
			if (room.isAvailable() && room.getType().equalsIgnoreCase(roomType)) {
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}
}
