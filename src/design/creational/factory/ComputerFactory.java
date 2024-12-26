package design.creational.factory;

public class ComputerFactory {
    public static Computer getComputer(String type, String CPU, String HDD, String RAM){
        if("PC".equalsIgnoreCase(type)) return new PC(CPU,HDD,RAM);
        else if("SERVER".equalsIgnoreCase(type)) return new Server(RAM,HDD,CPU);
        return null;
    }
}