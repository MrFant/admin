package com.fanyi.admin.service;

import com.fanyi.admin.domain.Gaikuang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GaikuangService {
    Gaikuang saveGaikuang(Gaikuang gaikuang);


    void removeGaikuang(Long id);


    void removeGaikuangsInBatch(List<Gaikuang> gaikuangs);

    Gaikuang updateGaikuang(Gaikuang gaikuang);

    Gaikuang getGaikuangById(Long id);


    List<Gaikuang> listGaikuangs();


    Page<Gaikuang> listGaikuangsByNameLike(String name, Pageable pageable);
}
