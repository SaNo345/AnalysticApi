package analysticapi;

import org.springframework.context.ApplicationContext;

/**
 * Created by Sano on 27.08.2017.
 */
public class MyBean {
    private String name;


    public MyBean() {
    }

    public MyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
