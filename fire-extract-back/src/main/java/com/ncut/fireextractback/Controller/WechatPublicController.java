package com.ncut.fireextractback.Controller;

import com.ncut.fireextractback.domain.entity.ExtractData;
import com.ncut.fireextractback.domain.entity.ReptileData;
import com.ncut.fireextractback.service.ExtractDataService;
import com.ncut.fireextractback.service.ReptileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @Author dmh
 * @Date 2023/11/2 21:16
 * @Version 1.0
 * @introduce
 */

@RestController
@RequestMapping("/system/wechatPublic")
public class WechatPublicController {
    @Autowired
    private ReptileDataService reptileDataService;


    @GetMapping("/list")
    public List<ReptileData> test(){
        System.out.println("我到这里啦");
        List<ReptileData> list = reptileDataService.list();
        System.out.println(list.size());
        return list;
    }
    @GetMapping("/number")
    public Integer number(){
        System.out.println("我到这里啦");
        List<ReptileData> list = reptileDataService.list();
        System.out.println(list.size());
        return list.size();
    }
}
