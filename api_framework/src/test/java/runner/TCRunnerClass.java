package runner;

import org.testing.testscripts.GetRequest;
import org.testing.testscripts.PostRequest;

public class TCRunnerClass {

	public static void main(String[] args) throws Exception {
		PostRequest post=new PostRequest();
		post.tc001();		
		GetRequest getRequest=new GetRequest();
		getRequest.tc002();
	}

}
