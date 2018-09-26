
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
                    Name
                </th>
                <th>
                    Surname
                </th>
                <th>
                    Street
                </th>
                <th>
                    House number
                </th>
                <th>
                    City
                </th>
                <th>
                    Telephone Number
                </th>
                <th>
                    Note
                </th>
                <th>
                    Wage
                </th>
            </tr>
        </thead>
        <tbody>
    <c:forEach items="${empls}" var="employee">
        <tr>
            <td>
                    ${employee.getId()}
            </td>
            <td>
                    ${employee.getName()}
            </td>
            <td>
                    ${employee.getSurname()}
            </td>
            <td>
                    ${employee.getStreet()}
            </td>
            <td>
                    ${employee.getnOfHouse()}
            </td>
            <td>
                    ${employee.getCity()}
            </td>
            <td>
                    ${employee.getPhoneNum()}
            </td>
            <td>
                    ${employee.getNote()}
            </td>
            <td>
                    ${employee.getCost()}
            </td>
        </tr>


    </c:forEach>
        </tbody>
    </table>



<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">Add Employee</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Add Employee</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/employees" method="post" >

                    <input type="text" name="name" placeholder="name"><br>
                    <input type="text" name="surname" placeholder="surname"><br>
                    <input type="text" name="street" placeholder="street"><br>
                    <input type="text" name="number" placeholder="number of house"><br>
                    <input type="text" name="city" placeholder="city"><br>
                    <input type="text" name="phone" placeholder="phonenumber"><br>
                    <input type="text" name="note" placeholder="note"><br>
                    <input type="number" step="0.01" name="cost" placeholder="cost"><br>
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

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModalModify">Modify employee</button>

<!-- Modal -->
<div id="myModalModify" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Modify Employee</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/employees" method="post" >
                    <input type="number" step="1" placeholder="id" name="id"><br>
                    <input type="text" name="modname" placeholder="name"><br>
                    <input type="text" name="modsurname" placeholder="surname"><br>
                    <input type="text" name="modstreet" placeholder="street"><br>
                    <input type="text" name="modnumber" placeholder="number of house"><br>
                    <input type="text" name="modcity" placeholder="city"><br>
                    <input type="text" name="modphone" placeholder="phonenumber"><br>
                    <input type="text" name="modnote" placeholder="note"><br>
                    <input type="number" step="0.01" name="modcost" placeholder="cost"><br>
                    <input type="submit" value="Modify">
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

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#myModalDelete">Delete employee</button>

<!-- Modal -->
<div id="myModalDelete" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Delete Employee</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/employees" method="post">
                    <input type="number" step="1" name="delid" placeholder="id">
                    <input type="submit" value="Delete">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>







<%@include file="default/footer.jsp"%>



