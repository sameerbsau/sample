package design.creational.abstractfactory;

public class Test {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(new PCFactory("500GB","2.9Ghz","8GB"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("500GB","2.4Ghz","16GB"));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}