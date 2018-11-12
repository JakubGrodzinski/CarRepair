<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp"%>

<table class="table table-hover">
    <thead>
        <tr>
            <th>Id</th>
            <th>Model</th>
            <th>Make</th>
            <th>Year of Production</th>
            <th>Registration Number</th>
            <th>Next servicing</th>
            <th>Assigned Customer</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${vehicles}" var="vehicle">
            <tr>
                <td>${vehicle.getId()}</td>
                <td>${vehicle.getModel()}</td>
                <td>${vehicle.getMake()}</td>
                <td>${vehicle.getYear()}</td>
                <td>${vehicle.getRegNumber()}</td>
                <td>${vehicle.getNext()}</td>
                <td>${vehicle.getCustomer().getSurname()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>


<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">Add Vehicle</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Add Vehicle</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/vehicles" method="post" >

                    <input type="text" name="model" placeholder="model"><br>
                    <input type="text" name="make" placeholder="make"><br>
                    <input type="number" step="1" name="year" placeholder="year of production"><br>
                    <input type="text" name="regnumber" placeholder="Registration number"><br>
                    <input type="date" name="nextservicing" placeholder="Next servicing"><br>
                    <input type="submit" value="Add">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<br/>
<br/>





<%@include file="default/footer.jsp"%>
