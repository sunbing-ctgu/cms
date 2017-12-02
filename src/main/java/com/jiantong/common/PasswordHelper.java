package com.jiantong.common;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jiantong.vo.UserVo;


@Service
public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	// 指定散列算法为MD5,还有别的算法如：SHA256、SHA1、SHA512
	@Value("${password.algorithmName}")
	private String algorithmName = "md5";
	// 散列迭代次数 md5(md5(pwd)): new Md5Hash(pwd, salt, 2).toString()
	@Value("${password.hashIterations}")
	private int hashIterations = 2; 

	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	//加密：输入明文得到密文
    public void encryptPassword(UserVo user) {
    	user.setSalt(randomNumberGenerator.nextBytes().toHex());
    	String encodePassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
    	user.setPassword(encodePassword);
    }
	
}
