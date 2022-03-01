<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="classlist">
    <c:forEach items="${requestScope.list}" var="topic">
        <li>&#160;&#160;&#160;&#160;&#160;&#160;
            ${topic.tname}&#160;&#160;&#160;&#160;&#160;&#160;
            <a href="#">修改</a>&#160;&#160;&#160;&#160;&#160;&#160;
            <a href="#">删除</a>
        </li>
    </c:forEach>
</ul>