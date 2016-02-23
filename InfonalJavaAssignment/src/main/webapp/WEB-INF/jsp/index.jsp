<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>

    <script src="<c:url value="/resources/js/script.js" />"></script>

    <script src='https://www.google.com/recaptcha/api.js'></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet"
          href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mert Ozen Infonal Java</title>

</head>
<body>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">


        <h1 align="center">
            <br/>
            <span class="label label-primary">Spring Crud Example </span> <br/>
        </h1>
        <br />
        <button type="button" class="btn btn-primary" data-toggle="modal"
                data-target=".bs-example-modal-lg1">Add New User</button>
        <br />
        <br />
        <h3>User List</h3>
        <table class="table table-striped person-table-list">
            <tbody>
            <tr>
                <td><b> Name</b> </td>
                <td><b> Surname</b> </td>
                <td><b> Phone  Number</b> </td>

            </tr>
            <c:forEach var="user" items="${userList}">

                <tr data-id="${user.id}">
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.phoneNumber}</td>
                    <td><button type="button" class="btn btn btn-warning btn-update-modal"
                                data-toggle="modal" data-target=".bs-example-modal-sm" data-name="${user.name}"
                                data-surname="${user.surname}" data-id="${user.id}" data-phonenumber="${user.phoneNumber}">Update</button></td>

                    <td><button type="button"
                                class="btn btn-danger btn-delete-modal"
                                data-name="${user.name}" data-surname="${user.surname}"
                                data-id="${user.id}">Delete</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>




    </div>

    <div class="col-md-3"></div>

</div>

<!-- sm modal dialog for update record -->


<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="panel-heading">
                <h3 class="panel-title">Update Person</h3>
            </div><div class="user-update-validation" style="display:none;"></div>
            <form class="form-update-person">
                <input type="hidden" id="new-id-input" name="id">
                <table class="table">
                    <tr>
                        <td><label for="name">Name</label></td>
                        <td><input type="text" id="new-name-input" name="name"
                                   placeholder="Name" /></td>
                    </tr>
                    <tr>
                        <td><label for="name">Surname</label></td>
                        <td><input type="text" id="new-surname-input" name="surname"
                                   placeholder="Surname" /></td>
                    </tr>
                    <tr>
                        <td><label for="name">Phone Number</label></td>
                        <td><input type="text" id="new-phonenumber-input" name="phoneNumber"
                                   placeholder="Phone Number" /></td>
                    </tr>

                </table>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary btn-update-trigger"
                            data-id="">Save Changes</button>
                </div>
            </form>

        </div>
    </div>
</div>
<!--  modal dialog for update user end -->


<!-- modal dialog for new user record -->
<div class="modal fade bs-example-modal-lg1 new-person-modal" tabindex="-1"
     role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">


            <!-- panel -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Save New User</h3>
                </div>
                <div class="panel-body">
                    <!-- panel body -->
                    <div class="user-create-validation" style="display:none;"></div>
                    <form class="form-save-person">
                        <input type="hidden" name="id">
                        <table class="table">
                            <tr>
                                <td><label for="name">Name</label></td>
                                <td><input type="text" id="name-input" name="name"
                                           placeholder="Name" required="required"/></td>
                            </tr>
                            <tr>
                                <td><label for="name">Surname</label></td>
                                <td><input type="text" id="surname-input" name="surname"
                                           placeholder="Surname" /></td>
                            </tr>
                            <tr>
                                <td><label for="name">Phone Number</label></td>
                                <td><input type="text" id="phonenumber-input" name="phoneNumber"
                                           placeholder="_ ( ___ ) - ___ - __ - __"/></td>
                            </tr>
                            <tr>
                                <td><label>Security</label></td>
                                <td><div class="g-recaptcha" data-sitekey="6Ld0wRgTAAAAAAbbSNr8MnsLGqS5kS-7U4rEXHMj"></div></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><button type="button" class="btn btn-default"
                                            data-dismiss="modal">Close</button>

                                    <button type="button" class="btn btn-default btn-save">Save</button>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <!-- panel body end-->
                </div>
            </div>
            <!-- panel end -->

        </div>
    </div>
</div>
<!--  modal dialog for new user end -->

<!-- confirm dialog for delete -->
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Are you sure ?</h4>
            </div>
            <div class="modal-body">
                <!-- body -->
                <p>Are you sure to delete this person?</p>
                <div class="modal-clone-content"></div>
                <!-- body end-->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                <button type="button" class="btn btn-primary btn-delete-trigger"
                        data-id="">Yes</button>
            </div>
        </div>
    </div>
</div>
<!-- confirm dialog for delete end -->
<div align="right"><img src="resources/aload.gif" class="load" style="display: none; width: 80px; height: 80px" /></div>
</body>
</html>