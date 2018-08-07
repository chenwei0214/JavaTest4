package com.hand.api.service.impl;

import java.util.Map;
import javax.annotation.Resource;

import com.hand.api.service.FilmService;
import com.hand.infra.dataobject.FilmDO;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Resource
    private FilmMapper filmMapper;

    @Override
    public void createFilm(FilmDO filmDO) {
        filmMapper.insert(filmDO);
    }

    @Override
    public void getEvnAndInsertFilm(FilmDO filmDO, Boolean throwEx) {
        filmMapper.insert(filmDO);
        if (throwEx) {
           throw new RuntimeException("手动异常测试事务");
        }
    }

}
