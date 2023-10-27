import java.util.ArrayList;

public interface AnimalRegistryInterface {
    void addAnimal(Animal animal);
    void printAllAnimals();

    ArrayList<Animal> searchAnimal(String name);

    void deleteAnimal(String name, String id);
    void viewCommands(String name, String id);

    void addCommand(String name, String id, String command);

    <T extends Animal> ArrayList<T> viewTypeAnimal(Class<T> toClass);

}
