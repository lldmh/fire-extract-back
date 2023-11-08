package com.ncut.fireextractback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ncut.fireextractback.mapper.ReptileDataMapper;
import com.ncut.fireextractback.service.ReptileDataService;
import org.springframework.stereotype.Service;
import com.ncut.fireextractback.domain.entity.ReptileData;

/**
 * (ReptileData)表服务实现类
 *
 * @author makejava
 * @since 2023-11-03 09:08:15
 */
@Service("reptileDataService")
public class ReptileDataServiceImpl extends ServiceImpl<ReptileDataMapper, ReptileData> implements ReptileDataService {

}

