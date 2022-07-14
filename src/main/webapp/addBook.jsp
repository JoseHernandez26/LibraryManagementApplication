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
		
    <label for="fname">name</label>
    <input type="text" name="name" required="required">

    <label for="lname">type</label>
	<input type="text" name="type" required="required">
	
	  <label for="fstatus">status</label>
    <input type="text" name="status" required="required">
		
		
		
		<input type="hidden" name="form" value="AddBookOperation">
		<input type="submit" value="Add Book">
		</form>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>
</body>



