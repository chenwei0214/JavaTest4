package com.hand.infra.mapper;

import java.util.List;

import com.hand.infra.dataobject.ActorDO;
import org.apache.ibatis.annotations.Select;

public interface ActorMapper {

    @Select("select actor_id as id,first_name as firstName,last_name lastName,last_update lastUpdate from actor")
    List<ActorDO> getAll();
}
