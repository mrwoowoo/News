<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="console_element/top.jsp" %>
<div id="main">
  <%@ include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type"> 修改主题： </h1>
    <form action="#" method="post">
      <p>
        <label> 主题名称 </label>
        <input id="tname" name="tname" type="text" class="opt_input" value=""/>
      </p>
      <input type="button" id="updateTopicSubmit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<%@ include file="console_element/bottom.html" %>
