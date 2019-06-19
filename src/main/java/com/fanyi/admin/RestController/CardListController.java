package com.fanyi.admin.RestController;

import com.fanyi.admin.domain.CardListInfo;
import com.fanyi.admin.service.CardListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/CardList")
public class CardListController {
    private static final Logger logger= LoggerFactory.getLogger(CardListController.class);

    @Autowired
    CardListService cardListService;

//    @PreAuthorize("hasAuthority()")
    @GetMapping("/getList")
//    @CrossOrigin("http://localhost:3000")
    public List<CardListInfo> getList(
            @RequestParam(value = "size",required = false,defaultValue = "5") int size
    ){
        List<CardListInfo> listInfos=cardListService.getCardListInfos(size);
        return listInfos;
    }

}
