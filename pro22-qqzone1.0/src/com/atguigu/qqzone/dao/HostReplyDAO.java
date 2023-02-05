package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.HostReply;

public interface HostReplyDAO {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
}
