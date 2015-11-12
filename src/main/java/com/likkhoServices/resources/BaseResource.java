package com.likkhoServices.resources;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;
import com.likkhoServices.displayObjects.DisplaybleObject;
import com.likkhoServices.model.LikkhoModel;

/**
 * Created with IntelliJ IDEA.
 * User: kapilr
 * Date: 10/23/13
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseResource<T> extends SpringBeanAutowiringSupport{

    protected String toJson(DisplaybleObject obj) {
        return new Gson().toJson(obj);
    }

    protected T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
