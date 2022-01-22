package products;

import datastructures.BinaryTreeNode;

/**
 * @author Ritwik Banerjee
 */
public class Laptop implements Comparable<Laptop> {

    /**
     * This method compares laptops solely based on price
     * this takes in a laptop object
     *
     * @return int val(either: -1, 0, 1)
     */
    @Override
    public int compareTo(Laptop l) {
        return this.price < l.price ? 1 : (this.price > l.price ? -1 : 0);
    }

    /**
     * This method check equality and checks more details than compareTo()
     * this takes in an object
     *
     * @return boolean value
     */
    public boolean equals(Object o) {
        if (!(o instanceof BinaryTreeNode)) return false;
        if (this == o) return true;

        Laptop x = (Laptop) o;
        if (x.getPrice() == this.getPrice()
                && x.getBrand() == this.getBrand()
                && x.getProcessorSpeed() == this.getProcessorSpeed()
                && x.getRam() == this.getRam()
                && x.getScreenSize() == this.getScreenSize()) return true;
        else return false;
    }

    private String brand;
    private double processorSpeed;
    private int ram;
    private int price;
    private double screenSize;

    private Laptop(LaptopBuilder laptopBuilder) {
        this.brand = laptopBuilder.brand;
        this.processorSpeed = laptopBuilder.processorSpeed;
        this.ram = laptopBuilder.ram;
        this.price = laptopBuilder.price;
        this.screenSize = laptopBuilder.screenSize;
    }

    public String getBrand() {
        return brand;
    }

    public double getProcessorSpeed() {
        return processorSpeed;
    }

    public int getRam() {
        return ram;
    }

    public int getPrice() {
        return price;
    }

    public double getScreenSize() {
        return screenSize;
    }

    private static class LaptopBuilder {
        private String brand;
        private double processorSpeed;
        private int ram;
        private int price;
        private double screenSize;

        LaptopBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        LaptopBuilder withProcessorSpeed(double processorSpeed) {
            this.processorSpeed = processorSpeed;
            return this;
        }

        LaptopBuilder withMemory(int ram) {
            this.ram = ram;
            return this;
        }

        LaptopBuilder withPrice(int price) {
            this.price = price;
            return this;
        }

        LaptopBuilder withScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        Laptop build() {
            return new Laptop(this);
        }
    }

    public static Laptop fromString(String s) {
        if (s.isEmpty())
            return null;
        String[] aspects = s.split(",");
        LaptopBuilder builder = new LaptopBuilder();

        try {
            builder.withBrand(aspects[0].toLowerCase());
            builder.withProcessorSpeed(Double.parseDouble(aspects[1]));
            builder.withMemory(Integer.parseInt(aspects[2]));
            builder.withPrice(Integer.parseInt(aspects[3]));
            builder.withScreenSize(Double.parseDouble(aspects[4]));
        } catch (Exception e) {
            System.out.println("Invalid input line.");
        }

        return builder.build();
    }

    // !!DO NOT MODIFY THIS CODE!!
    @Override
    public String toString() {
        return "products.Laptop{" + "brand='" + brand + '\'' +
                ", processorSpeed=" + processorSpeed +
                ", ram=" + ram +
                ", price=" + price +
                ", screenSize=" + screenSize +
                '}';
    }

    // !!DO NOT MODIFY THIS CODE!!
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand.hashCode();
        temp = Double.doubleToLongBits(processorSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ram;
        result = 31 * result + price;
        temp = Double.doubleToLongBits(screenSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}



