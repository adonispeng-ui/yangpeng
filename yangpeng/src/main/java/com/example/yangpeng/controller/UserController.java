package com.example.yangpeng.controller;

import com.example.yangpeng.entity.UserEntity;
import com.example.yangpeng.service.UserService;
import com.example.yangpeng.utils.Page;
import com.example.yangpeng.utils.RedisUtils;
import com.example.yangpeng.utils.ResultJson;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("userInterface")
@Api(tags = "用户接口")
public class UserController {
    private static int ExpireTime = 60;   // redis中存储的过期时间60s
    @Resource
    private RedisUtils redisUtil;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 时间排序
     * 分页
     * 条件查询
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @ApiOperation(value = "查看用户信息", notes = "查看用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页参数（必传）", dataType = "int", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "pageNumber", value = "分页参数（必传）", dataType = "int", paramType = "query", example = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 404, message = "找不到请求路径")
    })
    @GetMapping(value = "/getUserList")
    @ResponseBody

    public ResultJson getUser(@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
        ResultJson json = new ResultJson();
        if (pageSize == null) {
            json.setSuccess(false);
            json.setMsg("分页参数pageSize不能为空");
            json.setCode(401);
            return json;
        }
        if (pageNumber == null) {
            json.setSuccess(false);
            json.setMsg("分页参数pageNumber不能为空");
            json.setCode(401);
            return json;
        }
        try {
            Page<Map<String, Object>> list = userService.getUserList(pageSize, pageNumber);
            json.setObj(list);
            json.setSuccess(true);
            json.setCode(200);
            json.setMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            json.setSuccess(false);
            json.setCode(500);
            json.setMsg("服务异常");
        }
        return json;
    }

    /**
     * 注册用户
     *
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户进行注册")
    @PostMapping(value = "/insertUser")
    @ResponseBody
    public ResultJson insertUser(@Valid @RequestBody UserEntity userEntity) {
        ResultJson json = new ResultJson();

        if (userEntity.getAccountUser() == null) {
            json.setSuccess(false);
            json.setMsg("用户名不能为空");
            json.setCode(401);
            return json;
        }

        if (userEntity.getEmailUser() == null) {
            json.setSuccess(false);
            json.setMsg("邮箱不能为空");
            json.setCode(401);
            return json;
        }

        if (userEntity.getPasswordUser() == null) {
            json.setSuccess(false);
            json.setMsg("密码不能为空");
            json.setCode(401);
            return json;
        }

        try {
            //数组 邮箱 手机 用户名
            Map<String, String> params = new HashMap();
            params.put("account", userEntity.getAccountUser());
            params.put("email", userEntity.getEmailUser());
            params.put("phone", userEntity.getPhoneUser());
            //用户查id
            Map<String, Object> newMap = userService.getUserByAccount(params);

            boolean UserState = (boolean) newMap.get("state");

            if (UserState == true) {//没有用户

                Integer state = userService.insertUser(userEntity);

                if (state == 1) { //创建成功
                    json.setSuccess(true);
                    json.setCode(200);
                    json.setMsg("创建成功");
                } else {//创建失败
                    json.setSuccess(false);
                    json.setCode(500);
                    json.setMsg("创建失败");
                }
            } else {//有用户
                json.setSuccess(false);
                json.setCode(500);
                json.setMsg((String) newMap.get("information"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            json.setSuccess(false);
            json.setCode(500);
            json.setMsg("服务异常");
        }
        return json;
    }

    /**
     * 验证邮箱
     *
     * @param link
     * @return
     */
    @ApiOperation(value = "验证用户邮箱", notes = "验证用户邮箱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "link", value = "邮箱连接", dataType = "string", paramType = "query", example = "1")
    })
    @GetMapping(value = "/verifyMailbox")
    @ResponseBody
    public ResultJson verifyMailbox(String link) {

        ResultJson json = new ResultJson();

        if (link == null) {
            json.setSuccess(false);
            json.setMsg("邮箱验证链接不能为空");
            json.setCode(401);
            return json;
        }
        try {
            boolean randomCodeState = userService.verifyRandomCode(link);

            if (randomCodeState == true) {
                json.setSuccess(true);
                json.setCode(200);
                json.setMsg("验证成功");
            } else {
                json.setSuccess(false);
                json.setCode(500);
                json.setMsg("验证失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }



    /**
     *用户修改密码
     *
     * @param userName
     * @param password
     * @return
     */
    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "string", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", paramType = "query", example = "1")
    })
    @GetMapping(value = "/updateUser")
    @ResponseBody
    public ResultJson verifyMailbox(String userName,String password) {
        ResultJson json = new ResultJson();

        if (userName == null) {
            json.setSuccess(false);
            json.setMsg("用户名不能为空");
            json.setCode(401);
            return json;
        }
        if (password == null) {
            json.setSuccess(false);
            json.setMsg("账号密码不能为空");
            json.setCode(401);
            return json;
        }
        try {
            boolean userStste = userService.updateUser(userName,password);
            if (userStste == true) {
                json.setSuccess(true);
                json.setCode(200);
                json.setMsg("验证成功");
            } else {
                json.setSuccess(false);
                json.setCode(500);
                json.setMsg("验证失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

}
