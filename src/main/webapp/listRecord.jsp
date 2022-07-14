<%@include file="include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="LibraryWebApplication.entity.record" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Registers Of Books</strong>
			<hr/>
			<table border="1">
			<thead>
			<th>Record Id </th>
			<th>SSN</th>
			<th>Return Date</th>
			<th>Book Id </th>
		
			</thead>
			<%
			
			List<record> listRecords = (List)request.getAttribute("listRecords");
			String tempURL;
			
			int a=listRecords .size();
			
			for(int i=0;i<listRecords .size(); i++){
				out.print("<tr>");
				out.print("<td>"+listRecords .get(i).getId()+"</td>");
				out.print("<td>"+listRecords .get(i).getSsn()+"</td>");
				out.print("<td>"+listRecords .get(i).getReturn_date()+"</td>");
				out.print("<td>"+listRecords .get(i).getBook_id()+"</td>");
				
				
		
				out.print("</tr>");
			} 
			
			%>
			</table>
		</div>
	</div>
</div>

<%@include file="include/footer.jsp" %>





