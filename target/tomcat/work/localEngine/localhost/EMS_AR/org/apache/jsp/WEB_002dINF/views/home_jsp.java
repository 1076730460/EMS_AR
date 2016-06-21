package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\" />\r\n");
      out.write("<title>考试管理系统</title>\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/easyui/css/default.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/easyui/js/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/easyui/js/themes/icon.css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/easyui/js/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/easyui/js/jquery.easyui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc='");
      out.print(request.getContextPath());
      out.write("/resources/easyui/js/outlook2.js'>\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//设置登录窗口\r\n");
      out.write("\tfunction openPwd() {\r\n");
      out.write("\t\t$('#w').window({\r\n");
      out.write("\t\t\ttitle : '修改密码',\r\n");
      out.write("\t\t\twidth : 300,\r\n");
      out.write("\t\t\tmodal : true,\r\n");
      out.write("\t\t\tshadow : true,\r\n");
      out.write("\t\t\tclosed : true,\r\n");
      out.write("\t\t\theight : 160,\r\n");
      out.write("\t\t\tresizable : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t//关闭登录窗口\r\n");
      out.write("\tfunction close() {\r\n");
      out.write("\t\t$('#w').window('close');\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//修改密码\r\n");
      out.write("\tfunction serverLogin() {\r\n");
      out.write("\t\tvar $newpass = $('#txtNewPass');\r\n");
      out.write("\t\tvar $rePass = $('#txtRePass');\r\n");
      out.write("\r\n");
      out.write("\t\tif ($newpass.val() == '') {\r\n");
      out.write("\t\t\tmsgShow('系统提示', '请输入密码！', 'warning');\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ($rePass.val() == '') {\r\n");
      out.write("\t\t\tmsgShow('系统提示', '请在一次输入密码！', 'warning');\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif ($newpass.val() != $rePass.val()) {\r\n");
      out.write("\t\t\tmsgShow('系统提示', '两次密码不一至！请重新输入', 'warning');\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(\r\n");
      out.write("\t\t\t\tmsg) {\r\n");
      out.write("\t\t\tmsgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');\r\n");
      out.write("\t\t\t$newpass.val('');\r\n");
      out.write("\t\t\t$rePass.val('');\r\n");
      out.write("\t\t\tclose();\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\r\n");
      out.write("\t\topenPwd();\r\n");
      out.write("\t\t//\r\n");
      out.write("\t\t$('#editpass').click(function() {\r\n");
      out.write("\t\t\t$('#w').window('open');\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$('#btnEp').click(function() {\r\n");
      out.write("\t\t\tserverLogin();\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t$('#loginOut').click(function() {\r\n");
      out.write("\t\t\t$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (r) {\r\n");
      out.write("\t\t\t\t\tlocation.href = '/ajax/loginout.ashx';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\" style=\"overflow-y: hidden\" scroll=\"no\">\r\n");
      out.write("\t<noscript>\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tstyle=\"position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;\">\r\n");
      out.write("\t\t\t<img\r\n");
      out.write("\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/easyui/images/noscript.gif\"\r\n");
      out.write("\t\t\t\talt='抱歉，请开启脚本支持！' />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</noscript>\r\n");
      out.write("\t<div region=\"north\" split=\"true\" border=\"false\"\r\n");
      out.write("\t\tstyle=\"overflow: hidden; height: 30px;\r\n");
      out.write("        background: url(");
      out.print(request.getContextPath());
      out.write("/resources/easyui/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;\r\n");
      out.write("        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体\">\r\n");
      out.write("\t\t<span style=\"float: right; padding-right: 20px;\" class=\"head\">欢迎\r\n");
      out.write("\t\t\t<a href=\"#\" id=\"editpass\">修改密码</a> <a href=\"#\" id=\"loginOut\">安全退出</a>\r\n");
      out.write("\t\t</span> <span style=\"padding-left: 10px; font-size: 16px;\"><img\r\n");
      out.write("\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/easyui/images/blocks.gif\"\r\n");
      out.write("\t\t\twidth=\"20\" height=\"20\" align=\"absmiddle\" /> 考试管理系统</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div region=\"south\" split=\"true\"\r\n");
      out.write("\t\tstyle=\"height: 30px; background: #D2E0F2;\">\r\n");
      out.write("\t\t<div class=\"footer\">\r\n");
      out.write("\t\t\t<span class=\"blue bolder\">云南航信空港网络</span> 研发部<strong class=\"green\">&copy;</strong>\r\n");
      out.write("\t\t\t2016 </span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div region=\"west\" split=\"true\" title=\"导航菜单\" style=\"width: 180px;\"\r\n");
      out.write("\t\tid=\"west\">\r\n");
      out.write("\t\t<div class=\"easyui-accordion\" fit=\"true\" border=\"false\">\r\n");
      out.write("\t\t\t<!--  导航内容 -->\r\n");
      out.write("\t\t\t<div title=\"岗位管理\" style=\"overflow: auto;\" icon=\"icon-sys\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 试题类型管理 -->\r\n");
      out.write("\t\t\t<div title=\"试题类型管理\" style=\"overflow: auto;\" icon=\"icon-sys\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 试题题目动态管理 -->\r\n");
      out.write("\t\t\t<div title=\"试题题目管理\" style=\"overflow: auto;\" icon=\"icon-sys\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a target=\"mainFrame\" href=\"testQuestPage/question.html\"> <span class=\"icon icon-nav\"></span>题目列表\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"mainPanle\" region=\"center\"\r\n");
      out.write("\t\tstyle=\"background: #eee; overflow-y: hidden\">\r\n");
      out.write("\t\t<div id=\"tabs\" class=\"easyui-tabs\" fit=\"true\" border=\"false\">\r\n");
      out.write("\t\t\t<div title=\"欢迎使用\" style=\"padding: 20px; overflow: hidden;\" id=\"home\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<h1>欢迎使用考试管理系统</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!--修改密码窗口-->\r\n");
      out.write("\t<div id=\"w\" class=\"easyui-window\" title=\"修改密码\" collapsible=\"false\"\r\n");
      out.write("\t\tminimizable=\"false\" maximizable=\"false\" icon=\"icon-save\"\r\n");
      out.write("\t\tstyle=\"width: 300px; height: 150px; padding: 5px; background: #fafafa;\">\r\n");
      out.write("\t\t<div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t\t\t<div region=\"center\" border=\"false\"\r\n");
      out.write("\t\t\t\tstyle=\"padding: 10px; background: #fff; border: 1px solid #ccc;\">\r\n");
      out.write("\t\t\t\t<table cellpadding=3>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>新密码：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"txtNewPass\" type=\"Password\" class=\"txt01\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>确认密码：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"txtRePass\" type=\"Password\" class=\"txt01\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div region=\"south\" border=\"false\"\r\n");
      out.write("\t\t\t\tstyle=\"text-align: right; height: 30px; line-height: 30px;\">\r\n");
      out.write("\t\t\t\t<a id=\"btnEp\" class=\"easyui-linkbutton\" icon=\"icon-ok\"\r\n");
      out.write("\t\t\t\t\thref=\"javascript:void(0)\"> 确定</a> <a class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\t\t\ticon=\"icon-cancel\" href=\"javascript:void(0)\" onclick=\"closeLogin()\">取消</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"mm\" class=\"easyui-menu\" style=\"width: 150px;\">\r\n");
      out.write("\t\t<div id=\"mm-tabclose\">关闭</div>\r\n");
      out.write("\t\t<div id=\"mm-tabcloseall\">全部关闭</div>\r\n");
      out.write("\t\t<div id=\"mm-tabcloseother\">除此之外全部关闭</div>\r\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t<div id=\"mm-tabcloseright\">当前页右侧全部关闭</div>\r\n");
      out.write("\t\t<div id=\"mm-tabcloseleft\">当前页左侧全部关闭</div>\r\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t<div id=\"mm-exit\">退出</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/home.jsp(138,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/home.jsp(138,9) '${posts}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${posts}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/home.jsp(138,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("post");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<a target=\"mainFrame\" href=\"http://www.bioou.com/\"> <span class=\"icon icon-nav\"></span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/views/home.jsp(149,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/home.jsp(149,9) '${typeList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${typeList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/home.jsp(149,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("type");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<a target=\"mainFrame\" href=\"#\"> <span class=\"icon icon-nav\"></span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
