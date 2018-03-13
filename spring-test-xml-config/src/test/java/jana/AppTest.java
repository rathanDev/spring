package jana;

import jana.model.Hello;
import jana.service.HelloWorldService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppTest {
    @Autowired
//    @Qualifier("hs")
    HelloWorldService helloWorldService;

    @BeforeClass
    public static void setUp() {
        System.out.println("-----> SETUP <-----");
    }

    @Test
    public void testSampleServiceGetAccountDescription() {
        List<Hello> hellos = helloWorldService.get();
        System.out.println(hellos);
        Assert.assertNotNull(hellos);
    }

    @AfterClass
    public static void afterTest() {
        System.out.println("-----> DESTROY <-----");
    }
}
