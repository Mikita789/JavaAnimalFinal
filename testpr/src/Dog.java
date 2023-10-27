public class Dog extends Pets{
    public Dog(String name, String yearOFBirth) {
        super(name, yearOFBirth, TypePets.DOG);
    }

    public Dog(String name) {
        super(name, TypePets.DOG);
    }
}
