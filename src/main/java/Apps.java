import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuwenru on 2017/2/20.
 */
//@Controller
//
public class Apps {
    public Apps(String name)
    {
        this.name=name;
    }
    private String name;
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("echo \"111\" >> /tmp/aaa.log");
    }
}
