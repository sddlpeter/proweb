package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    List<Topic> getTopicList(UserBasic userBasic);
    public Topic getTopicById(Integer id);

    public Topic getTopic(Integer id);

    void delTopic(Integer topicId);
}
