public class Horse extends PackAnimal{
    public Horse(String name, String yearOFBirth) {
        super(name, yearOFBirth, TypePackAnimal.HORS);
    }

    public Horse(String name) {
        super(name, TypePackAnimal.HORS);
    }
}
