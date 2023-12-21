import database.DataBase;
import enam.Gender;
import model.Animal;
import model.Person;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        AnimalServiceImpl animalService = new AnimalServiceImpl(dataBase);
        PersonServiceImpl personService = new PersonServiceImpl(dataBase);
        while (true){
            System.out.println("""
                    !.Animal
                    1.Add
                    2.GetAll
                    3.Sort By Name asc
                    4.Sort by name desc
                    5.Filter by gender asc
                    6.Filter by gender desc
                    7.Clear
                    
                    !.Person
                    8.Add
                    9.GetAll
                    10.Sort By Name asc
                    11.Sort by name desc
                    12.Filter by gender female
                    13.Filter by gender male
                    14.Clear
                    
                    
                    """);
            switch (scanner.nextLine()){
                case"1"->{
                    animalService.add(new ArrayList<>(Arrays.asList(
                         new Animal(11,"Cat",3,Gender.FEMALE),
                         new Animal(22,"Dog",5,Gender.MALE),
                         new Animal(33,"Fish",1,Gender.FEMALE),
                         new Animal(44,"Horse",6,Gender.MALE)
                    )));
                }
                case "2" -> System.out.println(animalService.getAll());
                case "3" -> System.out.println(animalService.sortByName(1));
                case "4" -> System.out.println(animalService.sortByName(2));
                case "5" -> System.out.println(animalService.filterByGender(1));
                case "6" -> System.out.println(animalService.filterByGender(2));
                case "7" -> System.out.println(animalService.clear());
                case "8" -> {
                    personService.add(new ArrayList<>(Arrays.asList(
                            new Person(1,"Mika",20,Gender.FEMALE),
                            new Person(2,"Adil",22,Gender.MALE),
                            new Person(3,"Janara",25,Gender.FEMALE),
                            new Person(4,"Danai",14,Gender.MALE)
                    )));
                }
                case "9" -> System.out.println(personService.getAll());
                case "10"-> System.out.println(personService.sortByName(1));
                case "11"-> System.out.println(personService.sortByName(2));
                case "12"-> System.out.println(personService.filterByGender(1));
                case "13"-> System.out.println(personService.filterByGender(2));
                case "14"-> System.out.println(personService.clear());
            }
        }
    }


}