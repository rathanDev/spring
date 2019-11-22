package jana;

import jana.config.ApplicationContextConfig;
import jana.model.Hello;
import jana.service.HelloWorldService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class JUnitSpringExample {

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
