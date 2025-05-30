package com.wll.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wll.enums.SongListEnum;
import com.wll.pojo.SongList;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wll
 * @since 2025-02-18
 */
public interface ISongListService extends IService<SongList> {

    boolean updateOrSaveRating(long userId, int songListId, int rating);

    Map<String, Object> getRatingBy(long userId, int songListId);

    int getEvenRatingOfSongList(int songListId);

    List<SongList> getRandomSongList(Integer capacity);

    SongListEnum chooseCategory(Integer style);
}
