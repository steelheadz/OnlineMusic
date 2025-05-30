package com.wll.service.impl;

import com.wll.pojo.Likes;
import com.wll.mapper.LikesMapper;
import com.wll.service.ILikesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wll
 * @since 2025-03-05
 */
@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements ILikesService {

    @Resource
    private LikesMapper likesMapper;

    @Override
    public boolean add(Likes likes) {
        return likesMapper.add(likes);
    }
}
