package Animals;

import java.util.Date;

public abstract class BaggageAnimal extends Animal {

    public BaggageAnimal(String name, String commands, Date date) {
        super(name,commands, date);
    }

    @Override
    public String toString() {
        return "Baggage animal" + "\n";
    }

}