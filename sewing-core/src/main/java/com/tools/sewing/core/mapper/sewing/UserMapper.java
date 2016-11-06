package com.tools.sewing.core.mapper.sewing;

import com.tools.sewing.core.po.sewingMapper.UserMapperPO;

import java.util.List;

/**
 * Created by Phoebe on 2016/11/6.
 */
public interface UserMapper {

    List<UserMapperPO> findAll();
}
