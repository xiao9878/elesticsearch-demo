package top.xiao.elesticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import top.xiao.elesticsearch.bean.Artcle;

import java.util.List;

public interface ArticleRepository extends ElasticsearchCrudRepository<Artcle,Integer> {
    public List<Artcle> findArtcleByAuthorLike(String s);
}
