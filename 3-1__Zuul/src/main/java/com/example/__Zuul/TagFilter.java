package com.example.__Zuul;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;


import javax.servlet.http.HttpServletRequest;

public class TagFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 7;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        double ran = Math.random()*100+1;
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
//        String tag = request.getHeader("tag");
        if(ran < 80.0){
            RibbonFilterContextHolder.getCurrentContext().add("Loadblance", "8A");
        }else{
            RibbonFilterContextHolder.getCurrentContext().add("Loadblance", "2B");
        }
        return null;
    }
}