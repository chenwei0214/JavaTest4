package com.hand.api.service;

import com.hand.domain.entity.UserE;
import com.hand.infra.dataobject.UserDO;

public interface UserService {

    void createUser(UserE userE);

    UserE getUserById(Long id);

    UserDO findUserId(Long id);
}
