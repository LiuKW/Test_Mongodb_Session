package com.learn.mongodb;


import com.mongodb.BasicDBObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SessionApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void test01()
    {
        BasicDBObject student = new BasicDBObject("name", "stu1");
        BasicDBObject teacher = new BasicDBObject("name", "tea1");
        mongoTemplate.insert(student, "student");
        mongoTemplate.insert(teacher, "teacher");
    }


    @Test
    void test02()
    {
        BasicDBObject student = new BasicDBObject("name", "stu2");
        BasicDBObject teacher = new BasicDBObject("name", "tea2");
        mongoTemplate.insert(student, "student");
        int n = 3/0;
        mongoTemplate.insert(teacher, "teacher");
    }

    @Transactional
    @Test
    void test03()
    {
        BasicDBObject student = new BasicDBObject("name", "stu3");
        BasicDBObject teacher = new BasicDBObject("name", "tea3");
        mongoTemplate.insert(student, "student");
        int n = 3/0;
        mongoTemplate.insert(teacher, "teacher");
    }

}
