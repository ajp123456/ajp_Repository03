package cn.itcast.jb.Jdbctemplate;

import cn.itcast.jb.Emp;
import cn.itcast.jb.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by 艾敬鹏 on 2020/4/12.
 */
public class JdbcTemplateDemo2 {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSouce());

    @Test
    public void test1(){

        //1.获取JDBCTemplate对象
        //2.定义sql
        String sql="update emp set salary=1000 where id=1001";
        //3.执行sql
        int count=template.update(sql);
        System.out.println(count);

    }
    @Test
    public void test2(){
        String sql="insert into emp (id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);

    }
    @Test
    public void test3(){
        String sql="delete from emp where id=?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }
    //4.查询id=1的记录，将其封装为Map集合
    @Test
    public void test4(){
        String sql="select * from emp where id=?";
        Map<String,Object> map=template.queryForMap(sql,1001);
        System.out.println(map);
    }
    @Test
    public void test5(){
        String sql="select * from emp";
        List<Map<String,Object>> list=template.queryForList(sql);
        for(Map<String,Object> stringObjectMap:list){
            System.out.println(stringObjectMap);
        }
    }
    //查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test6(){
        String sql="select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Nullable
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp=new Emp();
                int id=rs.getInt("id");
                String ename=rs.getString("ename");
                int job_id=rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);








                return emp;
            }
        });
        for(Emp emp:list){
            System.out.println(emp);
        }
    }
    @Test
    public void test6_2(){
        String sql="select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for(Emp emp:list){
            System.out.println(emp);
        }
    }
    //查询总记录
    @Test
    public void teat7(){
        String sql="select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
    /*
    1.修改1号数据的salary为10000
    2.添加一条记录
    3.删除刚才添加的记录
    4.查询id=1记录，并将其封装为Map集合
    5.查询所有的记录,将其封装为List
    6.查询所有记录，将其封装为Emp对象的 List集合
    7.查询总记录数
    */

    @Test
    public void test8(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSouce());
        String sql="insert into emp (id,ename) values(?,?)";
        int i = template.update(sql, 1014, "韩欣冉");
        System.out.println(i);
    }
    @Test
    public void test9(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSouce());
        String sql="delete from emp where id=?";
        int i = template.update(sql, 1014);
        System.out.println(i);
    }
    @Test
    public void test10(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSouce());
        String sql="select * from emp where id=?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);

    }
    @Test
    public void test11(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSouce());
        String sql="select * from emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for(Map<String,Object> map:maps){
            System.out.println(map);
        }
    }
    //查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test12(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSouce());
        String sql="select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for(Emp emp:list){
            System.out.println(list);
        }

    }
    //查询总记录
    @Test
    public void test13(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSouce());
        String sql="select count(id) from emp";
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println(aLong);

    }











}
