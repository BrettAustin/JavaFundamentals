import java.util.Objects;

public class Dog {
    private String name;
    private String breed;
    private int dogID;

    public Dog(String name, String breed, int dogID){
        this.name = name;
        this.breed = breed;
        this.dogID = dogID;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return dogID == dog.dogID && getName().equals(dog.getName()) && breed.equals(dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), breed, dogID);
    }
}
