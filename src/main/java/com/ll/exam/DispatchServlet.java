package com.ll.exam;

import com.ll.exam.Member.MemberController;
import com.ll.exam.article.ArticleController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        Rq rq = new Rq(req,resp);

        ArticleController articleController = new ArticleController();
        MemberController memberController = new MemberController();

        switch ( rq.getMethod()) {
            case "GET":

            switch(rq.getPath())  {
                case "/usr/article/list/free":
                    articleController.showList(rq);
                    break;
                case "/usr/article/write/free":
                    articleController.showWrite(rq);
                    break;
                case "/usr/member/login":
                    memberController.showLogin(rq);
                    break;
            }
            break;
            case "POST":
                switch(rq.getPath())  {
                    case "/usr/article/write/free":
                        articleController.showWrite(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
