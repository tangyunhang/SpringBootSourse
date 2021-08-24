package com.abc.requestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class MyRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> paramsMap = new HashMap<>();
    private Map<String, String> headerMap = new HashMap<>();

    public MyRequestWrapper(HttpServletRequest request) {
        super(request);
        this.paramsMap.putAll(request.getParameterMap());
    }

    public void addParameter(String name, String value) {
        if (paramsMap.containsKey(name)) {
            String[] parameterValues = getParameterValues(name);
            parameterValues = Arrays.copyOf(parameterValues, parameterValues.length + 1);
            parameterValues[parameterValues.length - 1] = value;
        } else {
            paramsMap.put(name, new String[]{value});
        }
    }

    public void modifyParameter(String name, String value) {
        if (null != getParameter(name)) {
            paramsMap.get(name)[0] = value;
        }
    }

    @Override
    public String getParameter(String name) {
        if (paramsMap.containsKey(name)) {
            return paramsMap.get(name).length > 0 ? paramsMap.get(name)[0] : null;
        }
        return null;
    }

    @Override
    public String[] getParameterValues(String name) {
        return paramsMap.get(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return Collections.unmodifiableMap(paramsMap);
    }

    @Override
    public String getQueryString() {
        StringBuilder sb = new StringBuilder();
        if(paramsMap != null){
            sb.append("{");
          for (Map.Entry<String,String[]> e : paramsMap.entrySet()){
              sb.append(e.getKey()).append("=[");
              if(e.getValue().length>1){
                  int index = e.getValue().length;
                  while (index>=1){
                      sb.append(e.getValue()[index-1]).append(index==1?"":",");
                      index--;
                  }
              }else {
                  sb.append(e.getValue()[0]);
              }
              sb.append("]");
          }
          sb.append("}");
        }
        return sb.toString();
    }
}