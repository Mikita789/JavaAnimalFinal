import java.util.ArrayList;
import java.util.UUID;

public abstract class Animal {
    private String id = UUID.randomUUID().toString();
    private String name;
    private TypeAnimals typeAnimals;
    private String yearOFBirth;

    private ArrayList<String> commandsArr = new ArrayList<>();


    public Animal(String name, TypeAnimals typeAnimals, String yearOFBirth) {
        this.name = name;
        this.typeAnimals = typeAnimals;
        this.yearOFBirth = yearOFBirth;
        this.commandsArr.add("voice");
    }

    public Animal(String name, TypeAnimals typeAnimals) {
        this.name = name;
        this.typeAnimals = typeAnimals;
        this.yearOFBirth = "no data:(";
        this.commandsArr.add("voice");
    }
    public void addCommands(String command){
        this.commandsArr.add(command);
    }

    public String getName() {
        return name;
    }

    public TypeAnimals getTypeAnimals() {
        System.out.println(typeAnimals.toString());
        return typeAnimals;
    }

    public String getYearOFBirth() {
        System.out.println(yearOFBirth);
        return yearOFBirth;
    }

    public ArrayList<String> getCommandsArr() {
        String res = "[ // ";
        for (String command : this.commandsArr){
            res += command + "//" ;
        }
        res += " ]";
        System.out.println(res);
        return commandsArr;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        String currentCommands = "[ ";
        for (String command : this.commandsArr){
            currentCommands += command + " ";
        }
        currentCommands += "]";
        String res = "Animal{ " +
                "name='" + name + '\'' +
                ", typeAnimals=" + typeAnimals.toString() +
                ", yearOFBirth='" + yearOFBirth + '\'' +
                ", commandsArr=" + currentCommands +
                ", id= " + this.id +
                " }";
        return res;
    }
}
