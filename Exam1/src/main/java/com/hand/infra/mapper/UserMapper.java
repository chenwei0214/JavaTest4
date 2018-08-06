package com.hand.infra.mapper;

import java.util.List;

import com.hand.infra.dataobject.UserDO;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    Long insert(UserDO user);

    List<UserDO> selectByExample(UserDO user);

    UserDO selectByPrimaryKey(Long id);

    void deleteByPrimaryKey(Long id);

    void updateByPrimaryKey(UserDO user);

    @Select("select user_id,username,password,email,age from tb_user where user_id=#{id}")
    UserDO selectById(Long id);


}
