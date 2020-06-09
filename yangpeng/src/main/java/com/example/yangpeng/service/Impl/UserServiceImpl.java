package com.example.yangpeng.service.Impl;

import com.example.yangpeng.entity.UserEntity;
import com.example.yangpeng.mapper.UserEntityMapper;
import com.example.yangpeng.service.UserService;
import com.example.yangpeng.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.yangpeng.utils.MD5;


import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.yangpeng.utils.UUIDUtils.getUUID32;
import com.example.yangpeng.utils.eMailUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private eMailUtil eMailUtil;
    @Autowired
    private  MD5 md5Util;


    @Override
    public Page<Map<String, Object>> getUserList(Integer pageSize, Integer pageNumber) {

        // 先创建一个page 对象 然后把pageSize 和pageNumber 传给page
        Page<Map<String, Object>> page = new Page<Map<String, Object>>(pageSize != null ? pageSize : 0);
        // 创建成员变量 endNum 结束分页
        Integer endNum = null;
        // 创建成员变量 startNum 开始分页
        Integer startNum = null;
        // 判断 pageSize 每页显示多少个
        // pageNumber 显示第几页
        // 如果 连个参数不都为空 哪么
        if (pageSize != null && pageNumber != null) {
            // 那么页数从第一页开始
            page.setPageNo(pageNumber);
            // 所有的参数 是 每页显示多少行 * 多少页
            endNum = pageSize * pageNumber;
            // 开始是 所有参数 减去 每页显示多少行
            startNum = endNum - pageSize;
        }
        // 创建一个参数的 map 里面放入 开始页和结束页 和用户名字
        Map<String, Object> params = new HashMap<String, Object>();
        // 传给下一层 给后端传参数


        params.put("startNum", startNum);
        params.put("endNum", pageSize);

        // 这是总条数为0
        Integer totalCount = 0;
        // 通过用户名查询所有条数 (不带条件)
        totalCount = userEntityMapper.getUserListCount();
        // 把查询出来的给参数穿进去
        // 查询所有参数
        List<Map<String, Object>> list = userEntityMapper.getUserList(params);
        // 把 查到的 数据传给 page
        page.setResult(list);
        page.setTotalCount(totalCount);
        return page;
    }

    /**
     * 创建用户
     *
     * @param userEntity
     * @return
     */
    @Override
    public Integer insertUser(UserEntity userEntity) {
        userEntity.setIdUser(getUUID32());
        //邮箱状态为0
        userEntity.setStateEmailUser(0);
        //64位uuid
        String randomCode = getUUID32() + getUUID32();
        userEntity.setCodeEmailUser(randomCode);
        String newPassword =  md5Util.getMD5(userEntity.getPasswordUser(),userEntity.getPasswordUser().length());

        userEntity.setPasswordUser(newPassword);

        int state = userEntityMapper.insertSelective(userEntity);




        try {
            //调用邮箱
            eMailUtil.sendEmailUtil(userEntity.getEmailUser(), randomCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

    /**
     * 获取用户状态
     *
     * @param params
     * @return
     */

    @Override
    public Map<String, Object> getUserByAccount(Map<String, String> params) {
        boolean state = false;
        String ErrorState = "可以注册";
        Map<String, Object> newMap = new HashMap<>();

        for (String key : params.keySet()) {

            switch (key) {
                case "email":
                    //通过邮箱取id
                    String userIdBymail = userEntityMapper.getUserByMail(params.get(key));

                    if (userIdBymail == null) {
                        state = true;
                        continue;
                    } else {
                        ErrorState = "您已经使用过此邮箱，请更好其他邮箱！";
                        newMap.put("information", ErrorState);
                        newMap.put("state", false);
                        return newMap;
                    }
                case "account":
                    //通过用户名取id
                    String userIdByAccount = userEntityMapper.getUserByAccount(params.get(key));

                    if (userIdByAccount == null) {
                        state = true;
                        continue;
                    } else {
                        ErrorState = "用户名已被使用，请更换用户名注册！";
                        newMap.put("information", ErrorState);
                        newMap.put("state", false);
                        return newMap;
                    }
                case "phone":
                    //通过手机取id
                    String userIdByphone = userEntityMapper.getUserByPhone(params.get(key));
                    if (userIdByphone == null) {
                        state = true;
                        continue;
                    } else {
                        ErrorState = "手机号已被使用，请更换手机号注册！";
                        newMap.put("information", ErrorState);
                        newMap.put("state", false);
                        return newMap;
                    }
            }
        }
        newMap.put("information", ErrorState);
        newMap.put("state", state);
        return newMap;
    }

    @Override
    public boolean verifyRandomCode(String newLink) {
        //通过邮箱随机码 来查询是否有用户
        String userId = userEntityMapper.verifyRandomCode(newLink);
        if (userId == null) {
            return false;
        } else {
            Integer state = userEntityMapper.updateMailstate(userId);
            if (state == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(String userName, String password) {
        //第一步通过用户名去取密码 然后在通过密码来确认  进行更改


        return true;
    }


}