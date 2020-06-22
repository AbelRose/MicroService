package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class ManagerFilter extends ZuulFilter {

    /**
     * 执行的前还是后
     * @return
     */
    @Override
    public String filterType() {
        return "pre"; //之前执行
    }


    @Override
    public int filterOrder() {
        return 0; // 越小表示优先执行
    }

    /**
     *
     * 当前过滤器是否开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     *
     * 过滤器执行的内容
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过后台过滤器了");
        return null;
    }
}
