package com.huanyu.fun.es.controller;

import com.google.common.collect.Lists;
import com.huanyu.fun.common.api.CommonResult;
import com.huanyu.fun.es.dao.ItemEsDao;
import com.huanyu.fun.es.entity.Item;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: sunsf
 * @date: 2020/3/14 15:17
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemEsDao itemEsDao;


    /**
     * 新增一条索引
     *
     * @param
     * @return:
     * @author: sunsf
     * @date: 2020/3/15 21:40
     */
    @RequestMapping("/save")
    public void create() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        itemEsDao.save(item);
    }

    /**
     * 批量新增
     *
     * @param
     * @return:
     * @author: sunsf
     * @date: 2020/3/15 21:41
     */
    @RequestMapping("/batchSave")
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));// 接收对象集合，实现批量新增
        itemEsDao.saveAll(list);
    }

    /**
     * id 查询
     *
     * @param id
     * @return:
     * @author: sunsf
     * @date: 2020/3/14 15:51
     */
    @GetMapping("/findById/{id}")
    public Optional<Item> findById(@PathVariable("id") Long id) {
        return itemEsDao.findById(id);
    }

    /**
     * 倒叙查询
     *
     * @param
     * @return:
     * @author: sunsf
     * @date: 2020/3/15 21:43
     */
    @GetMapping("/selectAll")
    public CommonResult selectAll() {
        // 查询全部，并按照价格降序排序
        Iterable<Item> items = this.itemEsDao.findAll(Sort.by(Sort.Direction.DESC, "price"));
        items.forEach(item -> System.out.println(item));
        return CommonResult.success(Lists.newArrayList(items));
    }

    /**
     * 自定义方法查询
     *
     * @param
     * @return:
     * @author: sunsf
     * @date: 2020/3/16 9:55
     */
    @GetMapping("/queryByPriceBetween")
    public void queryByPriceBetween(@RequestParam(required = false, name = "start") Double start,
                                    @RequestParam(required = false, name = "end") Double end) {
       /* List<Item> list = this.itemEsDao.findByPriceBetween(start, end);
        for (Item item : list) {
            System.out.println("item = " + item);
        }*/
    }


    /**
     * 列表
     *
     * @param
     * @return:
     * @author: sunsf
     * @date: 2020/3/14 16:52
     */
    @GetMapping("/queryList")
    public List<Item> queryList(@PageableDefault(page = 0, value = 2) Pageable pageable,
                                @RequestParam(required = false) String name) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (!StringUtils.isEmpty(name)) {
            MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("name", name);
            boolQuery.must(matchQuery);
        }
        // 词条查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "小米");
        // 执行查询
        Iterable<Item> it = itemEsDao.search(boolQuery, pageable);
        return Lists.newArrayList(it);
    }

    @GetMapping("/nativeQuery")
    public void nativeQuery(
    ) {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));
        // 执行搜索，获取结果
        Page<Item> items = this.itemEsDao.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印总页数
        System.out.println(items.getTotalPages());
        items.forEach(System.out::println);
    }

    @GetMapping("/queryPage")
    public void testNativeQuery(@PageableDefault(page = 0, value = 0) int page,
                                @PageableDefault(page = 0, value = 5) int size) {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));
        // 设置分页参数
        queryBuilder.withPageable(PageRequest.of(page, size));

        // 执行搜索，获取结果
        Page<Item> items = this.itemEsDao.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印总页数
        System.out.println(items.getTotalPages());
        // 每页大小
        System.out.println(items.getSize());
        // 当前页
        System.out.println(items.getNumber());
        items.forEach(System.out::println);
    }

    /**
     * 集合测试
     *
     * @param
     * @return:
     * @author: sunsf
     * @date: 2020/3/16 10:01
     */
    @GetMapping("/queryAgg")
    public void queryAgg() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(
                AggregationBuilders.terms("brands").field("brand"));
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) this.itemEsDao.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("brands");
        // 3.2、获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            // 3.4、获取桶中的key，即品牌名称
            System.out.println(bucket.getKeyAsString());
            // 3.5、获取桶中的文档数量
            System.out.println(bucket.getDocCount());
        }

    }

    @GetMapping("/querySubAgg")
    public void querySubAgg() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(
                AggregationBuilders.terms("brands").field("brand")
                        .subAggregation(AggregationBuilders.avg("priceAvg").field("price")) // 在品牌聚合桶内进行嵌套聚合，求平均值
        );
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) this.itemEsDao.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("brands");
        // 3.2、获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            // 3.4、获取桶中的key，即品牌名称  3.5、获取桶中的文档数量
            System.out.println(bucket.getKeyAsString() + "，共" + bucket.getDocCount() + "台");

            // 3.6.获取子聚合结果：
            InternalAvg avg = (InternalAvg) bucket.getAggregations().asMap().get("priceAvg");
            System.out.println("平均售价：" + avg.getValue());
        }
    }
}
