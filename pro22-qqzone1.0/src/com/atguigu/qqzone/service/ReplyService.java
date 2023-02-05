package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyListByTopicId(Integer topicId);

    void addReply(Reply reply);

    void delReply(Integer id);

    void delReplyList(Topic topic);

}
