package com.diancan.web;

import com.diancan.domain.RestoBasicInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restinfo")
public class RestoController {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public RestoBasicInfo getRestBasicInfoById(@PathVariable long id) {

        return  null;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<RestoBasicInfo> getAllRestoBasicInfos() {
        return  null;
    }
    @RequestMapping(method = RequestMethod.POST)
    public Boolean addNewRestoBasicInfo(
            @RequestBody() String jonstr
    ) {
        return  false;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public boolean delOneRestoBasicInfoById(@PathVariable long id) {
        return  false;
    }
}
