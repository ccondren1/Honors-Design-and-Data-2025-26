import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		if (list == null) {
			System.out.println("There is no dogs in list. ");
		}

		ArrayList<Dog> goldenDogs = new ArrayList();
		
		for (Dog x : list) {
			if (x.getBreed() == "Golden Retriever" || x.getBreed() == "Goldendoodle") {
				list.remove(x);
				goldenDogs.add(x);
			}
		}

		list.addAll(goldenDogs);
	}
}
