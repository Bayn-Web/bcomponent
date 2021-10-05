package com;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class StrutsAction extends ActionSupport {
    private String nameAAA;

    public String getNameAAA() {
        return nameAAA;
    }

    public void setNameAAA(String nameAAA) {
        this.nameAAA = nameAAA;
    }

    @Override
    public String execute() throws Exception {
        Map request= (Map) ActionContext.getContext().get("request");
        request.put("nameKEY",nameAAA);
        if(nameAAA.equals("123")){
            return "error";
        }else{
        return "success";
    }
    }
}
