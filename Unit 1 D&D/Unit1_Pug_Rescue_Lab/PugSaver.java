import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "doodle" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		if (list == null) {
			System.out.println("There is no dogs in list. ");
			return;
		}

		ArrayList<Dog> temp = new ArrayList<>();

		for (Dog dog : list) {
			if (!dog.getBreed().equals("Golden Retriever") && !dog.getBreed().equals("Goldendoodle")) {
				temp.add(dog);
			}
		}

		for (Dog dog : list) {
			if (dog.getBreed().equals("Golden Retriever") || dog.getBreed().equals("Goldendoodle")) {
				temp.add(dog);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			list.set(i, temp.get(i));
		}
	
	}



		// int end = list.size() - 1;
		// int i = 0;


		// while (i <= end){
		// 	if (list.get(i).getBreed().equals("Golden Retriever") || list.get(i).getBreed().equals("Goldendoodle")) {
		// 		Dog dogTemp = list.get(end);
		// 		list.set(end, list.get(i));
		// 		list.set(i, dogTemp);
		// 		end--;
		// 	} else {
		// 		i++;
		// 	}

			// 	int y = end;
			// 	while (y> i) {
			// 		if (!list.get(y).getBreed().equals("Golden Retriever") && !list.get(y).getBreed().equals("Goldendoodle")) {
			// 			Dog dogTemp = list.get(y);
			// 			list.set(y, list.get(i));
			// 			list.set(i, dogTemp);
			// 			end--;
			// 			break;
			// 		}
			// 	y--;
			// 	}
				
			// 	if (y == i) {
			// 		i++;
			// 	}
			// } else {
			// 	i++;
			// } 
		
}
