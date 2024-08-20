package hotelreservation.main;

import hotelreservation.models.Hotel;
import hotelreservation.models.Reservation;
import hotelreservation.models.Room;
import hotelreservation.models.User;
import hotelreservation.services.HotelService;
import hotelreservation.services.ReservationService;
import hotelreservation.services.UserService;
import hotelreservation.utils.DateUtils;
import hotelreservation.utils.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Instanciação dos serviços
		HotelService hotelService = new HotelService();
		ReservationService reservationService = new ReservationService();
		UserService userService = new UserService();

		System.out.println("Bem-vindo ao Sistema de Reservas de Hotel!");

		System.out.print("Digite seu nome: ");
		String userName = scanner.nextLine();
		System.out.print("Digite seu email: ");
		String userEmail = scanner.nextLine();

		if (!InputValidator.isValidEmail(userEmail)) {
			System.out.println("Email inválido. Tente novamente.");
			return;
		}

		User user = new User(userName, userEmail);
		userService.registerUser(user);

		while (true) {
			System.out.println("\nEscolha uma opção:");
			System.out.println("1. Cadastrar hotel");
			System.out.println("2. Cadastrar quarto em hotel");
			System.out.println("3. Listar hotéis disponíveis");
			System.out.println("4. Pesquisar quartos disponíveis");
			System.out.println("5. Fazer uma reserva");
			System.out.println("6. Verificar status da reserva");
			System.out.println("7. Sair");
			System.out.print("Opção: ");
			int option = scanner.nextInt();
			scanner.nextLine(); // Consumir nova linha

			switch (option) {
			case 1:
				// Cadastrar hotel
				System.out.print("Digite o nome do hotel: ");
				String hotelName = scanner.nextLine();
				Hotel newHotel = new Hotel(hotelName);
				hotelService.addHotel(newHotel);
				System.out.println("Hotel cadastrado com sucesso!");
				break;

			case 2:
				// Cadastrar quarto em hotel
				System.out.print("Digite o nome do hotel onde deseja adicionar o quarto: ");
				hotelName = scanner.nextLine();
				Hotel hotel = hotelService.findHotelByName(hotelName);
				if (hotel == null) {
					System.out.println("Hotel não encontrado.");
					break;
				}

				System.out.print("Digite o número do quarto: ");
				int roomNumber = scanner.nextInt();
				scanner.nextLine(); // Consumir nova linha
				System.out.print("Digite o tipo de quarto (Single, Double, Suite): ");
				String roomType = scanner.nextLine();
				System.out.print("Digite o preço do quarto: ");
				double roomPrice = scanner.nextDouble();
				scanner.nextLine(); // Consumir nova linha

				Room newRoom = new Room(roomNumber, roomType, roomPrice, true);
				hotel.addRoom(newRoom);
				System.out.println("Quarto cadastrado com sucesso!");
				break;

			case 3:
				// Listar hotéis disponíveis
				List<Hotel> availableHotels = hotelService.getHotels();
				if (availableHotels.isEmpty()) {
					System.out.println("Nenhum hotel disponível.");
				} else {
					System.out.println("Hotéis disponíveis:");
					for (Hotel h : availableHotels) {
						System.out.println("Hotel: " + h.getName());
					}
				}
				break;

			case 4:
				// Pesquisar quartos disponíveis
				System.out.print("Digite o nome do hotel: ");
				hotelName = scanner.nextLine();
				System.out.print("Digite o tipo de quarto (Single, Double, Suite): ");
				roomType = scanner.nextLine();

				if (!InputValidator.isValidRoomType(roomType)) {
					System.out.println("Tipo de quarto inválido.");
					break;
				}

				List<Room> availableRooms = hotelService.searchAvailableRooms(hotelName, roomType);

				if (availableRooms.isEmpty()) {
					System.out.println("Nenhum quarto disponível encontrado.");
				} else {
					System.out.println("Quartos disponíveis:");
					for (Room room : availableRooms) {
						System.out.println("Número: " + room.getNumber() + ", Preço: " + room.getPrice());
					}
				}
				break;

			case 5:
				// Fazer uma reserva
				System.out.print("Digite o nome do hotel: ");
				hotelName = scanner.nextLine();
				System.out.print("Digite o tipo de quarto (Single, Double, Suite): ");
				roomType = scanner.nextLine();

				if (!InputValidator.isValidRoomType(roomType)) {
					System.out.println("Tipo de quarto inválido.");
					break;
				}

				availableRooms = hotelService.searchAvailableRooms(hotelName, roomType);

				if (availableRooms.isEmpty()) {
					System.out.println("Nenhum quarto disponível encontrado.");
				} else {
					System.out.print("Digite o número do quarto que deseja reservar: ");
					roomNumber = scanner.nextInt();
					scanner.nextLine(); // Consumir nova linha

					Room selectedRoom = null;
					for (Room room : availableRooms) {
						if (room.getNumber() == roomNumber) {
							selectedRoom = room;
							break;
						}
					}

					if (selectedRoom == null) {
						System.out.println("Número de quarto inválido.");
					} else {
						System.out.print("Digite a data da reserva (dd-MM-yyyy): ");
						String dateInput = scanner.nextLine();
						try {
							Reservation reservation = reservationService.createReservation(selectedRoom,
									DateUtils.parseDate(dateInput), "Confirmed");
							System.out.println("Reserva realizada com sucesso!");
							System.out.println("Quarto " + selectedRoom.getNumber() + " reservado para "
									+ DateUtils.formatDate(reservation.getReservationDate()));
						} catch (Exception e) {
							System.out.println("Data inválida. Tente novamente.");
						}
					}
				}
				break;

			case 6:
				// Verificar status da reserva
				System.out.print("Digite o número do quarto para verificar o status da reserva: ");
				roomNumber = scanner.nextInt();
				scanner.nextLine(); // Consumir nova linha

				Room room = new Room(roomNumber, "", 0.0, false);
				Reservation reservation = reservationService.getReservationByRoom(room);

				if (reservation != null) {
					System.out
							.println("Status da reserva para o quarto " + roomNumber + ": " + reservation.getStatus());
					System.out.println("Data da reserva: " + DateUtils.formatDate(reservation.getReservationDate()));
				} else {
					System.out.println("Nenhuma reserva encontrada para o quarto " + roomNumber);
				}
				break;

			case 7:
				System.out.println("Obrigado por utilizar o Sistema de Reservas de Hotel!");
				scanner.close();
				return;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}
}
