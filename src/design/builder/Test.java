package design.builder;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("500GB","8GB")
                .setBluetoothEnabled(true)
        .setGraphicsEnabled(true)
                .build();

        System.out.println(computer);
    }
}
