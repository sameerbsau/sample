package design.adapter;

public class SocketObjectAdapterImpl implements SocketAdapter{

    private Socket s = new Socket();
    @Override
    public Volts get120Volts() {
        return s.getVolts();
    }

    @Override
    public Volts get3Volts() {
        Volts v = s.getVolts();
        return convert(v,40);
    }

    @Override
    public Volts get12Volts() {
        Volts v = s.getVolts();
        return convert(v,10);
    }

    public Volts convert(Volts v, int i){
        return new Volts(v.getVolts()/i);
    }
}
