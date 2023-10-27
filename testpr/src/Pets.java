public abstract class Pets extends Animal{

    private TypePets typePets;
    public Pets(String name, String yearOFBirth, TypePets typePets) {
        super(name, TypeAnimals.PETS, yearOFBirth);
        this.typePets = typePets;
    }

    public Pets(String name, TypePets typePets) {
        super(name, TypeAnimals.PETS);
        this.typePets = typePets;
    }

    public TypePets getTypePets() {
        return typePets;
    }

    @Override
    public String toString() {
        String res = super.toString() + ". And this is " + this.typePets.toString();
        System.out.println(res);
        return res;
    }
}
