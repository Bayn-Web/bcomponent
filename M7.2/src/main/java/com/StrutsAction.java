package com;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class StrutsAction extends ActionSupport {
    public String num1,num2;

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }
    @Override
    public String execute() throws Exception{
        @SuppressWarnings("unchecked")
        Map<String,Integer> request= (Map<String,Integer>) ActionContext.getContext().get("request");
        int n=Integer.parseInt(num1);
        int n1=Integer.parseInt(num2);
        int n2=n1*n;
        request.put("n",n);
        request.put("n1",n1);
        request.put("fin",n2);
        return "success";
    }
}
