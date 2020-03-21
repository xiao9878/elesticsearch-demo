package top.xiao.elesticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring 默认支持两种技术和es交互
 * 1.Jest(默认不生效)
 * 需要导入jest工具包(io.searchbox.client.JestClient)
 * 2.springData Elesticsearch{ES版本有可能不合适}
 *  如果不适配 1升级spring boot版本2安装对应版本的ES
 *  1) client节点信息 clusterNodes;clusterName
 *  2)ElesticsearchTemplate 操作ES
 *  3)编写一个ElesticsearchRepository的子接口来操作ES
 */
@SpringBootApplication
public class ElesticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElesticsearchApplication.class, args);
    }

}
