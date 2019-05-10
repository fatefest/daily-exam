package com.fest.exam.dubbo.consumer;


//import com.fest.exam.dubbo.api.HelloService;
//import com.yunche.config.service.DubboPartnerCheckService;
//import com.yunche.framework.enums.CheckTyleEnum;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.yunche.config.service.DubboPartnerCheckService;
//import com.yunche.framework.enums.CheckTyleEnum;
import com.yunche.framework.enums.CheckTyleEnum;

/**
 * @Author: yesitao
 * @Date: 2019/4/29 9:56
 * @Description: 测试合伙人服务
 */
public class DubboPartnerServiceTest {


    public static void main(String[] args) {
        String partnerId = "";
        String userId = "";
//        Logger logger = LoggerFactory.getLogger(DubboPartnerServiceTest.class);
        ReferenceConfig<DubboPartnerCheckService> referenceConfig = new ReferenceConfig<DubboPartnerCheckService>();
        referenceConfig.setApplication(new ApplicationConfig("before-inparts-concumer"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://192.168.3.89:2181"));
        referenceConfig.setInterface(DubboPartnerCheckService.class);
        DubboPartnerCheckService helloService = referenceConfig.get();
        System.out.println(helloService.findEmployeeLevel(partnerId,userId, CheckTyleEnum.CREDIT));
//        ReferenceConfig<HelloService> referenceConfig = new ReferenceConfig<HelloService>();
//        referenceConfig.setApplication(new ApplicationConfig("before-inparts-concumer"));
//        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
//        referenceConfig.setInterface(HelloService.class);
//        HelloService helloService = referenceConfig.get();
//        System.out.println(helloService.sayHello("亚马逊"));
    }
}
