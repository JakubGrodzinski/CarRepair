<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp"%>

<table class="table table-hover">
    <thead>
        <tr>
            <th>
                Id
            </th>
            <th>
                Reception Date
            </th>
            <th>
                Planned Start
            </th>
            <th>
                Employee
            </th>
            <th>
                Problem Description
            </th>
            <th>
                Solution Description
            </th>
            <th>
                Vehicle
            </th>
            <th>
                Total Cost
            </th>
            <th>
                Parts Cost
            </th>
            <th>
                Employee Hour Cost
            </th>
            <th>
                Employee Hour Quantity
            </th>
            <th>
                Status
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>
                    ${order.getId()}
                </td>
                <td>
                        ${order.getReception()}
                </td>
                <td>
                        ${order.getPlannedStart()}
                </td>
                <td>
                        ${order.getActualStart()}
                </td>
                <td>
                        ${order.getAssignedEmployee().getSurname()}
                </td>
                <td>
                        ${order.getDescriptionProblem()}
                </td>
                <td>
                        ${order.getDescriptionSolution()}
                </td>
                <td>
                        ${order.getVehicle()}
                </td>
                <td>
                        ${order.getTotalCost()}
                </td>
                <td>
                        ${order.getPartsCosts()}
                </td>
                <td>
                        ${order.getEmpHourCost()}
                </td>
                <td>
                    ${order.getEmpHoursQuantity()}
                </td>
                <td>
                    ${order.getStatus()}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">Add Order</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Add Order</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/orders" method="post" >

                    <input type="date" name="reception" placeholder="Reception Date"><br>
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


<%@include file="default/footer.jsp"%>