import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testHello() {
        assertEquals("Hello DevOps World", HelloWorld.sayHello());
    }
}