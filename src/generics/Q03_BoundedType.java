/*
 * Module 4 Assignment - Generics & Collection Framework
 * Name    : Ansh Tiwari
 * Roll No : 36
 * Q       : Generics Q3 - Bounded type parameter: class that accepts only subclasses of Number
 */
package generics;

public class Q03_BoundedType {

    // <T extends Number> -> only Integer, Double, Float, Long, Short, Byte, BigDecimal ... are allowed
    static class NumberBox<T extends Number> {
        private final T[] numbers;

        @SafeVarargs
        NumberBox(T... numbers) { this.numbers = numbers; }

        // Because T is bounded by Number, Number methods like doubleValue() are available
        double sum() {
            double s = 0;
            for (T n : numbers) s += n.doubleValue();
            return s;
        }

        double average() { return numbers.length == 0 ? 0 : sum() / numbers.length; }
    }

    public static void main(String[] args) {
        NumberBox<Integer> ints = new NumberBox<>(10, 20, 30, 40);
        NumberBox<Double> doubles = new NumberBox<>(1.5, 2.5, 3.5);

        System.out.println("Integer box -> sum = " + ints.sum() + ", average = " + ints.average());
        System.out.println("Double box  -> sum = " + doubles.sum() + ", average = " + doubles.average());

        // NumberBox<String> s = new NumberBox<>("a", "b");
        // ^ compile-time error: String is not within bounds of type-variable T
        System.out.println("NumberBox<String> is rejected by the compiler (String is not a Number).");
    }
}
