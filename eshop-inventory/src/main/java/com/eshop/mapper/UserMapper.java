package com.eshop.mapper;

import com.eshop.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    List<User> selectAllList();
}