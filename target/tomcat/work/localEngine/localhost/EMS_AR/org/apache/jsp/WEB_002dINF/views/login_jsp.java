package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"en\" class=\"no-js\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>LOGIN</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/login/css/reset.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/login/css/supersized.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/login/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("            <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"page-container\">\r\n");
      out.write("\t\t<h1>Login</h1>\r\n");
      out.write("\t\t<form action=\"\" method=\"post\" >\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"username\" class=\"username\" id=\"username\"\r\n");
      out.write("\t\t\t\tplaceholder=\"Username\"> <input type=\"password\"\r\n");
      out.write("\t\t\t\tname=\"password\" class=\"password\" id=\"password\" placeholder=\"Password\">\r\n");
      out.write("\t\t\t<button type=\"submit\" id=\"onlogin\">Sign me in</button>\r\n");
      out.write("\t\t\t<div class=\"error\">\r\n");
      out.write("\t\t\t\t<span>+</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- Javascript -->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/login/js/jquery-1.8.2.min.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/login/js/supersized.3.2.7.min.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/login/js/supersized-init.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/login/js/scripts.js\"></script>\r\n");
      out.write("\t\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/login.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
