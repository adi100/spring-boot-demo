package com.example.demo.model.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter@Getter
@Document(collection = "user")
public class MongoUser {
    @Field("id")
    private Integer id;
    @Field("name")
    private String realname;
}
