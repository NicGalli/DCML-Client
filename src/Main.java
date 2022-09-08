import java.io.IOException;



public class Main {



	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("creating base set");
		
		new HospitalClient().createBaseSet();
		System.out.println("base set created");
		NormalBehaviour normalThread = new NormalBehaviour();
		normalThread.start();
		DosBehaviour dosThread = new DosBehaviour();
		dosThread.start();
		
		//10 5-minutes dos attack
		//5 3-minutes integrity attack, internal to the docker, open, modify files
		//7 3-minutes confidentiality attack, read and send tasks outside
		
	}
}