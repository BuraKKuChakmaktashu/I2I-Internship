import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {

		// creating 20000 numbers
		String[] numbers = getNumbers();
		String[] packets = { "1000 DK", "1500 DK", "1200 DK", "1750 DK", "2000 DK", "1250 DK" };

		System.out.println("--------------------------------------------------------");

		// VoltDb Connection
		VoltDB voltDbTimePerformans = new VoltDB();
		Connection connectionVoltDb = voltDbTimePerformans.connection("49162", "username", "password");

		voltDbTimePerformans.createSubscribersTable(connectionVoltDb);

		System.out.println("VoltDb insert 20000 subscribers time : "
				+ voltDbTimePerformans.insertSubscribersTime(connectionVoltDb, numbers, packets) + " ms");
		System.out.println("VoltDb get 20000 subscribers time : "
				+ voltDbTimePerformans.getSubscribersTime(connectionVoltDb) + " ms");

		System.out.println(voltDbTimePerformans.dropSubscribersTable(connectionVoltDb));

		System.out.println(voltDbTimePerformans.truncateSubscribersTable(connectionVoltDb));

		voltDbTimePerformans.closeConnection(connectionVoltDb);

	}

	public static String createNumber() {
		String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String randomtelNo = "05";

		boolean isFull = false;

		while (!isFull) {
			int random = (int) Math.ceil(Math.random() * 9);
			randomtelNo = randomtelNo + array[random];
			if (randomtelNo.length() == 11)
				break;
		}

		return randomtelNo;

	}

	public static String[] getNumbers() {

		List<String> numbers = new ArrayList<>();
		for (int i = 0; i < 20000; i++) {

			numbers.add(createNumber());
		}

		String[] array = new String[numbers.size()];
		for (int i = 0; i < numbers.size(); i++)
			array[i] = numbers.get(i);

		return array;

	}

}