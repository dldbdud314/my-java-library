package com.yy.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api dev", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();
        //OnlineClass onlineClass = optional.get(); // 바로 접근 X

        //있건 없건 createNewClass 실행
        OnlineClass onlineClass = optional.orElse(createNewClass());

        //없는 경우 createNewClass 실행 안함
        OnlineClass onlineClass1 = optional.orElseGet(App::createNewClass);

        //없는 경우 에러 던짐
        OnlineClass onlineClass2 = optional.orElseThrow(IllegalStateException::new);

        //filter 사용
        Optional<OnlineClass> onlineClass3 = optional.filter(
                oc -> !oc.isClosed()
        );
        System.out.println(onlineClass3.isEmpty()); //true

        //map
        //flatmap을 싸면 껍질을 n번 까서 줘 (optional이 중첩된 경우 유용)
        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);

        //이렇게 처리할 필요없이
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElseThrow();

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new class");
        return new OnlineClass(10, "new class", false);
    }

}
