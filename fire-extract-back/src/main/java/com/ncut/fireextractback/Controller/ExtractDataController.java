package com.ncut.fireextractback.Controller;

import com.ncut.fireextractback.domain.ResponseResult;
import com.ncut.fireextractback.domain.dto.AddExtractDataDto;
import com.ncut.fireextractback.domain.dto.UpdateExtractDataDto;
import com.ncut.fireextractback.domain.entity.ExtractData;
import com.ncut.fireextractback.service.ExtractDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @Author dmh
 * @Date 2023/11/3 9:29
 * @Version 1.0
 * @introduce
 */
@RestController
@RequestMapping("/system/extractdata")
@Api(tags = "异常信息",description = "异常信息相关接口")
public class ExtractDataController {
    @Autowired
    private ExtractDataService extractDataService;


//    @GetMapping("/list")
//    public List<ExtractData> test(){
//        System.out.println("我到这里啦");
//        List<ExtractData> list = extractDataService.list();
//        System.out.println(list.size());
//        return list;
//    }

    /**
     * 获取总数
     * @return
     */
    @GetMapping("/number")
    @ApiOperation(value = "异常信息总数",notes = "获取异常信息总数")
    public Integer number(){
        System.out.println("开始获取总数：");
        List<ExtractData> list = extractDataService.list();
        System.out.println(list.size());
        return list.size();
    }

    /**
     * 分页查询所有异常信息-Admin
     *
     * @return {@link ResponseResult}
     */
    @GetMapping("/list")
    @ApiOperation(value = "异常信息列表",notes = "获取一页异常信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页号"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小")
    }
    )
    public ResponseResult getExtractDataList(Integer pageNum, Integer pageSize) {
        System.out.println("开始分页查询：");
        return extractDataService.getExtractDataList(pageNum, pageSize);
    }
    /**
     * 添加异常信息
     * @param addExtractDataDto 添加异常dto
     * @return {@link ResponseResult}
     */
    @PostMapping
    @ApiOperation(value = "添加异常信息",notes = "添加一条异常信息")
    public ResponseResult addextractData(@RequestBody AddExtractDataDto addExtractDataDto){
        return extractDataService.addExtractData(addExtractDataDto);
    }

    /**
     * 删除链接
     * @param id id
     * @return {@link ResponseResult}
     */
    @DeleteMapping()
    @ApiOperation(value = "删除异常信息",notes = "删除一条异常信息（这里只是让在查询的时候查不到了，并不是真的删除）")
    public ResponseResult deleteExtractData(Long id){
        return extractDataService.deleteExtractData(id);
    }
//    /**
//     * 根据id查询友链
//     * @param id id
//     * @return {@link ResponseResult}
//     */
//    @GetMapping("/{id}")
//    public ResponseResult getLinkOneById(@PathVariable Long id){
//        return linkService.getLinkOneById(id);
//    }


    /**
     * 修改友链
     * @param updateExtractDataDto
     * @return {@link ResponseResult}
     */
    @PutMapping
    public ResponseResult updateExtractData(@RequestBody UpdateExtractDataDto updateExtractDataDto){
        return extractDataService.updateExtractData(updateExtractDataDto);
    }
}
