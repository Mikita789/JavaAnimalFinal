import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserConsole {
    private Scanner sc = new Scanner(System.in);
    private AnimalRegistryInterface currentRegistry;
    private ArrayList<String> commandsArr = new ArrayList<>();
    private ArrayList<String> menu1command = new ArrayList<>();
    private ArrayList<String> menu2command = new ArrayList<>();
    private ArrayList<String> menu3command = new ArrayList<>();
    private ArrayList<String> menu4command = new ArrayList<>();
    private ArrayList<String> menu5command = new ArrayList<>();
    private ArrayList<String> menu6command = new ArrayList<>();

    public UserConsole(AnimalRegistryInterface currentRegistry){
        commandsArr.add("1 - Добавить новое животное");
        commandsArr.add("2 - Удалить выбранное животное");
        commandsArr.add("3 - Выбрать определенный вид животных");
        commandsArr.add("4 - Просмотреть команды выбранного животного");//
        commandsArr.add("5 - Добавить команду выбранному животному");
        commandsArr.add("6 - Найти животное по имени");
        commandsArr.add("7 - Показать всех животных");
        commandsArr.add("Exit");

        menu1command.add("Введите тип животного(доступно[Собака, Кот, Лошадь, Верблюд]):   ");
        menu1command.add("Введите имя животного:   ");
        menu1command.add("Введите год рождения животного:   ");



        menu2command.add("Веведите имя животного:   ");
        menu2command.add("Веведите ID животного:   ");


        menu3command.add("Какой вид хотите выбрать?(доступно[Собака, Кот, Лошадь, Верблюд, Домашние, Вьючные]):   ");


        menu4command = menu2command;


        menu5command = menu2command;
        menu5command.add("Введите команду, которую нужно добавить:   ");


        menu6command.add("Веведите имя животного:   ");

        this.currentRegistry = currentRegistry;
    }
    void menu(){
        Boolean flag = true;
        System.out.println("Привет! Я виртуальный реестр животных.");
        while (flag){
            for (String command : commandsArr){
                System.out.println(command);
            }
            System.out.println("Сделайте свой выбор");
            String userWord = sc.nextLine().toLowerCase();
            if ((userWord.toLowerCase()).equals("exit")){
                System.out.println("Я завершаю работу");
                flag = false;
            }


            switch (userWord){
                case "1" :
                    String[] userInfo = menu1Selected();
                    if (userInfo[0].toLowerCase().equals("собака")){
                        Dog dog = new Dog(userInfo[1], userInfo[2]);
                        this.currentRegistry.addAnimal(dog);
                        System.out.println("Успешно добавлено");
                    } else if (userInfo[0].toLowerCase().equals("кот")) {
                        Cat cat = new Cat(userInfo[1], userInfo[2]);
                        this.currentRegistry.addAnimal(cat);
                        System.out.println("Успешно добавлено");
                    } else if (userInfo[0].toLowerCase().equals("лошадь")) {
                        Horse horse = new Horse(userInfo[1], userInfo[2]);
                        this.currentRegistry.addAnimal(horse);
                        System.out.println("Успешно добавлено");
                    } else if (userInfo[0].toLowerCase().equals("верблюд")) {
                        Camel camel = new Camel(userInfo[1], userInfo[2]);
                        this.currentRegistry.addAnimal(camel);
                        System.out.println("Успешно добавлено");
                    }else{
                        System.out.println("неверный вид животного.");
                    }
                    break;

                case "2" :
                    String[] userInfo2 = menu2Selected();
                    //currentRegistry вызываем метод удаления
                    currentRegistry.deleteAnimal(userInfo2[0], userInfo2[1]);
                    break;

                case "3":
                    String userTypeAnimal = menu3Selected();
                    //вызываем у currentRegistry фильтр по виду животного
                    //Собака, Кот, Лошадь, Верблюд, Домашние, Вьючные
                    if (userTypeAnimal.equals("собака")){
                        currentRegistry.viewTypeAnimal(Dog.class);
                    } else if (userTypeAnimal.equals("кот")) {
                        currentRegistry.viewTypeAnimal(Cat.class);
                    } else if (userTypeAnimal.equals("лошадь")) {
                        currentRegistry.viewTypeAnimal(Horse.class);
                    } else if (userTypeAnimal.equals("верблюд")) {
                        currentRegistry.viewTypeAnimal(Camel.class);
                    } else if (userTypeAnimal.equals("домашние")) {
                        currentRegistry.viewTypeAnimal(Pets.class);
                    } else if (userTypeAnimal.equals("вьючные")) {
                        currentRegistry.viewTypeAnimal(PackAnimal.class);
                    }
                    break;

                case "4":
                    String[] userInfo4 = menu4Selected();
                    //вызываем у currentRegistry команды животного выбранного пользователем
                    currentRegistry.viewCommands(userInfo4[0], userInfo4[1]);
                    break;

                case "5":
                    String[] userInfo5 =  menu5Selected();
                    //вызываем у currentRegistry добавить команду животного выбранного пользователем
                    currentRegistry.addCommand(userInfo5[0], userInfo5[1], userInfo5[2]);
                    break;

                case "6":
                    String nameAnimal = menu6Selected();
                    //вызываем у currentRegistry поиск животного
                    currentRegistry.searchAnimal(nameAnimal);
                    break;

                case "7":
                    //вызываем у currentRegistry показать всех
                    currentRegistry.printAllAnimals();
                    break;

            }

        }
    }

    private String[] menu1Selected(){
        System.out.println("Сейчас добавим новое животное");
        System.out.print(menu1command.get(0));
        String typeAnimal = sc.nextLine().toLowerCase();
        System.out.print(menu1command.get(1));
        String nameAnimal = sc.nextLine().toLowerCase();
        System.out.print(menu1command.get(2));
        String birthYear = sc.nextLine();

        return new String[]{typeAnimal, nameAnimal, birthYear};
    }
    private String[] menu2Selected(){
        System.out.println("Сейчас удалим новое животное");
        System.out.print(menu2command.get(0));
        String name = sc.nextLine().toLowerCase();
        System.out.print(menu2command.get(1));
        String id = sc.nextLine().toLowerCase();

        return new String[]{name, id};
    }
    private String menu3Selected(){
        System.out.println("Сейчас выберем определенный вид животных");
        System.out.print(menu3command.get(0));
        String type = sc.nextLine().toLowerCase();

        return type;
    }
    private String[] menu4Selected(){
        System.out.println("Сейчас выберем животное и посмотрим его команды");
        System.out.print(menu4command.get(0));
        String name = sc.nextLine().toLowerCase();
        System.out.print(menu4command.get(1));
        String id = sc.nextLine().toLowerCase();

        return new String[]{name, id};
    }

    private String[] menu5Selected(){
        System.out.println("Сейчас добавим команду выбранному животному");
        System.out.print(menu5command.get(0));
        String name = sc.nextLine().toLowerCase();
        System.out.print(menu5command.get(1));
        String id = sc.nextLine().toLowerCase();
        System.out.print(menu5command.get(2));
        String command = sc.nextLine().toLowerCase();
        return new String[]{name, id, command};
    }

    private String menu6Selected(){
        System.out.println("Сейчас надем животного по имени");
        System.out.print(menu6command.get(0));
        String name = sc.nextLine().toLowerCase();
        return name;
    }


}
