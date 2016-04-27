<%-- 
    Document   : changePassword
    Created on : 27 Apr, 2016, 1:15:08 PM
    Author     : baldeep
--%>
<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" href="../resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="../resources/css/custom.min.css">
        <script src="http://code.angularjs.org/1.2.13/angular.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <script>angular.module('mainApp', []);</script>
        <%@include file="header.html" %>
    <body ng-app="mainApp">
        <div class="container-fluid" style="padding-top: 20px;padding-bottom: 20px">
            <div class="row" style="background-color: #2196f3;">
                <div class="col-lg-7 hidden-xs">
                    <img style="margin: 15% auto;display: table;" src="../resources/images/car.png" alt="Shuttle">
                </div>
                <div class="col-lg-4" style="margin-top: 30px;" id="registerDiv">
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <form class="form-horizontal" name="changePasswordForm" action="../service/changePasswordSubmit" method="POST" novalidate>
                                <center><h4>Shuttle Change Password</h4></center>
                                <div class="form-group">
                                    <label for="inputPassword" class="col-lg-2 col-sm-2 control-label"><i class="material-icons">lock_outline</i></label>
                                    <div class="col-lg-9">
                                        <input type="password" class="form-control" ng-model="userPassword" id="inputPassword" placeholder="Password" name="userPassword" required>
                                        <p style="color:red" ng-show="changePasswordForm.userPassword.$invalid && !changePasswordForm.userPassword.$pristine">Password is required.</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword" class="col-lg-2 control-label"><i class="material-icons">lock</i></label>
                                    <div class="col-lg-9">
                                        <input type="password" ng-model="confirmPassword" name="confirmPassword" class="form-control" id="confirmPassword" placeholder="Confirm Password" required>
                                        <span style="color: red" ng-show="(userPassword !== confirmPassword) && changePasswordForm.confirmPassword.$dirty">Password mismatch</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-12">
                                        <center>
                                            <input type="submit" class="btn-lg btn-primary" value="Change Password" ng-disabled="changePasswordForm.$invalid" ></center>
                                    </div>
                                </div>
                            </form>
                            <center>Already Registered?<a href="../index.html?login"> Login</a></center>
                            <center>Not Registered?<a href="../index.html"> Register</a></center>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </body></html>
<%@include file="footer.html" %>