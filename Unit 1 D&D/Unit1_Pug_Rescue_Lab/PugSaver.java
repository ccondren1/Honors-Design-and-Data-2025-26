import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "doodle" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		if (list == null) {
			System.out.println("There is no dogs in list. ");
			return;
		}

		int end = list.size() - 1;

		for (int i = 0; i <= end; i++) {
			if (list.get(i).getBreed().equals("Golden Retriever") || list.get(i).getBreed().equals("Goldendoodle")) {
				for (int y = end; y >= i; y--) {
					if (!list.get(y).getBreed().equals("Golden Retriever") || !list.get(y).getBreed().equals("Goldendoodle")) {
						Dog dogTemp = list.get(y);
						list.set(y, list.get(i));
						list.set(i, dogTemp);
					}
				}

			}
			
		}
		
	}
}
