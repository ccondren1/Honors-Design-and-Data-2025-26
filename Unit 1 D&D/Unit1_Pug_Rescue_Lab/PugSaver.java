import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		if (list == null) {
			System.out.println("There is no dogs in list. ");
		}

		// ArrayList<Dog> goldenDogs = new ArrayList();
		
		// for (Dog x : list) {
		// 	if (x.getBreed() == "Golden Retriever" || x.getBreed() == "Goldendoodle") {
		// 		list.remove(x);
		// 		goldenDogs.add(x);
		// 	}
		// }

		// list.addAll(goldenDogs);

		System.out.println(list);
		int j = list.size() - 1;
		for (int i = 0; i <= j; i++) {
			if (list.get(i).getBreed().equals("Golden Retriever") || list.get(i).getBreed().equals("Goldendoodle")) {
				for (int y = j; j >= 0; y--) {
					if (!list.get(i).getBreed().equals("Golden Retriever") || !list.get(i).getBreed().equals("Goldendoodle")) {
						Dog dogTemp = list.get(y);
						list.set(y, list.get(i));
						list.set(i, dogTemp);
					}
				}

			}
			
		}
		System.out.println(list);
	}
}
