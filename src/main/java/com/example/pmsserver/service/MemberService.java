package com.example.pmsserver.service;

import com.example.pmsserver.bean.MemberBean;
import com.example.pmsserver.mapper.MemberMapper;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/8 09:58
 * @Description:
 */
@Service
@Transactional
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    public List<MemberBean> getAll( int page,int count) {
        int start = (page-1)*count;
        return memberMapper.getAll(Util.getCurrentUser().getId(),start,count);
    }

    public int getCountOfUser(){
        return memberMapper.getCountOfUser(Util.getCurrentUser().getId());
    }

    public MemberBean getById(long id ) {
        return memberMapper.getbyId(id,Util.getCurrentUser().getId());
    }


    /**
     * @param id
     * @param amount
     * @return 0 失败
     * 1 成功
     */
    public int updateTotalAmount(Long id, BigDecimal amount) {
        MemberBean memberBean = memberMapper.getbyId(id,Util.getCurrentUser().getId());
        if (memberBean != null) {
            return memberMapper.updateTotalAmount(id, memberBean.getTotalAmount().add(amount));
        }
        return 0;
    }

    /**
     * @param memberBean
     * @return
     * 0 该号码已注册会员
     * 1 成功
     * 2 失败
     */
    public int addMember(MemberBean memberBean) {
        String phone = memberBean.getPhone();
        if (memberMapper.getbyPhone(phone,Util.getCurrentUser().getId())!=null) {
            return 0;
        }else {
            memberBean.setUid(Util.getCurrentUser().getId());
            memberBean.setTotalAmount(new BigDecimal(0));
            int result = memberMapper.add(memberBean);
            if (result == 1) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
