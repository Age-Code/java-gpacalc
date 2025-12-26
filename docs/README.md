# 학점 계산기

상태: 과제

[GitHub - Age-Code/java-gpacalc: [12기] 백엔드 트랙 사전과제](https://github.com/Age-Code/java-gpacalc.git)

- 개요

  # 백엔드 트랙 과제 - 학점 계산기

    - [기능 요구사항](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
    - [입출력 요구사항](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
        - [입력](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
        - [출력](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
        - [실행결과 예시](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
    - [프로그래밍 요구사항](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
        - [테스트 실행 가이드](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
        - [라이브러리](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)
    - [과제 진행방식](https://www.notion.so/2d4ccad2592d80218b3fe6bae8151d50?pvs=21)

    ---

  ## 기능 요구사항

  전공/교양 과목명과 학점, 성적을 입력하면 평점평균을 계산하는 CLI 기반 학점 계산기를 구현하라.

    - `과목명`은 공백 포함 10자 이내이며, 공백만으로 구성될 수 없다.
    - `과목학점`은 아래와 같이 1학점부터 4학점까지 존재한다.

        | 학점 | 1 | 2 | 3 | 4 |
        | --- | --- | --- | --- | --- |
    - `과목성적`은 크게 `ABCDF 과목`과 `P/NP 과목`으로 구분된다.
        - `ABCDF 과목`은 성적을 A부터 F까지 부여하며, 9가지 등급이 존재한다.
        - `P/NP 과목`은 성적을 P와 NP 두 가지 등급으로 부여한다.
        - F 또는 NP 성적을 받은 과목의 학점은 `취득학점`에 포함되지 않는다.

            | 성적 | A+ | A0 | B+ | B0 | C+ | C0 | D+ | D0 | F | P | NP |
            | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
            | 평점 | 4.5 | 4.0 | 3.5 | 3.0 | 2.5 | 2.0 | 1.5 | 1.0 | 0 | Pass | Not Passed |
    - `평점평균` 계산 공식은 다음과 같다.
        - `평점평균` = `과목성적가중치의 총합` / `과목학점의 총합`
        - `과목성적가중치` = `과목평점` * `과목학점`
        - 평점평균은 소수점 셋째 자리에서 반올림하여 둘째 자리까지 표현한다.
        - P/NP 과목은 평점평균 계산에서 제외한다.
    - 평점평균을 출력한 후에는 애플리케이션을 종료한다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
    
    ## 입출력 요구사항
    
    ### 입력
    
    - 과목 정보(`<과목명>-<학점>-<성적>`)
    - 과목 정보는 쉼표(,)를 기준으로 구분한다.
    
    ```
    데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+
    ```
    
    ### 출력
    
    - 입력한 과목 정보(과목명, 학점, 성적)
    - 과목명 앞에 과목유형(전공/교양)을 표시한다.
        - 전공 과목은 `[전공]`으로 표시한다.
        - 교양 과목은 `[교양]`으로 표시한다.
    
    ```
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
    
    ```
    <취득학점>
    15학점
    ```
    
    - 평점평균(전공, 교양 과목 모두 포함)
    
    ```
    <평점평균>
    2.36 / 4.5
    ```
    
    - 전공 평점평균(전공 과목만 포함)
    
    ```
    <전공 평점평균>
    2.75 / 4.5
    ```
    
    ### 실행결과 예시
    
    ```
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
    
    ## 프로그래밍 요구사항
    
    - JDK 17 버전에서 실행 가능해야 한다.
    - 프로그램 실행의 시작점은 `Application`의 `main()`이다.
    - `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
    - [Java 코드 컨벤션](https://google.github.io/styleguide/javaguide.html) 가이드를 준수하며 프로그래밍한다.
    - 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
    - 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
    
    ### 테스트 실행 가이드
    
    - 터미널에서 `java -version`을 실행하여 Java 버전이 17인지 확인한다.
    Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다.
    - 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,
    Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.
    
    ```
    BUILD SUCCESSFUL in 0s
    ```
    
    ### 라이브러리
    
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
        - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
    
    ```java
    import static camp.nextstep.edu.missionutils.Console.readLine;
    
    import camp.nextstep.edu.missionutils.Console;
    
    // ...
    
    String input = Console.readLine();
    ```
    
    ## 과제 진행방식
    
    - 과제는 이 저장소를 Fork & Clone 해 시작한다.
    - 기능을 구현하기 전에 구현할 기능 목록을 `docs/README.md`에 정리한다.
        - 작성 양식은 자유이나, 필요한 경우 [마크다운](https://github.com/jinkyukim-me/markdown_ko) 문법을 참고한다.
    - 구현이 완료되면 이 저장소에 Pull Request 를 보내 과제를 제출한다.
        - PR 제목은 `[12기] $이름 과제 제출합니다.` 형식으로 작성한다.
        - PR 본문에는 자유 형식으로 과제에 대한 소감(회고)을 작성한다.
    - 과제 진행중에 궁금한 점은 멋사 디스코드 채널을 통해 질문한다.
    
    ---
    
    **"이 과제는 [우아한테크코스](https://www.woowacourse.io/)에서 제공하는 프리코스 미션을 바탕으로 설계되었습니다."**

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