package design.creational.builder;

public class Computer {
    //required parameters
    private String HDD;
    private String RAM;
//optional parameters
    private boolean isGraphicsEnabled;
    private boolean isBluetoothEnabled;

    public String getHDD(){
        return HDD;
    }

    public String getRAM(){
        return RAM;
    }

    public boolean isGraphicsEnabled() {
        return isGraphicsEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }
// private constructor
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsEnabled = builder.isGraphicsEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", isGraphicsEnabled=" + isGraphicsEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    public static class ComputerBuilder{
        private String HDD;
        private String RAM;
        //optional parameters
        private boolean isGraphicsEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setGraphicsEnabled(boolean graphicsEnabled) {
            this.isGraphicsEnabled = graphicsEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
        @Override
        public String toString() {
            return "Computer{" +
                    "HDD='" + HDD + '\'' +
                    ", RAM='" + RAM + '\'' +
                    ", isGraphicsEnabled=" + isGraphicsEnabled +
                    ", isBluetoothEnabled=" + isBluetoothEnabled +
                    '}';
        }
    }
}