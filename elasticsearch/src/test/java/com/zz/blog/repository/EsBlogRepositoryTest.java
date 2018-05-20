package com.zz.blog.repository;

import com.zz.blog.domain.es.EsBlog;
import com.zz.blog.repository.es.EsBlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData(){
        //清除所有数据
        esBlogRepository.deleteAll();
        //创建数据
        esBlogRepository.save(new EsBlog("zz","brilliant","zz is good"));
        esBlogRepository.save(new EsBlog("wzp","healthy","wp is nice"));
        esBlogRepository.save(new EsBlog("lf","rich","lf is haha"));
    }
    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
        Pageable pageable = new PageRequest(0,20);
        String title = "zz";
        String summary = "a";
        String content = "good";
        Page<EsBlog> page  =  esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);

        System.out.println("=========start===========");
        for(EsBlog e:page.getContent()){
            System.out.println(e.toString());
        }
        System.out.println("=========end===========");
    }
}
