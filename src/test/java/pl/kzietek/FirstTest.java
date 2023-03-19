package pl.kzietek;


import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    void mtFirstTest() {
        assert true == true;
    }

    @Test
    void my2ndTest() {
        String name = "Krzysztof";
        String hello = String.format("Hello %s", name);
        assert hello.equals("Hello Krzysztof");
    }

    @Test
    void baseTestSchema() {
        //Arrange // Given // Input
        //Act     // When  // caLL/interaction
        //Assert  // Then  //Output
    }
}
