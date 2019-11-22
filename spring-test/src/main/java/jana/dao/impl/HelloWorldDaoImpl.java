package jana.dao.impl;

import jana.dao.HelloWorldDao;
import jana.model.Hello;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class HelloWorldDaoImpl implements HelloWorldDao {

    public List<Hello> get() {
        Hello hello = new Hello();
        hello.setH("Hellooo");
        return Collections.singletonList(hello);
    }

}
