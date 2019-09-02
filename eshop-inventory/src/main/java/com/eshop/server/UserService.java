package com.eshop.server;

import com.eshop.model.User;

import java.util.List;

/**
 * 定义用户服务
 */
public interface
UserService {
    /**
     * 查询全部的User数据
     * @return
     */
    List<User> selectList();
}
