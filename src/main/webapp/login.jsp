<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/includes/header.jsp" >
    <jsp:param name="pathx" value="" />
  </jsp:include>
    <title>Login</title>
</head>
<body>

  <jsp:include page="/includes/menu.jsp" />

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
  <div class="container">
    <h1>CorpDesk</h1>
    <p>You are welcome to CorpDesk portal! Please login.</p>
  </div>
</div>

<div class="container">
  <!-- Example row of columns -->
  <div class="row">
    <div class="col-md-4">
    </div>
    <div class="col-md-4">
      <div class="form-group">
        <input type="text" placeholder="Email" class="form-control">
      </div>
      <div class="form-group">
        <input type="password" placeholder="Password" class="form-control">
      </div>
      <button type="submit" class="btn btn-success">Sign in</button>
    </div>
    <div class="col-md-4">
    </div>
  </div>

  <hr>

  <jsp:include page="/includes/footer.jsp" />
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<jsp:include page="/includes/scripts.jsp" >
  <jsp:param name="pathx" value="" />
</jsp:include>




</body>
</html>
