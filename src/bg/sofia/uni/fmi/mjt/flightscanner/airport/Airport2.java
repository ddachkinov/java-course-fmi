package bg.sofia.uni.fmi.mjt.flightscanner.airport;

public class Airport2 {
    private final String id;
    public Airport2(String id){
        if(id == null || id.isEmpty() || id.isBlank()){
            throw new IllegalArgumentException("The ID cannot be empty");
        }
        this.id = id;
    }
    public String getId(){
        return id;
    }

    @Override
    public String toString(){
        return "Airport " + id;
    }

}
