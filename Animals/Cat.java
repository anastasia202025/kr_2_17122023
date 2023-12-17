package Animals;

import java.util.Date;

public class Cat extends Pet{
    public Cat(String name, String commands, Date date) {
        super(name, commands, date);
    }

    @Override
    public String toString() {
        return super.toString()+ "Cat " + '\''+ this.getName() + '\'' + "\n" +
                "commands: " + this.getCommands().toString() + "\n"+
                "dateOfBirth: " + this.getDateOfBirth();
    }

}