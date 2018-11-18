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
                Actual Start
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
                        ${order.getVehicle().getModel()}
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
                    ${order.getStatus().getStat()}
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
                    <input type="text" name="problem" placeholder="Problem Description"><br>
                    <input type="text" name="solution" placeholder="Solution Description"><br>
                    <input type="number" name="partscost" placeholder="Parts cost" step="0.01"><br>
                    <input type="number" name="emphourquantity" placeholder="Quantity of hours" step="0.01"><br>
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