package com.yy.functional_interface_and_lambda;

@FunctionalInterface
public interface RunSomething {

    //추상메소드가 1개이면 무조건 functional interface
    void doIt();

}
