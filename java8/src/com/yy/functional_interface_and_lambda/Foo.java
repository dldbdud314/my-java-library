package com.yy.functional_interface_and_lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
* 익명 내부 클래스를 람다 표현식으로 간추릴 수 있다
* 함수처럼 생겼지만 실질적으로 함수형 인터페이스를 inline으로 구현한 오브젝트
 */
public class Foo {

    public static void main(String[] args) {
        RunSomething runSomething = () -> System.out.println("Hello");

        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1)); //11

        Function<Integer, Integer> plus20 = (a) -> a + 20;
        System.out.println(plus20.apply(1)); //21

        Function<Integer, Integer> multiply2 = (b) -> b * 2;

        //조합 가능
        Function<Integer, Integer> multiply2andPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2andPlus10.apply(2)); //2 -> 4 -> 14

        Function<Integer, Integer> plus10andMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10andMultiply2.apply(2)); //2 -> 12 -> 24

        Consumer<Integer> printT = (t) -> System.out.println(t);
        printT.accept(10); // 10

        Supplier<Integer> print10 = () -> 10;
        System.out.println(print10.get()); //10

        Predicate<Integer> isEven = (i) -> i%2 == 0;
        System.out.println(isEven.test(3)); //false
    }
}
