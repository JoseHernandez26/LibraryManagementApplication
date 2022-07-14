<%@include file="include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="LibraryWebApplication.entity.Book" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Registers Of Books</strong>
			<hr/>
			<table border="1">
			<thead>
			<th>Book Id </th>
			<th>Book Name</th>
			<th>Book Type </th>
			<th>Book status </th>
			<th>Operation</th>
		    <th>Operation</th>
		    <th>Operation</th>
			</thead>
			<%
			
			List<Book> listBooks = (List)request.getAttribute("listBooks");
			String tempURL;
			String tempURL2;
			String tempURL3;
			int a=listBooks.size();
			
			for(int i=0;i<listBooks.size(); i++){
				out.print("<tr>");
				out.print("<td>"+listBooks.get(i).getId()+"</td>");
				out.print("<td>"+listBooks.get(i).getName()+"</td>");
				out.print("<td>"+listBooks.get(i).getType()+"</td>");
				out.print("<td>"+listBooks.get(i).getStatus()+"</td>");
				tempURL = request.getContextPath()+"/operation?page=updateBook"+
						"&id="+listBooks.get(i).getId()+
						"&name="+listBooks.get(i).getName()+
						"&type="+listBooks.get(i).getType()+
						"&status="+listBooks.get(i).getStatus();
				out.print("<td><a href="+tempURL+">Update</a></td>");
				
				tempURL3 = request.getContextPath()+"/operation?page=addrecord"+
						"&id="+listBooks.get(i).getId()+
						"&book_id="+listBooks.get(i).getId()+
						"&name="+listBooks.get(i).getName()+
						"&type="+listBooks.get(i).getType()+
						"&status="+listBooks.get(i).getStatus() ;
			
				out.print("<td><a href="+tempURL3+">Lend</a></td>");
				
				tempURL2 = request.getContextPath()+"/operation?page=detailBooks" + "&id="+listBooks.get(i).getId() +
						"&name="+listBooks.get(i).getName()+
						"&type="+listBooks.get(i).getType()+
						"&status="+listBooks.get(i).getStatus();
						
				out.print("<td><a href="+tempURL2+">Details</a></td>");
				
				out.print("</tr>");
			} 
			
			%>
			</table>
		</div>
	</div>
</div>

<%@include file="include/footer.jsp" %>





