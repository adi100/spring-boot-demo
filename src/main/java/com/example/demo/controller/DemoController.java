package com.example.demo.controller;

import com.example.demo.common.Page;
import com.example.demo.model.db.User;
import com.example.demo.model.mongo.MongoUser;
import com.example.demo.model.solr.SolrCompany;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("index")
    public Page<User> index(HttpSession session,Page<User> page,SitePreference site,Device device){
        System.out.println("site.isMobile:"+site.isMobile());
        System.out.println("site.isTablet:"+site.isTablet());
        System.out.println("site.isNormal:"+site.isNormal());

        System.out.println("device.isMobile:"+device.isMobile());
        System.out.println("device.isTablet:"+device.isTablet());
        System.out.println("device.isNormal:"+device.isNormal());

        System.out.println("device.Platform:"+device.getDevicePlatform());
        System.out.println("site.name:"+site.name());

        System.out.println(session.getId());
        return demoService.getUser(page);
    }

    @RequestMapping("update")
    public int update(HttpSession session,Page<User> page){
        return demoService.updateUser();
    }

    @RequestMapping("redis")
    public String redis(){
        return demoService.testRedis();
    }

    @RequestMapping("solr")
    public List<SolrCompany> solr(){
        return demoService.getCompanyByName("liubo");
    }

    @RequestMapping("solrInsert")
    public void solrInsert(){
        demoService.saveSolrCompany();
    }

    @RequestMapping("mongoUsers")
    public List<MongoUser> mongoUsers(){
        return demoService.getAllMongoUsers();
    }
}
