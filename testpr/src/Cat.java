public class Cat extends Pets{
    public Cat(String name, String yearOFBirth) {
        super(name, yearOFBirth, TypePets.CAT);
    }

    public Cat(String name) {
        super(name, TypePets.CAT);
    }
}
