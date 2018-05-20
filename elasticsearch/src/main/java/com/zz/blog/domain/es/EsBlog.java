package com.zz.blog.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "blog", type="blog")//文档类
public class EsBlog implements Serializable{

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected EsBlog(){}

    public EsBlog(String title,String summary,String content){
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return String.format("EsBlog[id='%s',summary='%s',title='%s',content='%s']",id,summary,title,content);
    }
}
