<html>
<head>
	<title>Netomputer</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<%@ page import="org.levex.*" %>
	<%
		int rc = Netocomp.newRegisterSet(16);
		if (rc == 1) {
			%>
			<p> ERROR creating RegisterSet! </p>
			<%= RegisterSet.lastExce.toString() %>
			<%
		}
	%>
</head>
<body>
	<% 
		if(Netocomp.getRegisterSet() == null) {
			%>
			<p> ERROR! </p>
			<%
		} else {
		   for( int i = 0; i < Netocomp.getRegisterSet().size(); i++ )
		   {
			Register r = Netocomp.getRegisterSet().getRegister(i);
		%>
			<span class="register_name"><%= r.getName() %></span> = <span class="register"> <%= r.getValue() %></span>
		<% }
		} %>
	<br />
	<form method="post" action="parser.jsp">
        Instruction:
	    <input type="text" id="instr" name="instr" >
	    <input type="submit" id="btn" name="btn" value="Parse"><br/><br/>
    </form>
</body>
</html>
