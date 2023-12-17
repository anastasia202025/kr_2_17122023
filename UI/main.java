package UI;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import Animals.Animal;
import Animals.Camel;
import Animals.Cat;
import Animals.Dog;
import Animals.Donkey;
import Animals.Hamster;
import Animals.Horse;
import Utils.AnimalCounter;


public class main {


    static ArrayList<Animal> registry = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        try (AnimalCounter counter = new AnimalCounter();) {
            while(!exit){   
                System.out.println("Введите команду меню: "+"\n"
                + "1 - добавить животное в реестр"+"\n"
                + "2 - показать список всех животных"+"\n"
                + "3 - увидеть список команд, которое выполняет животное"+"\n"
                + "4 - обучить животное новой команде"+"\n"
                + "5 - выход");
                String command = sc.nextLine();
                switch(command){
                    case "1":
                        try {
                            addAnimal();
                            counter.add();
                            System.out.println("Вы добавили " + counter.getCounter()+"-е животное");
                        } catch (ParseException e) {
                            e.getMessage();
                        }
                        break;
                    case "2":
                        showAllAnimals();
                        break;
                    case "3":
                        System.out.println("Введите имя животного: ");
                        showCommands(sc.nextLine());
                        break;
                    case "4":
                        System.out.println("Введите имя животного, которого хотите обучить: ");
                        String name = sc.nextLine();
                        System.out.println("Введите команды через запятую: ");
                        String commands = sc.nextLine();
                        teachCommands(name, commands);
                        break;
                    case "5":
                        exit = true;
                        break;   
                }
        }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public static void showAllAnimals(){
        int i = 1;
        for (Animal animal : registry) {
            System.out.println(i+":"+animal.toString()+"\n");
            i++;
        }
    }

    public static void addAnimal() throws ParseException{
        Animal newAnimal;

            System.out.println("Ведите имя животного:");
            String name = sc.nextLine();

            System.out.println("Введите команды, которые " + name + " умеет выполнять через запятую");
            String commands = sc.nextLine();

            System.out.println("Введите год рождения животного в формате гггг-мм-дд: ");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfBirth = format.parse(sc.nextLine());

            System.out.println("Какое животное вы хотите добавить? (cat, dog, hamster, horse, donkey, camel)");
            String line = sc.nextLine();
            switch(line.toLowerCase()){
                case "cat":
                    newAnimal = new Cat(name, commands, dateOfBirth);
                    registry.add(newAnimal);
                    break;
                case "dog":
                    newAnimal = new Dog(name, commands, dateOfBirth);
                    registry.add(newAnimal);
                    break;
                case "hamster":
                    newAnimal = new Hamster(name, commands, dateOfBirth);
                    registry.add(newAnimal);
                    break;
                case "horse":
                    newAnimal = new Horse(name, commands, dateOfBirth);
                    registry.add(newAnimal);
                    break;
                case "donkey":
                    newAnimal = new Donkey(name, commands, dateOfBirth);
                    registry.add(newAnimal);
                    break;
                case "camel":
                    newAnimal = new Camel(name, commands, dateOfBirth);
                    registry.add(newAnimal);
                    break;
                default:
                    System.out.println("Неверно ввели вид животного");
                    break;
            }
  
    }

    public static void showCommands(String name){
        boolean ifExists = false;
        for (Animal animal : registry) {
            if(animal.getName().equals(name)){
                System.out.println("Команды, которые умеет выполнять "+ animal.getName() + ":\n" + animal.getCommands());
                ifExists = true;
            }
        }
        if(!ifExists){
            System.out.println("Такого животного нет в реестре");
        }

    }

    public static void teachCommands(String name, String commands){
        boolean ifExists = false;
        for (Animal animal : registry) {
            if(animal.getName().equals(name)){
                animal.addCommands(commands);
                System.out.println("Вы научили "+ animal.getName() + " команде(-ам): "+commands);
                ifExists = true;
            }
        }
        if(!ifExists){
            System.out.println("Такого животного нет в реестре");
        }
    }


}