package Animals;

import java.util.Date;

public class Dog extends Pet{
    public Dog(String name, String commands, Date date) {
        super(name, commands, date);
    }

    @Override
    public String toString() {
        return super.toString()+ "Dog " + '\''+ this.getName() + '\'' + "\n" +
                "commands: " + this.getCommands().toString() + "\n"+
                "dateOfBirth: " + this.getDateOfBirth();
    }
}