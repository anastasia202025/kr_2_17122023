package Animals;

import java.util.Date;

public class Hamster extends Pet{
    public Hamster(String name, String commands, Date date) {
        super(name, commands, date);
    }

    @Override
    public String toString() {
        return super.toString()+ "Hamster " + '\''+ this.getName() + '\'' + "\n" +
                "commands: " + this.getCommands().toString() + "\n"+
                "dateOfBirth: " + this.getDateOfBirth();
    }
}