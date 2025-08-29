import java.util.ArrayList;
//import java.util.Objects;

public class GoldenSaverTester {
    
    public static void main(String[] args) {
        Dog dog1 = new Dog("Louis", "poodle");
        Dog dog2 = new Dog("Fluffy", "goldendoodle");
        Dog dog3 = new Dog("Scooter", "pug");
        Dog dog4 = new Dog("Flash", "bulldog");
        
        ArrayList<Dog> list = new ArrayList();
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        list.add(dog4);

        PugSaver.rescuePugs(list);

    }
    
}
