# 순수 Java로 이루어진 프로젝트
객체지향을 이해하는데 있어 웹은 좋은 예제가 아니라는 자바지기(박재성님)의 이야기에 시작한 프로젝트 <br/>
데이터베이스, Html을 전혀 사용하지 않기에 Java와 객체에 좀 더 집중한다. <br/>
추가로 Git과 Gradle을 연동하였다. <br/>
Java/Spring/Git/Gradle을 분리해서 생각하지 못하는 분들도 있고 Apache Commons Util이나 ObjectMapper 같은 경우는 프로젝트 목적에 크게 위배되지 않는다고 판단해서이다. <br/>
각자의 취향에 따라 Git -> Svn, Gradle -> Maven 으로 변경해도 무방할 것 같다.

### 주제
블랙잭 게임([나무위키](https://namu.wiki/w/%EB%B8%94%EB%9E%99%EC%9E%AD(%EC%B9%B4%EB%93%9C%EA%B2%8C%EC%9E%84)) 참고)을 개량해서 구현할 예정이다. <br/>
블랙잭 규칙 전부를 구현하는건 지나친 감이 있어서 조금은 스펙아웃하였다. <br/>
화면 구성은 모두 콘솔로 진행한다.

### 블랙잭 규칙
* 딜러와 게이머 단 2명만 존재한다.
* 카드는 조커를 제외한 52장이다. (즉, 카드는 다이아몬드,하트,스페이드,클럽 무늬를 가진 A,2~9,K,Q,J 으로 이루어져있다.)
* 2~10은 숫자 그대로 점수를, K/Q/J는 10점으로, A는 1과 11 둘 중 하나로 계산할 수 있다.
* 딜러와 게이머는 순차적으로 카드를 하나씩 뽑아 각자 2개의 카드를 소지한다.
* 게이머는 얼마든지 카드를 추가로 뽑을 수 있다.
* 딜러는 2카드의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 추가할 수 없다.
* 양쪽다 추가 뽑기 없이, 카드를 오픈하면 딜러와 게이머 중 소유한 카드의 합이 21에 가장 가까운 쪽이 승리한다.
* 단 21을 초과하면 초과한 쪽이 진다.

### 설계원칙

* 클래스 우선이 아닌, 객체의 속성과 행위가 우선이다.
  - 클래스는 객체를 추상화하는 도구일 뿐이다.

* 데이터가 아닌 메세지(행위)를 중심으로 객체를 설계해라.
  - 객체는 혼자 있을 수 없다. 다른 객체와의 **협력** 안에서만 존재할 수 있다.
  - 메세지를 중심으로, 해당 메세지가 어떤 객체를 필요로 하는지를 생각하자.

* 하나하나 지시하지 말고 요청해라.
  - 예를들어, 판사가 증인에게 1) 목격했던 장면을 떠올리고, 2) 떠오르는 시간을 순서대로 구성하고, 3) 말로 간결하게 표현해라 라고 요청하지 않는다. 그냥 "증언하라" 라고 요청한다.
  - 마찬가지로 객체의 설계단계에서도 책임이 있는 객체에 요청만 하도록 설계한다.

### 주요 객체
* 카드뭉치 (카드덱)
* 카드
* 규칙
* 딜러
* 게이머

### 주요 객체들의 속성과 역할
* 카드뭉치 (카드덱)
  - 52개의 서로 다른 카드를 갖고 있다.
  - 카드 1개를 뽑아준다.

* 카드
  - 다이아몬드, 하트, 스페이드, 클럽 중 1개의 무늬를 가지고 있다.
  - A,2~9,K,Q,J 중 하나를 가지고 있다.

* 규칙
  - 승패를 판단한다.

* 딜러
  - 추가로 카드를 받는다.
  - 뽑은 카드를 소유한다.
  - 카드를 오픈한다.

* 게이머
  - 추가로 카드를 받는다.
  - 뽑은 카드를 소유한다.  
  - 카드를 오픈한다.

### 1. 추상화된 코드 구현
위의 "객체들의 속성과 역할"에 따라 간략하게 코드를 구현하면 아래와 같다. <br/>

**Card.java** <br/>
```
public class Card {
    private String pattern;
    private String number;
}

```

**CardDeck.java** <br/>
```
public class CardDeck {
    private List<Card> cards;

    public Card getCard(){
        return null;
    }
}
```

**Dealer.java** <br/>
```
public class Dealer {
    private List<Card> cards;

    public void draw(CardDeck cardDeck) {}

    public List<Card> openCards(){
        return null;
    }
}
```

**Gamer.java** <br/>
```
public class Gamer {
    private List<Card> cards;

    public void draw(CardDeck cardDeck) {}

    public List<Card> openCards(){
        return null;
    }
}

```

**Rule.java** <br/>
```
public class Rule {
    public void getWinner(Dealer dealer, Gamer gamer){}
}
```

return 타입이 void가 아닌 경우엔 null을 리턴하도록 하였다. <br/>
위 선언된 5개의 Java파일만으로는 블랙잭 게임이 진행될 순 없다. <br/>
실제로 게임을 진행시킬 Game.java를 구현해보자.<br/>

**Game.java** <br/>
```
public class Game {

    public void play(){
        System.out.println("========= Blackjack =========");
        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();
    }
}
```

게임에 필요한 "클래스들의 인스턴스"를 생성시켰다. <br/>
(객체가 아닌, xx클래스의 인스턴스이다.) <br/>
그리고 이를 실행시킬 Application.java이다. <br/>

**Application.java** <br/>
```
public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
```

### 2. 실제 코드 구현




### 참고 자료
* [조영호님의 객체지향의 사실과 오해](http://www.yes24.com/24/goods/18249021)
* [OKKY fender님의 칼럼](http://okky.kr/article/358197)
