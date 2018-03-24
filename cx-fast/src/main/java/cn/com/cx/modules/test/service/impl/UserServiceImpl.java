package cn.com.cx.modules.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cx.common.exception.RRException;
import cn.com.cx.common.validator.Assert;
import cn.com.cx.modules.test.dao.UserDao;
import cn.com.cx.modules.test.entity.UserEntity;
import cn.com.cx.modules.test.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity queryObject(Long userId) {
		return userDao.queryObject(userId);
	}

	@Override
	public List<UserEntity> queryList(Map<String, Object> map) {
		return userDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return userDao.queryTotal(map);
	}

	@Override
	public void save(String mobile, String password) {
		UserEntity user = new UserEntity();
		user.setMobile(mobile);
		user.setUsername(mobile);
		user.setPassword(DigestUtils.sha256Hex(password));
		user.setCreateTime(new Date());
		userDao.save(user);
	}

	@Override
	public void update(UserEntity user) {
		userDao.update(user);
	}

	@Override
	public void delete(Long userId) {
		userDao.delete(userId);
	}

	@Override
	public void deleteBatch(Long[] userIds) {
		userDao.deleteBatch(userIds);
	}

	@Override
	public UserEntity queryByMobile(String mobile) {
		return userDao.queryByMobile(mobile);
	}

	@Override
	public long login(String mobile, String password) {
		UserEntity user = queryByMobile(mobile);
		Assert.isNull(user, "手机号或密码错误");

		// 密码错误
		if (!user.getPassword().equals(DigestUtils.sha256Hex(password))) {
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
}
