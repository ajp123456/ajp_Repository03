package cn.itcast.jb;

import java.util.Date;

/**
 *
 * Created by 艾敬鹏 on 2020/4/9.
 */
public class Emp {
    private Integer id;
    private String ename;
    private Integer job_id;
    private Integer mgr;
    private Date joindate;
    private Double salary;
    private Double bonus;
    private Integer dept_id;



    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joindate=" + joindate +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dept_id=" + dept_id +
                '}';
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
}
