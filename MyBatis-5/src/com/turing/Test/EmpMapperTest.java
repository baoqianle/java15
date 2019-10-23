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
    
    //8、根据id删除员工。
	@Test
	public void testDeleteByPrimaryKey() {
	 	int deleteByPrimaryKey = mapper.deleteByPrimaryKey(11);
	 	session.commit();
	 	System.out.println(deleteByPrimaryKey);
	}
	
    //10、添加“开发部”部门。
	@Test
	public void testInsert() {
		Dept dept=new Dept();
		dept.setDname("开发部");
		deptmapper.insert(dept);
		session.commit();
	}
	
	//2、根据名称查询部门。
	//3、查询id为2，并且姓名为“高手”的员工。
	@Test
	public void testSelectByExample() {
		EmpExample example=new EmpExample();
		//关键方法，所有条件的方法都封装在该Criteria对象身上
		//方法都是以andXXX开头
		Criteria createCriteria = example.createCriteria();
		//设置条件
		createCriteria.andNameEqualTo("万人迷");
		/* createCriteria.andIdEqualTo(2); */
		List<Emp> selectByExample = mapper.selectByExample(example);
		System.out.println(selectByExample);
	}
    
	//1、根据id查询员工。
	@Test
	public void testSelectByPrimaryKey() {
		Emp selectByPrimaryKey = mapper.selectByPrimaryKey(3);
	   System.out.println(selectByPrimaryKey);
	}
    
	//9、把2号员工姓名改为“万人迷”,未修改的字段不变。
	@Test
	public void testUpdateByPrimaryKey() {
		Emp emp=new Emp();
		emp.setId(2);
		emp.setName("万人迷");
		mapper.updateByPrimaryKeySelective(emp);
		session.commit();
	}
    
	   //分页查询 6、分页查询，每页显示5条，查询第二页员工信息。
		@Test
		public void testSelectByPrimaryKey3() {
		   int pageSize=5;
		   int pageNow=2;
		   pageNow=(pageNow-1)*pageSize;
	 	   EmpExample example=new EmpExample();
	       RowBounds rowBounds=new RowBounds(pageNow,pageSize);	
	       
		}
		}

