<%@taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<html>
<head>

<title><tiles:getAsString name="title"/></title>
</head>
<body>
the title is:<tiles:getAsString name="title"/><br>
<tiles:insert name="header"/><br>
<tiles:insert name="content"/><br>
<tiles:insert name="footer"/><br>
</body>
</html>
