package a;
import java.util.*;
public class Valstusp {
	
	static Map<String, List<String>> robezas = new HashMap<>();
	
	static void pievienot(String valsts, String... kaimini) {
		robezas.put(valsts, Arrays.asList(kaimini));
	}
	
	public static void main(String[] args) {
		
		//pirmā ir valsts un pārejie ir tās kaimiņi kuri tiek ielikti listā
		pievienot("Latvija", "Lietuva", "Igaunija", "Krievija", "Baltkrievija");
		pievienot("Igaunija", "Latvija", "Krievija");
		pievienot("Lietuva", "Latvija", "Polija", "Baltkrievija", "Krievija");

		pievienot("Polija", "Lietuva", "Vācija", "Čehija", "Slovākija", "Ukraina", "Baltkrievija", "Krievija");
		pievienot("Vācija", "Polija", "Čehija", "Austrija", "Šveice", "Francija", "Luksemburga", "Beļģija", "Nīderlande", "Dānija");
		pievienot("Čehija", "Vācija", "Polija", "Austrija", "Slovākija");
		pievienot("Slovākija", "Čehija", "Polija", "Ukraina", "Ungārija", "Austrija");
		pievienot("Austrija", "Vācija", "Čehija", "Slovākija", "Ungārija", "Slovēnija", "Itālija", "Šveice");

		pievienot("Itālija", "Austrija", "Slovēnija", "Šveice", "Francija", "Sanmarīno", "Vatikāns");
		pievienot("Slovēnija", "Austrija", "Itālija", "Horvātija", "Ungārija");
		pievienot("Horvātija", "Slovēnija", "Ungārija", "Serbija", "Bosnija un Hercegovina", "Melnkalne");

		pievienot("Ungārija", "Austrija", "Slovākija", "Ukraina", "Rumānija", "Serbija", "Horvātija", "Slovēnija");
		pievienot("Rumānija", "Ungārija", "Serbija", "Bulgārija", "Ukraina", "Moldova");
		pievienot("Bulgārija", "Rumānija", "Serbija", "Ziemeļmaķedonija", "Grieķija", "Turcija");

		pievienot("Serbija", "Ungārija", "Rumānija", "Bulgārija", "Ziemeļmaķedonija", "Kosova", "Melnkalne", "Bosnija un Hercegovina", "Horvātija");
		pievienot("Bosnija un Hercegovina", "Horvātija", "Serbija", "Melnkalne");
		pievienot("Melnkalne", "Bosnija un Hercegovina", "Serbija", "Kosova", "Albānija", "Horvātija");

		pievienot("Albānija", "Melnkalne", "Kosova", "Ziemeļmaķedonija", "Grieķija");
		pievienot("Kosova", "Serbija", "Melnkalne", "Albānija", "Ziemeļmaķedonija");
		pievienot("Ziemeļmaķedonija", "Kosova", "Serbija", "Bulgārija", "Grieķija", "Albānija");

		pievienot("Grieķija", "Albānija", "Ziemeļmaķedonija", "Bulgārija", "Turcija");
		pievienot("Turcija", "Grieķija", "Bulgārija");

		pievienot("Francija", "Beļģija", "Luksemburga", "Vācija", "Šveice", "Itālija", "Spānija", "Monako", "Andora");
		pievienot("Spānija", "Francija", "Portugāle", "Andora");
		pievienot("Portugāle", "Spānija");
		pievienot("Andora", "Francija", "Spānija");
		pievienot("Monako", "Francija");

		pievienot("Beļģija", "Francija", "Nīderlande", "Vācija", "Luksemburga");
		pievienot("Nīderlande", "Beļģija", "Vācija");
		pievienot("Luksemburga", "Beļģija", "Francija", "Vācija");
		pievienot("Šveice", "Vācija", "Austrija", "Itālija", "Francija", "Lihtenšteina");
		pievienot("Lihtenšteina", "Šveice", "Austrija");

		pievienot("Dānija", "Vācija");
		pievienot("Norvēģija", "Zviedrija", "Somija", "Krievija");
		pievienot("Zviedrija", "Norvēģija", "Somija");
		pievienot("Somija", "Zviedrija", "Norvēģija", "Krievija");

		pievienot("Īrija", "Apvienotā Karaliste");
		pievienot("Apvienotā Karaliste", "Īrija");

		pievienot("Ukraina", "Polija", "Slovākija", "Ungārija", "Rumānija", "Moldova", "Baltkrievija", "Krievija");
		pievienot("Moldova", "Rumānija", "Ukraina");
		pievienot("Baltkrievija", "Latvija", "Lietuva", "Polija", "Ukraina", "Krievija");
		pievienot("Krievija", "Norvēģija", "Somija", "Igaunija", "Latvija", "Baltkrievija", "Ukraina");
		
		List<String> valstis = new ArrayList<>(robezas.keySet());
		Random rand = new Random();
		
		//random sākuma un beigu valsts, kura nedrīgst būt vienāda
		String sakums = valstis.get(rand.nextInt(valstis.size()));
		String beigas = valstis.get(rand.nextInt(valstis.size()));
		
		while (sakums.equals(beigas)) {
			beigas = valstis.get (rand.nextInt(valstis.size()));
		}

		 System.out.println("Savieno Eiropas valstis!");
        System.out.println("Sākuma valsts: " + sakums);
        System.out.println("Mērķa valsts: " + beigas);
        System.out.println("Ievadi valstis PA VIENAI (raksti 'stop', lai padotos)\n");

        Scanner sc = new Scanner(System.in);
        String iepriekseja = sakums;

        while (true) {
            System.out.print("Nākamā valsts: ");
            String ievade = sc.nextLine().trim();

            if (ievade.equalsIgnoreCase("stop")) {
                System.out.println("Spēle pārtraukta.");
                break;
            }

            if (!robezas.containsKey(ievade)) {
                System.out.println("Šāda valsts nav sarakstā!");
                break;
            }

            if (!robezas.get(iepriekseja).contains(ievade)) {
                System.out.println(ievade + " nerobežojas ar " + iepriekseja);
                break;
            }

            iepriekseja = ievade;

            if (iepriekseja.equals(beigas)) {
                System.out.println("Apsveicu! Tu sasniedzi mērķa valsti!");
                break;
            }
        }

        sc.close();
    }
}
	}
}

