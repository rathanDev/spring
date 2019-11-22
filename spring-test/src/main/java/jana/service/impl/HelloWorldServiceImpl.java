package jana.service.impl;

import jana.dao.HelloWorldDao;
import jana.model.Hello;
import jana.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("hs")
@Service()
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    HelloWorldDao helloWorldDao;

    public List<Hello> get() {
        return helloWorldDao.get();
    }

}
