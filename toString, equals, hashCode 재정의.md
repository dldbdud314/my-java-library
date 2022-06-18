### Object의 toString(), equals(), hashCode()

- `toString()`: 객체의 hashcode 출력
- `equals()`: '==' 연산 결과 반환
- `hashcode()`: JVM이 부여한 객체의 해시 코드값

### toString(), equals(), hashCode() 재정의

- `toString()`: 객체의 정보를 문자열 형태로 표현하기
- `equals()`: 논리적 동일함을 구현하기 위해
  - 원랜 서로 다른 인스턴스면 내용이 같아도 false return  
- `hashcode()`: 객체의 동일성을 보장하기 위함 (보통 equals와 함께 재정의)
  - Java에서의 동일성 -> equals의 반환값이 true, 즉 두 객체의 hashcode는 같음  

### 동일성(Identity)와 동등성(Equality)

- 동일성(Identity): 두 객체의 레퍼런스 주소값이 같음
- 동등성(Equality): 두 객체의 내용이 같음 (논리적 동일함)

### 활용
- 언제 많이 쓰는가? 엔티티 객체를 정의할 때
- lombok의 `@EqualsAndHashcode` 사용 가능
