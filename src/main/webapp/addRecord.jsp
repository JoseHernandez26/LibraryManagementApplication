<%@include file="include/header.jsp" %>


<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=email], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color:#428bca;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;

}




</style>

<body>
<div class="container mtb">
	<div class="row">
	
		<div class="col-lg-6">
		<form action="${pageContext.request.contextPath}/operation" method="post">
		
         <label for="fssn">ssn</label>
		 <input type="text" name="ssn"  required="required" /><br/>
		 
        <label for="freturn_date">Return_Date</label>
		<input type="text" name="return_date" required="required"/><br/>
		
		<label for="fbook_id">Book_id</label>
		 <input type="Number" name="book_id" value="${param.book_id }" required="required"/><br/>	
		
		
		 <input type="hidden" name="name" value="${param.name}" required="required"/><br/>
		 
      
		<input type="hidden" name="type" value="${param.type}" required="required"/><br/>
		
		 <input type="hidden" name="status" value="Busy" required="required"/><br/>	
		<input type="hidden" name="id" value="${param.id }"/>
		
		
		<input type="hidden" name="form" value="AddRecordOperation"/>
		<input type="submit" value="Add Record"/>
		</form>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>

</body>
