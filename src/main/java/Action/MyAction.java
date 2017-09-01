package Action;
import analysticapi.MyBean;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

/**
 * Created by Sano on 27.08.2017.
 */
public class MyAction extends ActionSupport {


    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
