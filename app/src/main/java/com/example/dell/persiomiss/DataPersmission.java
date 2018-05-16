package com.example.dell.persiomiss;

import android.Manifest;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: Data.java
 * @Package com.example.dell.persiomiss
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/16 21:07
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/16 星期三
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class DataPersmission {
    public static final String[] Persmission = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
            ,Manifest.permission.CALL_PHONE
    };
};
