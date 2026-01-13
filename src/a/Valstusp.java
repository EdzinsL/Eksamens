package a;
import java.util.*;
public class Valstusp {
	
	static Map<String, List<String>> robezas = new HashMap<>();
	
	static void pievienot(String valsts, String... kaimini) {
		robezas.put(valsts, Arrays.asList(kaimini));
	}
	
	public static void main(String[] args) {
		
		//pirmā ir valsts un pārejie ir tās kaimiņi kuri tiek ielikti listā
		pievienot("Latvija", "Lietuva", "Igaunija");
		pievienot("Lietuva", "Latvija", "Polija");
		pievienot("Polija", "Lietuva", "Vācija", "Čehija");
		pievienot("Polija", "Lietuva", "Vācija", "Čehija");
		pievienot("Vācija", "Polija", "Austrija", "Čehija");
		pievienot("Čehija", "Vācija", "Polija", "Austrija");
		pievienot("Austrija", "Vācija", "Čehija", "Itālija");
		pievienot("Itālija", "Austrija");
		
		List<String> valstis = new ArrayList<>(robezas.keySet());
		Random rand = new Random();
		
		//random sākuma un beigu valsts, kura nedrīgst būt vienāda
		String sakums = valstis.get(rand.nextInt(valstis.size()));
		String beigas = valstis.get(rand.nextInt(valstis.size()));
		
		while (sakums.equals(beigas)) {
			beigas = valstis.get (rand.nextInt(valstis.size()));
		}
	}
}
