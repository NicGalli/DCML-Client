
import java.time.LocalTime;

public class DosBehaviour extends Thread {
	HospitalClient hospitalClient;

	public void run() {
		System.out.println("dos thread running");
		this.hospitalClient = new HospitalClient();
		while (true) {
			try {

				if (LocalTime.now().getHour() == 5 & LocalTime.now().getMinute() > 15
						& LocalTime.now().getMinute() < 20) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 9 & LocalTime.now().getMinute() > 17
						& LocalTime.now().getMinute() < 22) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 11 & LocalTime.now().getMinute() > 54
						& LocalTime.now().getMinute() < 59) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 15 & LocalTime.now().getMinute() > 8
						& LocalTime.now().getMinute() < 13) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 16 & LocalTime.now().getMinute() > 30
						& LocalTime.now().getMinute() < 35) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 16 & LocalTime.now().getMinute() > 39
						& LocalTime.now().getMinute() < 44) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 17 & LocalTime.now().getMinute() > 25
						& LocalTime.now().getMinute() < 30) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 18 & LocalTime.now().getMinute() > 2
						& LocalTime.now().getMinute() < 7) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 18 & LocalTime.now().getMinute() > 40
						& LocalTime.now().getMinute() < 45) {
					hospitalClient.generateAndGet();
				}
				if (LocalTime.now().getHour() == 23 & LocalTime.now().getMinute() > 1
						& LocalTime.now().getMinute() < 6) {
					hospitalClient.generateAndGet();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
