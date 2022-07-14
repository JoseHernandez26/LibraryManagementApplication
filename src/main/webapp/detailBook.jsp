<%@include file="include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="LibraryWebApplication.entity.Book" %>
<%@ page import="LibraryWebApplication.entity.record" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Details Of Books</strong>
			<hr/>
			<table border="1" action="${pageContext.request.contextPath}/operation" method="post">
			<thead>
			<th>Book Id </th>
			<th>Book Name</th>
			<th>Book Type </th>
			<th>Book status </th>
		
			</thead>
		 
			<td >${param.id }</td>
			<td >${param.name} </td>
			<td > ${param.type}</td>
			<td > ${param.status}</td>
			
			</table>
		</div>
	</div>
</div>


<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong> Book lend Records  </strong>
			<hr/>
			<table  border="1" >
			<thead>
			<th>Record Id </th>
			<th>SSN</th>
			<th>Return Date</th>
			<th>Book Id </th>
		
			</thead>
				
			<%
			
			List<record> listRecords = (List)request.getAttribute("listRecords");
		
			int Id = Integer.parseInt(request.getParameter("id")) ;
			int a=listRecords .size();
			
			for(int i=0;i<listRecords .size(); i++){
				
				if(listRecords.get(i).getBook_id()==Id){
					
					
					
					
					out.print("<tr>");
					out.print("<td>"+listRecords .get(i).getId()+"</td>");
					out.print("<td>"+listRecords .get(i).getSsn()+"</td>");
					out.print("<td>"+listRecords .get(i).getReturn_date()+"</td>");
					out.print("<td>"+listRecords .get(i).getBook_id()+"</td>");
					
					
			
					out.print("</tr>");
				}
			
			} 
			
			%>
			</table>
		</div>
	</div>
</div>


<%@include file="include/footer.jsp" %>





