package Animals;

import java.util.Date;

public class Horse extends BaggageAnimal{
    
    public Horse(String name, String commands, Date date) {
        super(name, commands, date);
    }

    @Override
    public String toString() {
        return super.toString()+ "Horse " + '\''+ this.getName() + '\'' + "\n" +
                "commands: " + this.getCommands().toString() + "\n"+
                "dateOfBirth: " + this.getDateOfBirth();
    }
}