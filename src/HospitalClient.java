import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class HospitalClient {
	public final static String BASE_URI = "http://localhost:8080/patients/";
	public static List<String> patientNames;

	public void createBaseSet() throws IOException, InterruptedException {
		patientNames = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			generateAndPost();
		}
	}

	public void generateAndPost() throws IOException, InterruptedException {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		if (post(generatedString) == 201) {
			patientNames.add(generatedString);
		}
	}

	public void generateAndGet() throws IOException, InterruptedException {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		get(generatedString);

	}

	public void getExisting() throws IOException, InterruptedException {
		Random randomizer = new Random();
		String randomPatient = patientNames.get(randomizer.nextInt(patientNames.size()));
		get(randomPatient);
	}

	public int get(String name) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URI + name)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.statusCode();
	}

	public int post(String name) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URI + name))
				.POST(HttpRequest.BodyPublishers.ofString("")).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());
		return response.statusCode();
	}
}
