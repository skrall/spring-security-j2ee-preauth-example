<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head><title>Spring Security PreAuth Example</title></head>
<body>
Content that users with the ROLE_USER role should be able to see.
<br>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    If you see this message, the current user has access to the <a href="<c:url value='/admin'/>">Admin</a> area.
</sec:authorize>
</body>
</html>