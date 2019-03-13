package com.example.pmsserver.service;

import com.example.pmsserver.bean.MType;
import com.example.pmsserver.mapper.MTypeMapper;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/12 18:24
 * @Description:
 */
@Transactional
@Service
public class MTypeService {
    @Autowired
    MTypeMapper mTypeMapper;

    /**
     * @param name
     * @return 0 成功
     *       1 该类型名已存在
     *       2 失败
     */
    public int addType(String name){
        if(mTypeMapper.getTypeByName(Util.getCurrentUser().getId(),name)!=null){
            return 1;
        }else {
            if(mTypeMapper.addType(Util.getCurrentUser().getId(),name,0)==1){
                return 0;
            }else {
                return 2;
            }
        }

    }

    public MType getTypeByName(String name){
        return mTypeMapper.getTypeByName(Util.getCurrentUser().getId(),name);
    }

    public List<MType> getTypes(){
        return mTypeMapper.getTypes(Util.getCurrentUser().getId());
    }

    public int updateName(Long id,String name){
        if(mTypeMapper.getTypeByName(Util.getCurrentUser().getId(),name)!=null){
            return 1;
        }else {
            if(mTypeMapper.updateName(id, name)==1){
                return 0;
            }else {
                return 2;
            }
        }
    }

    /**
     *
     * @param id
     * @param number
     * @return 0 成功
     *          1 未找到该Id的类型
     *          2 失败
     */
    public int updateNumber(Long id, int number){
        MType mType =mTypeMapper.getTypeById(id);
        if(mType!=null){
            number =mType.getSubNumber()+1;
            if(mTypeMapper.updateNumber(id,number)==1){
                return 0;
            }else {
                return 2;
            }
        }else {
            return 1;
        }
    }

    public int deleteType(Long id){
        return mTypeMapper.deleteType(id);
    }

}
