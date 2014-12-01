package org.xhome.ly.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhome.ly.bean.Options;
import org.xhome.ly.common.Response;
import org.xhome.ly.service.OptionsService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by onglchen
 * on 14-12-1.
 */
@Controller
public class OptionsAction {

    @Autowired
    private OptionsService optionsService;

    /**
     *
      * @param request
     * @param options 选项的json格式
     * @return  返回状态 0 成功  1 失败
     */
    @ResponseBody
    @RequestMapping(value = "/api/options", method = RequestMethod.POST)
    public Object add(HttpServletRequest request, @RequestBody Options options){
        int status;
        status = optionsService.add(options);
        return new Response(status);
    }

    /**
     *
     * @param request
     * @param options   选项的json格式
     * @return  返回状态 0 成功  1 失败  7 不存在
     */
    @ResponseBody
    @RequestMapping(value = "/api/options", method = RequestMethod.PATCH)
    public Object update(HttpServletRequest request, @RequestBody Options options){
        int status;
        status = optionsService.update(options);
        return new Response(status);
    }

    /**
     *
     * @param request
     * @param options   选项的json格式
     * @return  返回状态 0 成功  1 失败  7 不存在
     */
    @ResponseBody
    @RequestMapping(value = "/api/options", method = RequestMethod.DELETE)
    public Object delete(HttpServletRequest request, @RequestBody Options options){
        int status;
        status = optionsService.delete(options);
        return new Response(status);
    }
}