public abstract class PackAnimal extends  Animal{
    private TypePackAnimal typePackAnimal;
    public PackAnimal(String name, String yearOFBirth, TypePackAnimal typePackAnimal) {
        super(name, TypeAnimals.PACK_ANIMALS, yearOFBirth);
        this.typePackAnimal = typePackAnimal;
    }

    public PackAnimal(String name, TypePackAnimal typePackAnimal) {
        super(name, TypeAnimals.PACK_ANIMALS);
        this.typePackAnimal = typePackAnimal;
    }

    public TypePackAnimal getTypePackAnimal() {
        return typePackAnimal;
    }

    @Override
    public String toString() {
        String res = super.toString() + ". And this is " + this.typePackAnimal.toString();
        System.out.println(res);
        return res;
    }
}
