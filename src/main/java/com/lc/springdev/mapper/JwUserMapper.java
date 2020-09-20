package com.lc.springdev.mapper;

import com.lc.springdev.entity.JwUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangchen
 */
@Repository
public interface JwUserMapper {
    @Select("select * from jw_user")
    List<JwUser> findAll();

    @Select("select * from jw_user where id = #{id}")
    JwUser findOne(@Param("id") long id);
}
