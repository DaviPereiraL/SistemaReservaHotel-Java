package hotelreservation.services;

import hotelreservation.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<User> users;

	public UserService() {
		this.users = new ArrayList<>();
	}

	public void registerUser(User user) {
		users.add(user);
	}

	public User findUserByEmail(String email) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		return null;
	}
}
