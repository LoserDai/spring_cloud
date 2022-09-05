package com.df.service;

import com.df.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author Loser
 * @date 2021年11月15日 12:50
 */

public interface UserService {
     /**
      * 获取用户
      * @return
      */
     User getUser();
}
