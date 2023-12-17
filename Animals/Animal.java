package Animals;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Animal {
    private String name;
    private String commands;
    private Date dateOfBirth;

    public Animal(String name, String commands, Date date){
        this.name = name;
        this.commands = commands;
        this.dateOfBirth = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommands() {
        return commands;
    }

    public void addCommands(String commands) {
        this.commands += "," + commands;
    }

    public String getDateOfBirth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}