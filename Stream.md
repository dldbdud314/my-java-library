## Stream

연속된 데이터를 처리하는 오퍼레이션의 모음으로, 이 자체는 데이터를 담는 저장소가 아니다

```java
List<String> names = new ArrayList<>();
//데이터 추가
names.stream().map(String::toUpperCase); //이게 또 다른 stream이 되지, 데이터가 바뀌진 않음
```

- 스트림 파이프라인: 0~N개의 중개 오퍼레이터와 1개의 종료 오퍼레이터로 구성

### 중개 오퍼레이터와 종료 오퍼레이터

- 중개 오퍼레이터는 stream을 return 하고 , 종료 오퍼레이터는 stream이 아닌 다른 type를 return 한다!
- 중개 오퍼레이터는 lazy하다 -> 종료 오퍼레이터가 없으면 중개 오퍼레이터는 실행되지 않음

```java
//map - 중개형, collect - 종료형
List<String> collect = names.stream().map((s)-> s.toUpperCase()).collect(Collectiors.toList());
```

### Stream API 활용

https://github.com/dldbdud314/my-java-library/blob/main/java8/src/com/yy/stream/App.java
