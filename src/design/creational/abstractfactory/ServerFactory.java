package design.creational.abstractfactory;

public class ServerFactory implements ComputerAbstractFactory{
    private String HDD;
    private String CPU;
    private String RAM;

    public ServerFactory(String HDD, String CPU, String RAM) {
        this.HDD = HDD;
        this.CPU = CPU;
        this.RAM = RAM;
    }

    @Override
    public Computer createComputer() {
        return new Server(CPU, RAM,HDD);
    }
}