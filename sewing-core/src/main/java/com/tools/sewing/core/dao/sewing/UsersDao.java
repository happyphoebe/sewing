package com.tools.sewing.core.dao.sewing;

import com.tools.sewing.core.po.sewing.UsersPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by Phoebe on 2016/11/6.
 */
public interface UsersDao extends JpaRepository<UsersPO, Integer>, JpaSpecificationExecutor<UsersPO> {

    List<UsersPO> findByName(String name);
}
