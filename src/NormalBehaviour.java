import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class NormalBehaviour extends Thread {
	HospitalClient hospitalClient;

	public void run() {
		System.out.println("normal thread running");
		this.hospitalClient = new HospitalClient();
		int frequencyParameter;
		while (true) {
			try {
				// choose random behaviour, out of possible five
				// change frequency according to hour of the day
				if (LocalTime.now().getHour() > 9 & LocalTime.now().getHour() < 18)
					frequencyParameter = 10;
				else
					frequencyParameter = 100;

				switch ((int) Math.round(frequencyParameter * Math.random())) {

				case 0:
					hospitalClient.generateAndPost();
					break;
				case 1:
					hospitalClient.getExisting();
					break;
				case 2:
					hospitalClient.getExisting();
					break;
				case 3:
					hospitalClient.getExisting();
					break;
				case 4:
					hospitalClient.generateAndGet();
					break;
				}
				TimeUnit.SECONDS.sleep(Math.round(frequencyParameter * Math.random()) / 2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
