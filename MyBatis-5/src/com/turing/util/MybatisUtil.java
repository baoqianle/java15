package com.turing.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.turing.util.MybatisUtil;

public class MybatisUtil {
	//һ�����ʹ���һ��ʵ������˽�У�����ģʽ---����ʽ��
	   private static MybatisUtil instance=new MybatisUtil();
	   private static SqlSessionFactory factory;
	//����SqlSessionFactory�����ã���˽��
      private MybatisUtil() {
     try {
     	factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
 }
  
//���Ⱪ¶һ�����еķ�������õ���SqlSessionFactory��ʵ��
  public static SqlSession openSession() {
 	 return instance.factory.openSession();
  }
}
