//package com.example.__Zuul;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TokenParamPreFilter extends ZuulFilter {
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        if (request.getParameter("token") == null) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(403);
//        }
//        return null;
//    }
//
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
//    }
//
//}