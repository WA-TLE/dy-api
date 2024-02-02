package com.dy.project.service.impl;

import java.util.Date;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dy.project.common.ErrorCode;
import com.dy.project.exception.BusinessException;
import com.dy.project.mapper.UserInterfaceInfoMapper;
import com.dy.project.model.entity.InterfaceInfo;
import com.dy.project.model.entity.UserInterfaceInfo;
import com.dy.project.service.UserInterfaceInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 微光
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
 * @createDate 2024-02-02 22:09:07
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {
    /**
     * 判断接口信息是否有效
     *
     * @param userInterfaceInfo
     * @param add
     */
    @Override
    public void validInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {


        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer status = userInterfaceInfo.getStatus();



        if (add) {
            if (ObjectUtils.anyNull(userId, interfaceInfoId, totalNum, leftNum)) {

                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (totalNum < 0 || leftNum < 0 ) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户调用次数有误");
        }


    }
}




