package com.qf.service.impl;

import com.qf.Response.ResponseUserLogin;
import com.qf.dao.UserLoginRespository;
import com.qf.domain.UserLogin;
import com.qf.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by 54110 on 2019-09-25.
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRespository userLoginRespository;

    @Override
    public ResponseUserLogin findAll(Integer page,Integer size) {

        Pageable pages = PageRequest.of(page-1,size);
        Page<UserLogin> all = userLoginRespository.findAll(pages);
        ResponseUserLogin res = new ResponseUserLogin();

        res.setList(all.getContent());
        res.setTotal(all.getTotalElements());

        return res;
    }

    @Override
    public UserLogin save(UserLogin userLogin) {


        UserLogin save = userLoginRespository.save(userLogin);
        return save;
    }

    @Override
    public String delete(UserLogin userLogin) {
        userLoginRespository.deleteById(userLogin.getId());
        return "删除成功";
    }

    @Override
    public UserLogin selectById(UserLogin userLogin) {
        Optional<UserLogin> byId = userLoginRespository.findById(userLogin.getId());

        if (byId.isPresent()){
            UserLogin userLogin1 = byId.get();
            return userLogin1;
        }
        return null;
    }

    @Override
    public UserLogin updateData(UserLogin userLogin) {
        return userLoginRespository.saveAndFlush(userLogin);
    }
}
