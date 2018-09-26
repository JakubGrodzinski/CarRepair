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
            Date of Birth
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>
                    ${customer.getId()}
            </td>
            <td>
                    ${customer.getName()}
            </td>
            <td>
                    ${customer.getSurname()}
            </td>
            <td>
                    ${customer.getDateOfBirth()}
            </td>
        </tr>


    </c:forEach>
    </tbody>
</table>



<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">Add Customer</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Add Customer</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/customers" method="post" >

                    <input type="text" name="name" placeholder="name">
                    <input type="text" name="surname" placeholder="surname">
                    <input type="date" name="date">
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
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModalModify">Modify Customer</button>

<!-- Modal -->
<div id="myModalModify" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Modify Customer</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/customers" method="post" >
                    <input type="number" placeholder="id" name="modifyId">
                    <input type="text" name="modifyName" placeholder="name">
                    <input type="text" name="modifySurname" placeholder="surname">
                    <input type="date" name="modifyDate">
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
<button type="button" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#myModalDelete">Delete Customer</button>

<!-- Modal -->
<div id="myModalDelete" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Delete Customer</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form action="/customers" method="post">
                    <input type="number" step="1" name="delId" placeholder="id">
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
