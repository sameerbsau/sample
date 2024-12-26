package design.creational.abstractfactory;

public abstract class Computer {
    public abstract String getRAM();
    public abstract String getCPU();
    public abstract String getHDD();
@Override
    public String toString(){
    return "CPU="+this.getCPU()+", HDD="+this.getHDD()+", RAm="+this.getRAM();
}

}