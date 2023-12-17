package Animals;

import java.util.Date;

public class Pet extends Animal{


    public Pet(String name, String commands, Date date) {
        super(name, commands, date);
    }

    @Override
    public String toString() {
        return "Pet" + "\n";
    }
}