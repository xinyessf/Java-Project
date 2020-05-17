import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderTest {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("provider.xml");
		app.start();
		System.out.println("服务发布成功...");
		System.in.read();//让程序阻塞。
	}

}
