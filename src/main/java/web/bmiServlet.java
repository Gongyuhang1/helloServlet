package web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class bmiServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		String weight=request.getParameter("weight");
		String height=request.getParameter("height");
		
		//依据身高和体重，计算BMI指数
		double bmi=Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);
		if(bmi<19) {
			System.out.println("太瘦！");
		}else if(bmi>25) {
			System.out.println("太重");
		}else {
			System.out.println("ok");
		}
		
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		out.println(bmi);
		out.close();
	}
}
