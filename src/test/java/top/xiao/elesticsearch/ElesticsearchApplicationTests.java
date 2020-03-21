package top.xiao.elesticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.xiao.elesticsearch.bean.Artcle;
import top.xiao.elesticsearch.repository.ArticleRepository;

import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class ElesticsearchApplicationTests {
    @Autowired
    JestClient jestClient;
    @Autowired
    ArticleRepository articleRepository;


    @Test
    public void test01() {
        Artcle artcle = new Artcle();
        articleRepository.save(artcle);
    }
    @Test
    public void test02() {
        List<Artcle> artcle = articleRepository.findArtcleByAuthorLike("s");
    }

    @Test
    void contextLoads() {
        //给es中索引一个文档
        Artcle artcle = new Artcle();
        artcle.setId(1);
        artcle.setAuthor("xiao");
        artcle.setTitle("好消息");
        artcle.setContent("降价啦");
        //构建一个索引功能
        Index index = new Index.Builder(artcle).index("xiao").type("home").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索
    @Test
    void get() {
        //查询表达式
        String json = "{\n" +
                "  \"query\": {\n" +
                "    \"match\": {\n" +
                "      \"id\": \"1\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        //构建搜索
        Search search = new Search.Builder(json).addIndex("xiao").addType("home").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
