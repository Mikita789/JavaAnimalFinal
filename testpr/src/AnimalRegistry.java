import java.util.ArrayList;

public class AnimalRegistry implements AnimalRegistryInterface{
    private String title;
    private ArrayList<Animal> allAnimals = new ArrayList<>();


    public AnimalRegistry(String title) {
        this.title = title;
    }



    @Override
    public void addAnimal(Animal animal) {
        this.allAnimals.add(animal);
    }
    public void printAllAnimals(){
        for (Animal animal : allAnimals){
            animal.toString();
        }
    }

    //1
    @Override
    public ArrayList<Animal> searchAnimal(String name) {
        ArrayList<Animal> res = searchAnimalByName(name);
        if (!res.isEmpty()){
            for(Animal animal : res){
                System.out.println(animal.toString());
            }
            return res;

        }else{
            System.out.println("Не удалось найти");
            return null;
        }
    }

    private ArrayList<Animal> searchAnimalByName(String name){
        ArrayList<Animal> res = new ArrayList<>();
        for (Animal animal : this.allAnimals){
            if (animal.getName().equals(name)){
                res.add(animal);
            }
        }

        return res;
    }

    //2
    public void deleteAnimal(String name, String id){
        ArrayList<Animal> resSearch = this.searchAnimalByName(name);
        if (!resSearch.isEmpty()){
            for (Animal animal : resSearch){
                if (animal.getId().equals(id)){
                    this.allAnimals.remove(animal);
                    System.out.println("Объект удален");
                }
            }
        }else{
            System.out.println("Ничего не найдено");
        }

    }

//4
    public void viewCommands(String name, String id){
        ArrayList<Animal> resSearch = this.searchAnimalByName(name);
        if (!resSearch.isEmpty()){
            for (Animal animal : resSearch){
                if (animal.getId().equals(id)){
                    animal.getCommandsArr();
                }else{
                    System.out.println("Ничего не найдено");
                }
            }
        }else{
            System.out.println("Ничего не найдено");
        }
    }

    //5

    @Override
    public void addCommand(String name, String id, String command) {
        ArrayList<Animal> resArr = this.searchAnimalByName(name);
        if (!resArr.isEmpty()){
            for (Animal animal : resArr){
                if (animal.getId().equals(id)){
                    animal.addCommands(command);
                }
            }
        }else{
            System.out.println("Ничего не найдено");
        }
    }

    public <T extends Animal> ArrayList<T> viewTypeAnimal(Class<T> toClass){
        ArrayList<T> resArr = new ArrayList<>();
        for (Animal animal : allAnimals){
            if (toClass.isInstance(animal)){
                resArr.add(toClass.cast(animal));
            }
        }

        if (!resArr.isEmpty()){
            for (Animal animal : resArr){
                animal.toString();
            }
        }else{
            System.out.println("Ничего не найдено");
        }
        return resArr;
    }
}
