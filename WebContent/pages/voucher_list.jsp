<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "voucher.Voucher,org.apache.commons.lang3.ArrayUtils,java.sql.ResultSet"%>
<%@ include file = "../include/layout.jsp" %>
<title>Vowcher - List</title>
<script>
	$(document).ready(function(){
		$(".del-voucher").click(function(){
			window.location = $(this).attr("alt");
		});
		
		$(".edit-voucher").click(function(){
			window.location = $(this).attr("alt");
		});
		
		$("#add-voucher").click(function(){
			window.location = "voucher_add.jsp";
		});
	});
</script>
<style>
	#sub-vouch-list > li {
		font-size: 18px!important;
	}
</style>
<div id = "body-content">
	<legend>
		<h1>My Vouchers</h1>
	</legend>
	<table class = "table table-striped table-bordered">
	<%
		Voucher[] vlist;
		
		String userid = session.getAttribute("sessionUsername").toString();
		vlist = Voucher.list("USERID",userid,0);
		
		if(vlist.length == 0) %> No vouchers found <%
		for(Voucher v: vlist){
			Db db = new Db();
			db.connect();
			String query = "SELECT STATUS FROM VOUCHER_STATUS WHERE TIME = (SELECT MAX(TIME) FROM VOUCHER_STATUS WHERE VOUCHERID = " + v.getVoucherid() + ") AND VOUCHERID = " + v.getVoucherid();
			ResultSet rs = db.executeQuery(query);
			String disabled = "";
			if(rs.next()){
				if(!rs.getString(1).equals("pending")) {
					disabled = " disabled";
				}	
			}
			db.disconnect();
			%>
			<tr>
				<td>
					<a href = "voucher_view.jsp?id=<%=v.getVoucherid()%>"><%=v.getTitle() %></a>
				</td>
				<td>
					<button alt = "voucher_add.jsp?mode=edit&vid=<%=v.getVoucherid() %>" class = "btn btn-warning edit-voucher<%=disabled%>"><i class = "icon-white icon-pencil"></i>Edit</button>
				</td>
				<td>
					<button alt = "../server/delete.jsp?type=voucher&source=userlist&vid=<%=v.getVoucherid() %>" class = "del-voucher btn btn-danger<%=disabled%>"><i class = "icon-white icon-remove"></i>Delete</button>
				</td>
			</tr> <%
		}
	%>
	</table>
	<button class = "btn btn-success" id = "add-voucher"><i class = "icon-white icon-plus"></i>Add New</button>
</div>