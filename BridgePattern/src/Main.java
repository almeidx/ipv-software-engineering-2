import com.es2.bridge.APIMoodle;
import com.es2.bridge.APIRequest;
import com.es2.bridge.APIRequestContentAggregator;
import com.es2.bridge.ServiceNotFoundException;

public class Main {
    public static void main(String[] args) throws ServiceNotFoundException {
        System.out.printf("Hello and welcome!");

        APIRequest req;

        req = new APIRequest();
        req.getContent("abc", "12");
    }
}
