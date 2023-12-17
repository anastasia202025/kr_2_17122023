package Utils;


public class AnimalCounter implements AutoCloseable {

    private static int counter = 0;

    boolean isClosed = false;


    public int getCounter() {
        return counter;
    }

    public void add() throws ResourceException{
        counter++;
    }




    @Override
    public void close() throws ResourceException  {
        isClosed = true;
        if (!isClosed) {
            throw new ResourceException("Ресурс не был закрыт или использовался вне try-with-resources");}
    }

    
    
}