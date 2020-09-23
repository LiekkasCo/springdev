package com.lc.springdev.mapper;

import com.lc.springdev.entity.LcUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * @author liangchen
 */
@Repository
public interface LcUserMapper {
    /**
     * 查找全部用户
     * @return user list
     */
    @Select("select * from lc_user")
    List<LcUser> findAll();

    /**
     * 查找指定用户
     * @param id 用户id
     * @return one user
     */
    @Select("select * from lc_user where id = #{id}")
    LcUser findOne(@Param("id") long id);

    /**
     * 新增一个用户
     * @param lcUser 用户实体类
     * @return 影响行数
     */
    @Insert("insert into lc_user(name,age,gender) values(#{name},#{age},#{gender})")
    int addOneUser(LcUser lcUser);
}
