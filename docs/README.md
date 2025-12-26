- 문제정의
    - Input
        - 구성
            - 전공/교양 과목명
                - 공백 포함 10자이내, 공백만으로 구성 x
            - 학점
                - 1~4학점
            - 성적
                - A~F (9가지)
                - P/NP (2가지)
                - F 또는 NP는 취득학점 x

        - 형태
            - 과목정보

              `<과목명>-<학점>-<성적>`

            - 쉼표(,)로 구분
            - 예시

                ```java
                데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+
                ```

    - Output
        - 구성
            - 평점평균
                - 평균평점 = 과목성적가중치의 총합 / 과목학점의 총합
                - 과목성적가중치 = 과목평점 * 과목학점
                - 평점평균은 소수점 둘째 자리까지 표기(반올림)
                - P/NP는 평점평균 제외
        - 형태
            - 과목 정보

              `[전공 or 교양] 과목명,학점,성적`

                - 예시

                    ```java
                    <과목 목록>
                    [전공] 데이타구조,3,A0
                    [전공] 자바프로그래밍언어,3,B+
                    [전공] 컴퓨터구조,3,C0
                    [전공] 컴퓨터네트워크,3,D+
                    [교양] 미술의이해,3,P
                    [교양] 교양특론3,1,NP
                    [교양] 기독교의이해,2,F
                    ```

            - 취득학점

              `<취득학점>\n@@학점`

                - 예시

                    ```java
                    <취득학점>
                    15학점
                    ```

            - 평균평점 (전공, 교양 과목 모두 포함)

              `<평균평점>\n@@/4.5`

                - 예시

                    ```java
                    <평점평균>
                    2.36 / 4.5
                    ```

            - 전공 평점평균(전공 과목만 포함)

              `<전공 평점평균>\n@@/4.5`

                - 예시

                    ```java
                    <전공 평점평균>
                    2.75 / 4.5
                    ```

            - 예시

                ```java
                전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):
                데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+
                
                교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):
                미술의이해-3-P,교양특론3-1-NP,기독교의이해-2-F
                
                <과목 목록>
                [전공] 데이타구조,3,A0
                [전공] 자바프로그래밍언어,3,B+
                [전공] 컴퓨터구조,3,C0
                [전공] 컴퓨터네트워크,3,D+
                [교양] 미술의이해,3,P
                [교양] 교양특론3,1,NP
                [교양] 기독교의이해,2,F
                
                <취득학점>
                15학점
                
                <평점평균>
                2.36 / 4.5
                
                <전공 평점평균>
                2.75 / 4.5
                ```

    - Exception
        - IllegalArgumentException
            - 사용자가 잘못된 값 입력 → 예외 처리 후 종료
- 설계
    - 구상

        ```java
        1) 과목
        - 과목명
        - 과목학점
        - 과목성적
        
        + 과목성적가중치 계산기: double
        
        2) 전공 extends 과목
        + 입력: 전공
        
        + toString(): String
        
        3) 교양 extends 과목
        + 입력: 교양
        
        + toString(): String
        
        4) 전체 클래스
        - 과목: ArrayList()<>
        - 취득학점: int
        - 평균평점: double
        - 전공 평점평균: double
        
        + 과목학점의 총합: int
        + 평균평점 계산기: void?
        + 전공평점 계산기: void?
        + 입력: void?
        + 출력: void
        ```

    - 구현

      ## C**ourse**

        ```java
        - courseName: String // 과목명
        - credit: String // 과목학점
        - grade: String // 과목성적
        // 변수 선언 이유: 반복 사용될 것 같아서.
        - gradeWeighting: double // 과목성적가중치
        
        + Course() // 기본생성자
        + Course(String courseName, int credit, String grade) // 입력받는 생성자
        + get & set
        + grade2GradePoint(): double // 과목성적을 과목평점으로 전환
        + calculateGradeWeighting(): double // 과목성적가중치 계산기
        + validGrade(String grade): static boolean // 성적 입력 유효성 확인
        + validCredit(String credit): static boolean // 학점 입력 유효성 확인
        + createCourse(String input): static Course // Course 생성기
        ```

      ## Major

        ```java
        + Major() // 기본생성자
        + Major(Course cource) // 입력받는 생성자
        + createMajor(String input): Major // 입력받고 객체 리턴
        + toString(): String // Major 출력
        ```

      ## General Education

        ```java
        + GeneralEducation() // 기본생성자
        + GeneralEducation(Course cource) // 입력받는 생성자
        + createGE(String input): GeneralEducation // 입력받고 객체 리턴
        + toString(): String // General Education 출력
        ```

      ## GpaCalulator.java

        ```java
        - courseList: ArrayList<Course> // 과목 목록
        
        + GpaCalculator() // 기본생성자
        + inputMajor(): void // 전공 과목 입력 받기
        + inputGE(): void // 교양 과목 입력 받기
        + inputCourseList(): void // inputMajor()와 inputGE()로 종합 입력받기
        + validCredit(Course course, String condition): int
        // 학점 유효성 검사
        + calculateTC(): int // 취득학점 계산기
        + calculateGPA(): double // 평점평균 계산기
        + calculateMajorGPA(): double // 전공 평점평균 계산기
        + toString(): String
        
        ```

    - 궁금
        1. 부모 리스트에 자식 클래스를 담으면 어떻게 될까?
            1. 업캐스팅된다.
                1. 다형성 구현
                2. 공통 인터페이스/타입으로 묶어서 처리 가능 ⇒ 부모 클래스로 묶어서 처리가능
                3. 코드의 유연성/유지보수 향상
                4. …
            2. 업캐스팅은 “동적 바인딩”에 의해 실행됨
            3. 제한 사항

                | 호출 가능 | 부모 클래스에 정의된 것만 접근 가능 |
                | --- | --- |
                | 호출 결과 | 자식이 오버라이딩했다면 자식 메서드 실행 |
                | 자식 고유 기능 사용 | 불가능 ⇒ 다운 캐스팅 필요 |
            
            [[Java] 업 캐스팅](https://yeunever.tistory.com/m/40)
            
        2. for 문에서 continue명령어 이후 i는 어떻게 될까?
            1. 다음 index로 넘어간다. 즉 i++실행
        3. camp.nextstep.edu.missionutils.Console 이게 뭐지..?
            
            [우아한테크코스 API 분석](https://anjji.tistory.com/26)
            
        4. switch 람다식
            
            [Java의 새로운 switch 문](https://velog.io/@kirisame/Java%EC%9D%98-%EC%83%88%EB%A1%9C%EC%9A%B4-switch-%EB%AC%B8)
            
        5. 클래스 메소드에서 직접적으로 자기 생성자를 호출할 수 있을까?
            1. 불가능
            2. 객체 = new 를 통해 메모리를 할당해야한다고 한다.
            3. 정확한 출처없음… 잘 모르겠다.
                
                ```java
                public Major inputMajor(String input) {
                        String[] split = input.split("-");
                        this(split[0], Integer.parseInt(split[1]), split[2]);
                        // 여기서 경고뜸. 생성자 본문에서만 사용가능하다고 나온다.
                        return this;
                    }
                ```