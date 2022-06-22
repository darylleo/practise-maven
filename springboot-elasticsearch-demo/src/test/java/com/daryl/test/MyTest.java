package com.daryl.test;

import com.daryl.pojo.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wl
 * @create 2022-01-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    private TransportClient transportClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    //根据id查询
    @Test
    public void queryById(){
        GetResponse documentFields = transportClient.prepareGet("blog01","article","1").get();
        System.out.println(documentFields);
    }

    //根据id删除
    @Test
    public void deleteById(){
        transportClient.prepareDelete("blog01","article","1");
    }

    //创建索引
    @Test
    public void createIndex(){
        //准备创建索引，指定索引名，执行创建的动作，（get方法）
        transportClient.admin().indices().prepareCreate("blog03").get();
    }

    //删除索引
    @Test
    public void deleteIndex(){
        //准备删除索引，指定索引名，指定删除的动作（get）
        transportClient.admin().indices().prepareDelete("blog02").get();
    }

    //创建映射
    @Test
    public void putMapping() throws Exception{
        //1、创建索引，如果已经有了该索引，可以先删除试试
        transportClient.admin().indices().prepareCreate("blog02").get();

        //创建映射
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject()
                .startObject("article")
                .startObject("properties")
                .startObject("id")
                .field("type", "long").field("store", "true")
                .endObject()
                .startObject("content")
                .field("type", "text").field("analyzer", "ik_smart").field("store", "true")
                .endObject()
                .endObject()
                .endObject()
                .endObject();
        PutMappingRequest mapping = new PutMappingRequest("blog02").type("article").source(xContentBuilder);
        transportClient.admin().indices().putMapping(mapping);
    }

    //通过ObjectMapper创建
    //创建索引， 添加文档， 增加 ， 修改文档
    @Test
    public void createIndexAndDocument() throws Exception {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("4g手机卖9000");
        article.setContent("华为手机真的很棒！！");

        IndexResponse indexResponse = transportClient.prepareIndex("blog01", "article", "1")
                .setSource(objectMapper.writeValueAsString(article), XContentType.JSON)
                .get();
        System.out.println(indexResponse);
    }

    //xcontentBuilder创建

    /**
     * {
     *     "id": 1,
     *     "content": "华为手机真的很棒",
     *     "title": "华为手机很棒"
     * }
     */
    //创建文档
    @Test
    public void createDocument() throws Exception{
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                .startObject()
                .field("id",2)
                .field("content","落霞与孤鹜齐飞")
                .field("title","秋水共长天一色")
                .endObject();
        IndexResponse indexResponse = transportClient.prepareIndex("blog02", "article", "2").setSource(xContentBuilder).get();
        System.out.println(indexResponse);
    }

    //修改文档和新增文档一样。当存在相同的文档唯一id的时候，就是更新

    //删除文档
    @Test
    public void deleteDocument(){
        transportClient.prepareDelete("blog02","article","2").get();
    }

    //批量添加文档（强烈推荐，耗时短）
    @Test
    public void createDocumentBatch() throws Exception{
        //构建批量添加builder
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Article article = new Article();
            article.setTitle("落霞与孤鹜齐飞"+ i);
            article.setContent("秋水共长天一色" + i);
            article.setId(i);
            //转成json
            String valueAsString = objectMapper.writeValueAsString(article);
            //设置值
            IndexRequest indexRequest = new IndexRequest("blog02", "article", "" + i).source(valueAsString, XContentType.JSON);
            //添加请求对象builder 中
            bulkRequestBuilder.add(indexRequest);
        }
        //一次性提交
        BulkResponse bulkItemResponses = bulkRequestBuilder.get();

        long end = System.currentTimeMillis();
        System.out.println("总耗时=" + (end-start)/1000);

        if (bulkItemResponses.hasFailures()){
            System.out.println("有错误");
        }
    }

}
