package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/jspservelt-app-friends-calculator/friends"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
    	String myName = request.getParameter("friend1");
    	String friendName = request.getParameter("friend2");
    	
        int result = calculate(myName,friendName);
		
        String calculate = request.getParameter("calculate");
        
        System.out.println(result);
        if(calculate!=null) {
//        	PrintWriter out = response.getWriter();
//        	out.println("<h3>Based on the name similarity, the friendship strength between "+myName+" and "+friendName+" is: "+result+"</h3>");
         	request.setAttribute("myName", myName);
        	request.setAttribute("friendName", friendName);
        	request.setAttribute("result", result);
        }
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	//Dont change the above lines of code
	
//	Start Enterinng your code here...
public static int findSum(int num) {
	int sum = 0;
	for (int i = 1; i <= num; i++) {
		sum += i;
	}
	return sum;
}


    public static int calculate(String person1, String person2) {
        String combinedNames = person1.toUpperCase() + person2.toUpperCase();
        int countF = 0;
        int countR = 0;
        int countI = 0;
        int countE = 0;
        int countN = 0;
        int countD = 0;
        int countS = 0;

        for (int i = 0; i < combinedNames.length(); i++) {
            char c = combinedNames.charAt(i);
            if (c == 'F') {
                countF++;
            } else if (c == 'R') {
                countR++;
            } else if (c == 'I') {
                countI++;
            } else if (c == 'E') {
                countE++;
            } else if (c == 'N') {
                countN++;
            } else if (c == 'D') {
                countD++;
            } else if (c == 'S') {
                countS++;
            }
        }

        int totalChars = countF + countR + countI + countE + countN + countD + countS;
        return (totalChars * 100) / 7;
    }
}



