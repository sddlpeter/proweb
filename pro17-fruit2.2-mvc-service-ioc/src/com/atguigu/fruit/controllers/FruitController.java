package com.atguigu.fruit.controllers;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.myssm.util.StringUtil;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class FruitController {
    private FruitDAO fruitDAO = new FruitDAOImpl();

    private String update(Integer fid, String fname, Integer price, Integer fcount, String remark) {

        fruitDAO.updateFruit(new Fruit(fid,fname, price ,fcount ,remark ));

        // super.processTemplate("index", request, resp);
        // resp.sendRedirect("fruit.do");
        return "redirect:fruit.do";

    }

    private String edit(Integer fid, HttpServletRequest request) {
        if (fid != null) {
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit", fruit);
            // super.processTemplate("edit", req, resp);
            return "edit";
        }
        return "error";
    }

    private String delete(Integer fid) {
        if (fid != null) {
            fruitDAO.delFruit(fid);
            return "redirect:fruit.do";
        }
        return "error";
    }


    private String add(String fname, Integer price, Integer fcount, String remark) {
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitDAO.addFruit(fruit);
        // resp.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }

    private String index(String oper, String keyword, Integer pageNo, HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (pageNo == null) {
            pageNo = 1;
        }

        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            pageNo = 1;
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            Object keywordObj =  session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword, pageNo);

        session.setAttribute("fruitList", fruitList);

        int fruitCount = fruitDAO.getFruitCount(keyword);
        int pageCount = fruitCount / 5 + 1;
        session.setAttribute("pageCount", pageCount);

        // super.processTemplate("index", req, resp);
        return "index";
    }
}
