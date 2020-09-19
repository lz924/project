package com.etc.studentsystem.daoimpl;

import com.etc.studentsystem.dao.StudentDao;
import com.etc.studentsystem.entity.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDaoImpl implements StudentDao {
    // StudentDao层被创建出来之后第一件事就是执行块里的代码

    static HashMap<Integer, Student> map ;//定义集合对象
    static {
        map = new HashMap<>();
        map.put(1817700123, new Student(1817700123, "123qq", "xjq", "2018级1班", "503","班长"));
        map.put(1817700125, new Student(1817700125, "456aa", "xlj", "2018级2班", "403","组长"));
        map.put(1817700128, new Student(1817700128, "789zz", "ztx", "2018级3班", "603","学员"));
    }

    public static Integer[] get(Map map){
        int i = 0;
        Set<Integer> set = map.keySet();
        Integer[] stu = set.toArray(new Integer[set.size()]);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            Integer key = (it.next());
            i++;
        }
        return stu;
    }


    /**
     * 过学号判断密码，并登录(对象数组)
     * @param sno
     * @param pwd
     * @return
     */
    public Student login(Integer sno, String pwd) {
//        定义布尔类型标识
        Student s = null;
//        遍历静态数组
        for (int i = 0; i < map.size(); i++) {
            //判断有无此用户
            if (get(map)!= null) {
//                System.out.println(get(map)[i] + "   " + map.get(get(map)[i]).getPwd());
                if (sno.equals(get(map)[i]) && pwd.equals(map.get(get(map)[i]).getPwd())) {
                    s = map.get(get(map)[i]);
                    break;
                }
            }
        }
        return s;
    }

    /**
     * 实现注册功能
     * @param sno
     * @param stu
     * @return
     */
    public String regist(Integer sno, Student stu) {
//        定义布尔标识
        boolean flag = true;
//        遍历数组
        for (int i = 0; i < map.size(); i++) {
            //判断是否有位置
            if (get(map) != null) {
                if (sno.equals(get(map)[i])){
                    System.out.println("此用户存在...");
                    flag = false;
                    break;
                }
            }
        }
//        判断标识符，并返回结果值
        if (flag) {
//          不满足上述条件之后添加用户
            map.put(sno,stu);
            return "注册成功...";
        } else {
            return "学生已经存在...";
        }
    }

    /**
     * 增加学生信息
     * @param stu
     * @return
     */
    public Student addInfo(Student stu) {
//        添加布尔标识
        boolean flag = true;
        Student s = null;
        for (int i = 0; i < map.size(); i++) {
            if (get(map) != null) {//判断有无此用户
                if (stu.getSno().equals(get(map)[i])) {
                    System.out.println("此班级已满或此用户存在...");
                    flag = false;
                    break;//满足条件结束遍历
                }
            }
        }
//      判断标识符，并返回结果值
        if (flag){
            //添加学生信息
            map.put(stu.getSno(),stu);
        }
        s = stu;
        return s;
    }

    /**
     *
     * 通过sno查找学生
     */
    public Student findInfo(Integer sno) {
        Student s = null;
        for (int i = 0; i < map.size(); i++) {
            if (get(map) != null) {
                if (sno .equals(get(map)[i])) {
                    System.out.println(map.get(sno));
                    s = map.get(get(map)[i]);
                    break;
                }
            }else {
                System.out.println("用户不存在...");
                break;
            }
        }
        return s;
    }

    @Override
    public String getSname() {
        return null;
    }

    /**
     *
     * 通过sno删除学生
     */
    public boolean deleteInfo(Integer sno) {
        boolean flag = false;
        for (int i = 0; i < map.size(); i++) {
            if (get(map) != null) {
                if (sno.equals(get(map)[i])) {
                    map.remove(get(map)[i]);
                    flag = true;
                    break;
                }
            }else {
                System.out.println("用户不存在...");
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     *
     * 修改学生信息
     */
    public boolean updateInfo(Student stu) {
        boolean flag = false;
        for (int i = 0; i < map.size(); i++) {
            if (get(map) != null) {
                if (stu.getSno().equals(get(map)[i])) {
                    System.out.println("修改前：" + map.get(get(map)[i]));
                    Student s = map.get(get(map)[i]);
                    s = stu;
                    System.out.println("修改后：" + s.toString());
                    flag = true;
                    break;
                }
            }else{
                System.out.println("用户不存在...");
                flag = false;
                break;
            }
        }
        return flag;
    }
}
