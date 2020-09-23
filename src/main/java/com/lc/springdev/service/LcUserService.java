package com.lc.springdev.service;


import com.lc.springdev.entity.LcUser;

import java.util.List;

/**
 * user service
 * @author liangchen
 * @date 2020.09.23
 */
public interface LcUserService {
    /**
     * get all user
     * @return all user list
     */
   List<LcUser> getAll();

   /**
     * get one user
     * @param id id
     * @return one user info
     */
    LcUser getOne(long id);
}
