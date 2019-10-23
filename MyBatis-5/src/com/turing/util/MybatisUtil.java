package com.turing.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.turing.util.MybatisUtil;

public class MybatisUtil {
	//一上来就创建一个实例，且私有（单例模式---饿汉式）
	   private static MybatisUtil instance=new MybatisUtil();
	   private static SqlSessionFactory factory;
	//声明SqlSessionFactory的引用，且私有
      private MybatisUtil() {
     try {
     	factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
 }
  
//对外暴露一个公有的方法，获得单个SqlSessionFactory的实例
  public static SqlSession openSession() {
 	 return instance.factory.openSession();
  }
}
