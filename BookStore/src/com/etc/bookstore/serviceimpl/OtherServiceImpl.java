package com.etc.bookstore.serviceimpl;

import com.etc.bookstore.dao.OtherDao;
import com.etc.bookstore.dao.UserDao;
import com.etc.bookstore.daoimpl.OtherDaoImpl;
import com.etc.bookstore.daoimpl.UserDaoImpl;
import com.etc.bookstore.entity.Bk;
import com.etc.bookstore.entity.Role;
import com.etc.bookstore.service.OtherService;
import com.etc.bookstore.util.Log;

import java.sql.SQLException;
import java.util.List;

public class OtherServiceImpl implements OtherService {
    /**
     * 添加书
     * @return
     */
    @Override
    public int addBookOther(Bk bk) throws SQLException {
        OtherDao dao = new OtherDaoImpl();
        int no = 0;
        try {
//        打开事务
            ((OtherDaoImpl)dao).openTransaction();
//            添加类型信息
            int type = dao.addType(bk.getType_no());
            bk.getType_no().setType_no(type);
//            添加类型信息
            int re = dao.addRepertory(bk.getRepertory_no());
            bk.getRepertory_no().setRepertory_no(re);
//            添加书信息
            no = dao.addBk(bk);
//        提交事务
            ((OtherDaoImpl)dao).commitTransaction();
        }catch (Exception e) {
//        回滚事务
            ((OtherDaoImpl)dao).rollbackTransaction();
//            添加日志
            Log.mylog.debug(e.getMessage());
            e.printStackTrace();
        }finally {
//        关闭资源
            ((OtherDaoImpl)dao).closeDB();
        }
        return no;
    }

    /**
     * 查找书及相关信息
     * @return
     */
    @Override
    public List<Bk> getBookOther() {
        OtherDao dao = new OtherDaoImpl();
        List<Bk> bk = null;
        try {
            bk = dao.getBookOther();
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((OtherDaoImpl) dao).closeDB();
        }
        return bk;
    }
}
