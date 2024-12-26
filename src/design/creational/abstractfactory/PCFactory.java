package design.creational.abstractfactory;

public class PCFactory implements ComputerAbstractFactory{

    private String HDD;
    private String CPU;
    private String RAM;

    public PCFactory(String HDD, String CPU, String RAM) {
        this.HDD = HDD;
        this.CPU = CPU;
        this.RAM = RAM;
    }

    @Override
    public Computer createComputer() {
        return new PC(HDD,CPU,RAM);
    }
}