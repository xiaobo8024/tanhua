package com.tanhua.server.interceptor;

import com.tanhua.domain.db.User;

public class UserHolder {
    private static ThreadLocal<User> userThreadLocal=new ThreadLocal<User>();

    /**
     * 获取当前线程User中的id
     * @return
     */
    public static Long getUserId(){

        return userThreadLocal.get().getId();
    }

    /**
     * 获取当前线程的User
     * @return
     */
    public static User getUser(){
        return userThreadLocal.get();
        }

    /**
     * 向当前线程存入user
     */
    public static void setUser(User user){
        userThreadLocal.set(user);
    }


}