import com.huanyu.fun.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void  sendMsg1(){
        rabbitTemplate.convertAndSend("zhijie", "直接模式测试");
    }

    /**
     * 分裂模式
     */
    @Test
    public void  sendMsg2(){
        rabbitTemplate.convertAndSend("dufu","","分裂模式测试");
    }


    /**
     * 主题模式
     */
    @Test
    public void  sendMsg3(){
        rabbitTemplate.convertAndSend("libai","libai1","主题模式测试");
    }
}