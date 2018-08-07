package com.hand.api.service;

import com.hand.infra.dataobject.FilmDO;

public interface FilmService {

    void createFilm(FilmDO filmDO);

    void getEvnAndInsertFilm(FilmDO filmDO, Boolean throwEx);
}
