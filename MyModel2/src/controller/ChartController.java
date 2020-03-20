package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import mskim.annotation.ActionAnnotation;



public class ChartController extends ActionAnnotation {

	@Override
	public void initProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
   
}
