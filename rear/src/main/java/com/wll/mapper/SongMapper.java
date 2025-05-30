package com.wll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wll.pojo.DO.SongDO;
import com.wll.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wll
 * @since 2025-01-23
 */
public interface SongMapper extends BaseMapper<Song> {

    //    @Select("""
//            select id, singer_id, title, album, picture, lyric, url
//            from song
//            where id in (select song_id from list_song where song_list_id = #{songListId})
//            """)
    @Select("""
            select song.id,
                   singer_id,
                   title,
                   singer.name singer_name,
                   album,
                   picture,
                   lyric,
                   url,
                   lyric_url            
            from song
                     join singer on song.singer_id = singer.id
            where
                song.delete_flag = false
                and song.id in (select song_id from list_song where song_list_id = #{songListId})
            """)
    List<SongDO> getSongBySongListID(Integer songListId);


    @Select("""
            SELECT song.id,singer_id,title,album,picture,lyric,url,s.id AS singer_id,
            s.name as singerName,s.pic,s.sex,s.birth,s.introduction,s.location,s.song_number,s.album_number FROM song
            left join singer s on song.singer_id = s.id WHERE (title LIKE  concat('%', #{kw},'%') or s.name LIKE  concat('%', #{kw},'%') )
            """)
    List<Map<String, Object>> searchSongByTitle(String kw);

    List<SongDO> getLikedSongByUserId(long userId);


    List<SongDO> querySongByID(Song song);


    List<SongDO> searchSong(String keyword);

    boolean addSongToSongList(Integer songID, Integer songListID);

    boolean deleteSongFromSongList(Integer songID, Integer songListID);

    List<SongDO> searchSongFromSongList(Integer songListID, String kw);
}
