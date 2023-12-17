package Animals;

import java.util.Date;

public class Donkey extends BaggageAnimal{

    public Donkey(String name, String commands, Date date) {
        super(name, commands, date);
    }

    @Override
    public String toString() {
        return super.toString()+ "Donkey " + '\''+ this.getName() + '\'' + "\n" +
                "commands: " + this.getCommands().toString() + "\n"+
                "dateOfBirth: " + this.getDateOfBirth();
    }
}