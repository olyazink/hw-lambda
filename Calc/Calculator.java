package Calc;

import java.util.function.*;

public class Calculator implements Supplier {

    static Supplier<Calculator> instance = Calculator::new;

    @Override
    public Object get() {
        return instance;
    }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    //BinaryOperator<Integer> devide = (x, y) -> x / y;  - нет проверки деления на ноль

         BinaryOperator<Integer> devide = (x, y) -> {
            try {
                // Обработать проверку деления на 0
                if (y == 0)
                    throw new ArithmeticException("Exception: divide by zero.");
                return x / y;
            }
            catch (ArithmeticException e) {
                System.out.println(e.getMessage()); // Вывести сообщение
                return 0;
            }
        };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}
