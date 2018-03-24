package cn.com.cx.modules.test.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.com.cx.modules.sys.dao.BaseDao;
import cn.com.cx.modules.test.entity.UserEntity;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);
}
