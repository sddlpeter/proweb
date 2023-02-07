package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {
    public List<Topic> getTopicList(UserBasic userBasic);
    public void addTopic(Topic topic);
    public void delTopic(Topic topic);
    public Topic getTopic(Integer id);
}
