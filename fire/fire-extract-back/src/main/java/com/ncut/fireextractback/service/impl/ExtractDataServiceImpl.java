package com.ncut.fireextractback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ncut.fireextractback.domain.ResponseResult;
import com.ncut.fireextractback.domain.dto.AddExtractDataDto;
import com.ncut.fireextractback.domain.dto.UpdateExtractDataDto;
import com.ncut.fireextractback.domain.entity.ExtractData;
import com.ncut.fireextractback.domain.vo.ExtractDataVo;
import com.ncut.fireextractback.enums.AppHttpCodeEnum;
import com.ncut.fireextractback.exception.SystemException;
import com.ncut.fireextractback.mapper.ExtractDataMapper;
import com.ncut.fireextractback.service.ExtractDataService;
import com.ncut.fireextractback.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * (ExtractData)表服务实现类
 *
 * @author makejava
 * @since 2023-11-02 21:58:24
 */
@Service("extractDataService")
public class ExtractDataServiceImpl extends ServiceImpl<ExtractDataMapper, ExtractData> implements ExtractDataService {

    @Autowired
    private ExtractDataMapper extractDataMapper;

    @Override
    public ResponseResult getExtractDataList(Integer pageNum, Integer pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);

        //        1.根据用户名(模糊查询)和状态进行查询
        LambdaQueryWrapper<ExtractData> queryWrapper = new LambdaQueryWrapper<>();
        ExtractData extractData = new ExtractData();
        extractData.setIsDelete(0);
        queryWrapper.eq(ExtractData::getIsDelete, extractData.getIsDelete());
//        2.分页查询
        Page<ExtractData> page = new Page(pageNum, pageSize);
        extractDataMapper.selectPage(page, queryWrapper);
        List<ExtractData> extractDatas = page.getRecords();

//        3.将当前页中的ExtractDataVo对象转换为ExtractDataVo对象
        List<ExtractDataVo> extractDataVos = BeanCopyUtils.copyBeanList(extractDatas, ExtractDataVo.class);
        return ResponseResult.okResult(extractDataVos);
//        return null;
    }

    @Override
    public ResponseResult addExtractData(AddExtractDataDto addExtractDataDto) {
//        3.判断信息是否为空
        if (!StringUtils.hasText(addExtractDataDto.getOname()) ||
                !StringUtils.hasText(addExtractDataDto.getOtype()) ||
                !StringUtils.hasText(addExtractDataDto.getShip()) ||
                !StringUtils.hasText(addExtractDataDto.getSname()) ||
                !StringUtils.hasText(addExtractDataDto.getStype())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_IS_BLANK);
        }
        ExtractData extractData = new ExtractData();
        extractData.setOtype(addExtractDataDto.getOtype());
        extractData.setOname(addExtractDataDto.getOname());
        extractData.setStype(addExtractDataDto.getStype());
        extractData.setSname(addExtractDataDto.getSname());
        extractData.setShip(addExtractDataDto.getShip());
        extractData.setIsDelete(0);
//        4.判断信息是否存在
        if (!judgeExtractData(addExtractDataDto)){
            System.out.println("我到这里了");
            return ResponseResult.errorResult(AppHttpCodeEnum.EXTRACTDATA_INFO_EXIST);
//            throw new SystemException(AppHttpCodeEnum.EXTRACTDATA_INFO_EXIST);
        }
//        5.保存用户
        save(extractData);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult updateExtractData(UpdateExtractDataDto updateExtractDataDto) {
//        2.将UpdateUserInfoRoleIdVo对象转换为User对象
        ExtractData extractData = BeanCopyUtils.copyBean(updateExtractDataDto, ExtractData.class);
        extractData.setIsDelete(0);
        //        4.判断信息是否存在
        AddExtractDataDto addExtractDataDto = BeanCopyUtils.copyBean(updateExtractDataDto, AddExtractDataDto.class);
        System.out.println(addExtractDataDto.toString());
        if (!judgeExtractData(addExtractDataDto)){
            return ResponseResult.errorResult(AppHttpCodeEnum.EXTRACTDATA_INFO_EXIST);
        }
//        2.根据用户id修改用户信息
        LambdaQueryWrapper<ExtractData> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExtractData::getId, extractData.getId());
        if (!judgeExtractDataDelete(addExtractDataDto)){
            return ResponseResult.errorResult(AppHttpCodeEnum.DELETE_EXTRACTDATA_INFO_EXIST);
        }
        update(extractData, queryWrapper);
        System.out.println("成功");
        return ResponseResult.okResult();
    }

//    //根据id查询分类,回显
//    @Override
//    public ResponseResult getCategoryById(Long id) {
////        1.根据id查询友链
//        Category category = getById(id);
////        2.将Link对象封装为LinkVo对象
//        CategoryTwoVo categoryVo = BeanCopyUtils.copyBean(category, CategoryTwoVo.class);
//        return ResponseResult.okResult(categoryVo);
//    }


    @Override
    public ResponseResult deleteExtractData(Long id) {
        System.out.println("我要开始删除啦");
        LambdaQueryWrapper<ExtractData> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExtractData::getId, id);
        ExtractData extractData =getById(id);
        extractData.setIsDelete(1);
        update(extractData, queryWrapper);
//        removeById(id);
        return ResponseResult.okResult();
    }


    /**
     * 判断该异常信息是否存在
     * @param extractData
     * @return
     */
    public boolean judgeExtractData(AddExtractDataDto extractData){
        LambdaQueryWrapper<ExtractData> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExtractData::getOtype, extractData.getOtype());
        queryWrapper.eq(ExtractData::getOname, extractData.getOname());
        queryWrapper.eq(ExtractData::getStype, extractData.getStype());
        queryWrapper.eq(ExtractData::getSname, extractData.getSname());
        queryWrapper.eq(ExtractData::getShip, extractData.getShip());
        queryWrapper.eq(ExtractData::getIsDelete, 0000);
        ExtractData extractData1 = getOne(queryWrapper);
        if (Objects.isNull(extractData1)){
            return true;
        }else{
            return false;
        }
    }
    public boolean judgeExtractDataDelete(AddExtractDataDto extractData){
        LambdaQueryWrapper<ExtractData> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExtractData::getOtype, extractData.getOtype());
        queryWrapper.eq(ExtractData::getOname, extractData.getOname());
        queryWrapper.eq(ExtractData::getStype, extractData.getStype());
        queryWrapper.eq(ExtractData::getSname, extractData.getSname());
        queryWrapper.eq(ExtractData::getShip, extractData.getShip());
        queryWrapper.eq(ExtractData::getIsDelete, 1);
        ExtractData extractData1 = getOne(queryWrapper);
        if (Objects.isNull(extractData1)){
            return true;
        }else{
            return false;
        }
    }



}

