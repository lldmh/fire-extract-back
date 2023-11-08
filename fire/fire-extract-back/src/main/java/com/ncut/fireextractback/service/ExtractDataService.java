package com.ncut.fireextractback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ncut.fireextractback.domain.ResponseResult;
import com.ncut.fireextractback.domain.dto.AddExtractDataDto;
import com.ncut.fireextractback.domain.dto.UpdateExtractDataDto;
import com.ncut.fireextractback.domain.entity.ExtractData;


/**
 * (ExtractData)表服务接口
 *
 * @author makejava
 * @since 2023-11-02 21:58:24
 */
public interface ExtractDataService extends IService<ExtractData> {

//    获得全部列表和总条数
//    ResponseResult getWeChatInfoListandNumber();
//    获得分页查询所有异常信息
    ResponseResult getExtractDataList(Integer pageNum, Integer pageSize);
//    添加
    ResponseResult addExtractData(AddExtractDataDto addExtractDataDto);
//    更新用户信息(根据id+回显)
    ResponseResult updateExtractData(UpdateExtractDataDto updateExtractDataDto);
//    删除用户
    ResponseResult deleteExtractData(Long id);

//    //    获得全部列表
//    ResponseResult getUserInfoList(Integer pageNum, Integer pageSize, UserInfoDto userInfoDto);
//    //    添加用户
//    ResponseResult addUser(AdminUserDto fireextractbackUserDto);
//    //    删除用户
//    ResponseResult deleteUser(Long id);
//    //    通过id获取用户信息
//    ResponseResult getUserInfoById(Long id);
//    //    更新用户信息
//    ResponseResult updateUserInfo(UpdateUserInfoRoleIdDto updateUserInfoRoleIdDto);
}

