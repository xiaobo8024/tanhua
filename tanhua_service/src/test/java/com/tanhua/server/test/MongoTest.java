package com.tanhua.server.test;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

public class MongoTest {

    private MongoCollection<Document> mongoCollection;

    @Before
    public void init(){
        //链接mongodb
        MongoClient mongoClient = MongoClients.create("mongodb://10.10.20.160:27017");

        //选择数据库
        MongoDatabase testdbDatabase = mongoClient.getDatabase("testdb");

        //选择表
        mongoCollection= testdbDatabase.getCollection("person");
    }

    @Test
    public void insert(){
        Document document=new Document()
                .append("id",10)
                .append("username","小泽玛利亚")
                .append("age",18)
                .append("address","深圳");
        this.mongoCollection.insertOne(document);
    }
    @Test
    public void update(){
        UpdateResult updateResult = mongoCollection.updateOne(Filters.eq("id", 9), Updates.set("age", 9));
        System.out.println("updateResult:  "+updateResult);
    }
    @Test
    public void find(){
        mongoCollection.find().forEach((Consumer<? super Document>)  document -> {
            System.out.println(document);
        });
    }
    @Test
    public void find1(){
        mongoCollection.find(Filters.lt("id",9)).forEach((Consumer<? super Document>) document -> {
            System.out.println(document);
        });
    }
}