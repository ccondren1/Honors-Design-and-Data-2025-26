//import java.util.ArrayList;
//import java.util.Objects;

public class GoldenSaverTester {
    
    public static void main(String[] args) {
        Dog dog1 = new Dog("Louis", "Poodle");
        Dog dog2 = new Dog("Fluffy", "Goldendoodle");
        Dog dog3 = new Dog("Scooter", "Pug");
        Dog dog4 = new Dog("Flash", "Bulldog");
        
        MyArrayList<Dog> list = new MyArrayList<Dog>();
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        list.add(dog4);

        System.out.println("Initial List: " + list);
        System.out.println("\nCorrected list: ");
        DoodleSaver.rescueDoodles(list);

    }
    
}
