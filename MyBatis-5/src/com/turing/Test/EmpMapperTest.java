package com.turing.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.turing.Mapper.DeptMapper;
import com.turing.Mapper.EmpMapper;
import com.turing.entity.Dept;
import com.turing.entity.Emp;
import com.turing.entity.EmpExample;
import com.turing.entity.EmpExample.Criteria;
import com.turing.util.MybatisUtil;

public class EmpMapperTest {
	SqlSession session;
	EmpMapper mapper;
	DeptMapper deptmapper;
	@Before
	public void start() {
		session=MybatisUtil.openSession();
		mapper=session.getMapper(EmpMapper.class);
		deptmapper=session.getMapper(DeptMapper.class);
	}
	
    @After
    public void end() {
		session.close();
	}
    
    //8������idɾ��Ա����
	@Test
	public void testDeleteByPrimaryKey() {
	 	int deleteByPrimaryKey = mapper.deleteByPrimaryKey(11);
	 	session.commit();
	 	System.out.println(deleteByPrimaryKey);
	}
	
    //10����ӡ������������š�
	@Test
	public void testInsert() {
		Dept dept=new Dept();
		dept.setDname("������");
		deptmapper.insert(dept);
		session.commit();
	}
	
	//2���������Ʋ�ѯ���š�
	//3����ѯidΪ2����������Ϊ�����֡���Ա����
	@Test
	public void testSelectByExample() {
		EmpExample example=new EmpExample();
		//�ؼ����������������ķ�������װ�ڸ�Criteria��������
		//����������andXXX��ͷ
		Criteria createCriteria = example.createCriteria();
		//��������
		createCriteria.andNameEqualTo("������");
		/* createCriteria.andIdEqualTo(2); */
		List<Emp> selectByExample = mapper.selectByExample(example);
		System.out.println(selectByExample);
	}
    
	//1������id��ѯԱ����
	@Test
	public void testSelectByPrimaryKey() {
		Emp selectByPrimaryKey = mapper.selectByPrimaryKey(3);
	   System.out.println(selectByPrimaryKey);
	}
    
	//9����2��Ա��������Ϊ�������ԡ�,δ�޸ĵ��ֶβ��䡣
	@Test
	public void testUpdateByPrimaryKey() {
		Emp emp=new Emp();
		emp.setId(2);
		emp.setName("������");
		mapper.updateByPrimaryKeySelective(emp);
		session.commit();
	}
    
	   //��ҳ��ѯ 6����ҳ��ѯ��ÿҳ��ʾ5������ѯ�ڶ�ҳԱ����Ϣ��
		@Test
		public void testSelectByPrimaryKey3() {
		   int pageSize=5;
		   int pageNow=2;
		   pageNow=(pageNow-1)*pageSize;
	 	   EmpExample example=new EmpExample();
	       RowBounds rowBounds=new RowBounds(pageNow,pageSize);	
	       
		}
		}

