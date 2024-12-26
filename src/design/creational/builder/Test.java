package design.creational.builder;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("500GB","8GB")
                .setBluetoothEnabled(true)
        .setGraphicsEnabled(true)
                .build();

        System.out.println(computer);

        Computer.ComputerBuilder builder = new Computer.ComputerBuilder("","");
        builder.setBluetoothEnabled(true);
        builder.setBluetoothEnabled(true);
        System.out.println(builder);
    }
}