import com.huanyu.fun.es.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: sunsf
 * @date: 2020/3/15 21:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationTests.class)
public class TestDemo {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test1() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(Item.class);
    }
    public void test2(){
        System.out.println(1);
    }
}
