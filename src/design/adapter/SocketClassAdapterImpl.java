package design.adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter{
    @Override
    public Volts get120Volts() {
        return getVolts();
    }

    @Override
    public Volts get3Volts() {
        Volts v = getVolts();
        return convert(v,40);
    }

    @Override
    public Volts get12Volts() {
        Volts v = getVolts();
        return convert(v,10);
    }

    public Volts convert(Volts v, int i){
        return new Volts(v.getVolts()/i);
    }

}
