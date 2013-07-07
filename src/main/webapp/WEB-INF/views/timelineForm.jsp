<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<link rel="stylesheet" href="../style.css" type="text/css"/>
<html>
<head>
	<title>Register</title>
	
	<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
<div class="container">
	<div id="nav">
		<a href="/geek">Home</a> |
		
			<a href="/users/">Users</a> |
			<a href="/logout/">Sign out</a>
		
	</div>
	<h1>Java Mini Twitter</h1>
	

	<p>Welcome boy!
	Here you can store and share bookmarks!</p>
	
	<p>Hi boy!
      What is on your mind?</p>|| <%=request.getSession().getAttribute("userProfileSession") %>||
    <form:form method="POST" commandName="timelineForm">
    
	<p><label for="id_content">Say it:</label> 
	 <form:textarea path="userName"/> 
	<!-- <tr>
				<td colspan="3"><input type="submit" /></td>
			</tr> -->
	
	<table class="microposts">
	
	  <tr>
	    <td colspan="1">
	      <span class="user">
	        <a href="/users/4/">armeo11</a>
	      </span>
	      <span class="content"></span>
	      <span class="timestamp">Posted July 6, 2013, 9:28 p.m.</span>
	    </td>
	    
			<td colspan="0">
		    </td>
	    
	  </tr>
	 
	  <tr>
	    <td colspan="1">
	      <span class="user">
	        <a href="/users/6/">boy</a>
	      </span>
	      <span class="content">aaaaaaaaa</span>
	      <span class="timestamp">Posted July 6, 2013, 9:07 p.m.</span>
	    </td>
	    
		    <td colspan="0">	      
		        <a href="/microposts/15/delete/">delete</a>	      
		    </td>
		
	  </tr>
	 
	  <tr>
	    <td colspan="1">
	      <span class="user">
	        <a href="/users/2/">user1</a>
	      </span>
	      <span class="content">Test eiei</span>
	      <span class="timestamp">Posted July 6, 2013, 8:57 p.m.</span>
	    </td>
	    
			<td colspan="0">
		    </td>
	    
	  </tr>
	 
	  <tr>
	    <td colspan="1">
	      <span class="user">
	        <a href="/users/2/">user1</a>
	      </span>
	      <span class="content">hello user1</span>
	      <span class="timestamp">Posted July 3, 2013, 9:56 a.m.span>
	    </td>
	    
			<td colspan="0">
		    </td>
	    
	  </tr>
	 
	 </table>
</form:form>	


</div>
</html>
